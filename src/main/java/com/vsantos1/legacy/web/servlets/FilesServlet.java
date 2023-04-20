package com.vsantos1.legacy.web.servlets;

import com.vsantos1.legacy.core.enums.ContentType;
import com.vsantos1.legacy.core.enums.HttpStatus;
import com.vsantos1.legacy.core.response.Response;
import com.vsantos1.legacy.core.upload.FileUpload;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "files", urlPatterns = "/files")
public class FilesServlet extends HttpServlet {

    private final FileUpload file;

    public FilesServlet() {
        this.file = new FileUpload();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String fileName = req.getParameter("name");

        Response.status(HttpStatus.OK).body(file.getFileFromDisk(fileName)).build(resp, ContentType.IMAGE_JPEG);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
