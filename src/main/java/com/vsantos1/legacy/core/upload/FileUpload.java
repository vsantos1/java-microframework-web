// https://github.com/vsantos1



/*
 * Copyright (c)  @vsantos1 - https://github.com/vsantos1
 * 2022-2023.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.vsantos1.legacy.core.upload;

import com.vsantos1.legacy.core.enums.HttpStatus;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

public class FileUpload {
    private String uploadDir = System.getProperty("user.home");

    private final Logger logger = Logger.getLogger(FileUpload.class.getName());
    private final List<String> ALLOWED_VIDEO_EXTENSIONS = List.of("mp4", "webm", "ogg", "ogv", "avi", "wmv", "mov", "flv", "3gp", "3g2", "mkv");

    private final List<String> ALLOWED_AUDIO_EXTENSIONS = List.of("mp3", "wav", "ogg", "oga", "flac", "m4a", "aac", "wma", "webm", "opus");

    private final List<String> ALLOWED_DOCUMENT_EXTENSIONS = List.of("pdf", "doc", "docx", "xls", "xlsx", "ppt", "pptx", "odt", "ods", "odp", "odg", "odc", "odf", "txt", "rtf", "csv", "tsv", "tex", "xml");

    private final List<String> ALLOWED_IMAGE_EXTENSIONS = List.of("jpg", "jpeg", "png", "gif", "bmp", "svg", "webp");

    private final List<String> ALLOWED_ARCHIVE_EXTENSIONS = List.of("zip", "rar", "7z", "tar", "gz", "bz2", "xz");

    protected void createDirectory(String path) {
        File uploadDir = new File(path);

        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
    }

    protected void setPathContext(String folderName) {
        String DIR = this.uploadDir + File.separator + "uploads";


        if (!folderName.isEmpty() || !folderName.isBlank()) {
            this.uploadDir = this.uploadDir + File.separator + folderName;

        } else {
            this.uploadDir = DIR;
        }
    }


    /**
     * @param fileName String
     * @param part     Part
     * @return void
     */
    protected void saveFile(String fileName, Part part) {

        File file = new File(uploadDir, fileName);

        try (InputStream input = part.getInputStream()) {
            Files.copy(input, file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * @param unique   boolean
     * @param fileName String
     * @return String
     */
    protected String generateUniqueFilename(boolean unique, String fileName) {


        if (unique) {
            String fileExtension = fileName.substring(fileName.lastIndexOf('.') + 1);
            fileName = fileName.replace(fileName.substring(fileName.lastIndexOf('.')), "");
            return fileName + "_" + UUID.randomUUID() + "." + fileExtension;
        }

        return fileName;

    }

    protected void isSizeAllowed(Part part, int maxFileSize) throws IOException {

        // 1MB
        int DEFAULT_FILE_SIZE = 1024 * 1024;

        maxFileSize = DEFAULT_FILE_SIZE * maxFileSize;

        logger.info("File size: " + part.getSize() * DEFAULT_FILE_SIZE);

        if (part.getSize() > maxFileSize) {
            throw new IOException("File size is too large");
        }
    }

    /**
     * @param folderName String
     * @param fileName   String
     * @param part       Part
     */
    protected void execute(String folderName, String fileName, Part part, boolean unique) {
        fileName = this.generateUniqueFilename(unique, fileName);

        this.setPathContext(folderName);

        this.createDirectory(this.uploadDir);

        this.saveFile(fileName, part);
    }

    /**
     * @param parts       Collection<Part>
     * @param folderName  String
     * @param unique      boolean
     * @param maxFileSize int (MB)
     * @return void
     */
    public void multipleFileUpload(Collection<Part> parts, String folderName, boolean unique, int maxFileSize) {

        try {
            for (Part part : parts) {
                this.fileUpload(part, folderName, unique, maxFileSize);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * @param part        Part
     * @param folderName  String
     * @param unique      boolean
     * @param maxFileSize int (MB)
     * @return void
     * @throws Exception IOException
     */

    public void archiveUpload(Part part, String folderName, boolean unique, int maxFileSize) throws Exception {
        // Get the filename and extension
        String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
        String fileExtension = fileName.substring(fileName.lastIndexOf('.') + 1);

        if (!ALLOWED_ARCHIVE_EXTENSIONS.contains(fileExtension)) {
            throw new IOException("Invalid archive file extension type");
        }

        // Check if the file size is allowed
        this.isSizeAllowed(part, maxFileSize);

        // Do the magic
        this.execute(folderName, fileName, part, unique);

    }

    /**
     * @param part        Part
     * @param folderName  String
     * @param unique      boolean
     * @param maxFileSize int (MB)
     * @return void
     * @throws Exception IOException
     */

    public void documentUpload(Part part, String folderName, boolean unique, int maxFileSize) throws Exception {
        // Get the filename and extension
        String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
        String fileExtension = fileName.substring(fileName.lastIndexOf('.') + 1);

        if (!ALLOWED_DOCUMENT_EXTENSIONS.contains(fileExtension)) {
            throw new IOException("Invalid document file extension type");
        }

        // Check if the file size is allowed
        this.isSizeAllowed(part, maxFileSize);

        // Check if the file size is allowed
        this.isSizeAllowed(part, maxFileSize);

        // Do the magic
        this.execute(folderName, fileName, part, unique);

    }

    /**
     * @param part        Part
     * @param folderName  String
     * @param unique      boolean
     * @param maxFileSize int (MB)
     * @return void
     * @throws Exception IOException
     */
    public void audioUpload(Part part, String folderName, boolean unique, int maxFileSize) throws Exception {


        // Get the filename and extension
        String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
        String fileExtension = fileName.substring(fileName.lastIndexOf('.') + 1);

        if (!ALLOWED_AUDIO_EXTENSIONS.contains(fileExtension)) {
            throw new IOException("Invalid audio file extension type");
        }

        // Check if the file size is allowed
        this.isSizeAllowed(part, maxFileSize);


        // Check if the file size is allowed
        this.isSizeAllowed(part, maxFileSize);

        // Do the magic
        this.execute(folderName, fileName, part, unique);

    }

    /**
     * @param part        Part
     * @param folderName  String
     * @param unique      boolean
     * @param maxFileSize int (MB)
     * @return void
     * @throws IOException
     */
    public void videoUpload(Part part, String folderName, boolean unique, int maxFileSize) throws IOException {

        // Get the filename and extension
        String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
        String fileExtension = fileName.substring(fileName.lastIndexOf('.') + 1);

        if (!ALLOWED_VIDEO_EXTENSIONS.contains(fileExtension)) {
            throw new IOException("Invalid video file extension type");
        }

        // Check if the file size is allowed
        this.isSizeAllowed(part, maxFileSize);

        // Do the magic
        this.execute(folderName, fileName, part, unique);

    }

    /**
     * @param part        Part
     * @param folderName  String
     * @param unique      boolean
     * @param maxFileSize int (MB)
     * @return void
     * @throws IOException
     */
    public void fileUpload(Part part, String folderName, boolean unique, int maxFileSize) throws IOException {

        // Check if the file size is allowed
        this.isSizeAllowed(part, maxFileSize);

        // Get the filename and extension
        String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();


        // Do the magic
        this.execute(folderName, fileName, part, unique);

    }

    /**
     * @param part        Part
     * @param folderName  String
     * @param unique      boolean
     * @param maxFileSize int (MB)
     * @return void
     * @throws IOException
     */
    public void imageUpload(Part part, String folderName, boolean unique, int maxFileSize) throws IOException {

        // Get the filename and extension
        String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
        String fileExtension = fileName.substring(fileName.lastIndexOf('.') + 1);

        if (!ALLOWED_IMAGE_EXTENSIONS.contains(fileExtension)) {
            throw new IOException("Invalid image file extension type");
        }

        // Check if the file size is allowed
        this.isSizeAllowed(part, maxFileSize);

        // Do the magic
        this.execute(folderName, fileName, part, unique);
    }

    public void downloadFileFromDisk(String fileName, HttpServletResponse response) throws IOException {
        String filePath = this.uploadDir + File.separator + "uploads" + File.separator + fileName;

        Path file = Paths.get(filePath);

        if (Files.exists(file)) {
            response.setContentType("application/octet-stream");
            response.setStatus(HttpStatus.OK.getValue());
            response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

            try (InputStream in = Files.newInputStream(file)) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    response.getOutputStream().write(buffer, 0, bytesRead);
                }
            }
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "File not found");
        }
    }

    public byte[] getFileFromDisk(String fileName) throws IOException {
        String filePath = this.uploadDir + File.separator + "uploads" + File.separator + fileName;

        Path file = Paths.get(filePath);

        if (Files.exists(file)) {
            return Files.readAllBytes(file);
        } else {
            throw new IOException("File not found");
        }
    }

    public void deleteFileFromDisk(String fileName) throws IOException {
        String filePath = this.uploadDir + File.separator + "uploads" + File.separator + fileName;

        Path file = Paths.get(filePath);

        if (Files.exists(file)) {
            Files.delete(file);
        } else {
            throw new IOException("File not found");
        }
    }
}
