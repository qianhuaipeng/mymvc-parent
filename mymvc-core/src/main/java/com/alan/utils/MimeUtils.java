package com.alan.utils;

import javax.activation.MimetypesFileTypeMap;

/**
 * author: alan.peng
 * description:
 * date: create in 13:38 2018/9/10
 * modified By：
 */
public class MimeUtils {

    private static final MimetypesFileTypeMap MIMETYPES_MAP = new MimetypesFileTypeMap();

    public static String getMimeType(String extension){
        if ("css".equals(extension))
            return "text/css";
        return MIMETYPES_MAP.getContentType("x." + extension);
    }
}
