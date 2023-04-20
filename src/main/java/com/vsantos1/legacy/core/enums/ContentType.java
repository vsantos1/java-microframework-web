package com.vsantos1.legacy.core.enums;

public enum ContentType {
    APPLICATION_JSON("application/json"),
    APPLICATION_XML("application/xml"),
    APPLICATION_PDF("application/pdf"),
    APPLICATION_OCTET_STREAM("application/octet-stream"),
    APPLICATION_FORM_URLENCODED("application/x-www-form-urlencoded"),
    APPLICATION_XHTML_XML("application/xhtml+xml"),
    APPLICATION_ATOM_XML("application/atom+xml"),
    APPLICATION_RSS_XML("application/rss+xml"),
    APPLICATION_SOAP_XML("application/soap+xml"),
    APPLICATION_ZIP("application/zip"),
    APPLICATION_GZIP("application/gzip"),
    APPLICATION_TAR("application/tar"),
    APPLICATION_FONT_WOFF("application/font-woff"),
    APPLICATION_FONT_WOFF2("application/font-woff2"),
    APPLICATION_FONT_SFNT("application/font-sfnt"),
    APPLICATION_SQL("application/sql"),
    APPLICATION_LD_JSON("application/ld+json"),
    IMAGE_JPEG("image/jpeg"),
    IMAGE_PNG("image/png"),
    IMAGE_GIF("image/gif"),
    IMAGE_SVG_XML("image/svg+xml"),
    MULTIPART_FORM_DATA("multipart/form-data"),
    TEXT_HTML("text/html"),
    TEXT_PLAIN("text/plain"),
    TEXT_XML("text/xml"),
    TEXT_CSS("text/css"),
    AUDIO_MPEG("audio/mpeg"),
    AUDIO_MP4("audio/mp4"),
    AUDIO_OGG("audio/ogg"),
    AUDIO_WAV("audio/wav"),
    VIDEO_MP4("video/mp4"),
    VIDEO_MPEG("video/mpeg"),
    VIDEO_OGG("video/ogg"),
    VIDEO_QUICKTIME("video/quicktime"),
    VIDEO_WEBM("video/webm");

    private final String value;

    ContentType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}