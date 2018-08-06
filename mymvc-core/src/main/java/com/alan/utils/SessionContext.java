package com.alan.utils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * author: alan.peng
 * description:
 * date: create in 16:24 2018/8/6
 * modified By：
 */
public class SessionContext implements Serializable {

    public static final String REQUEST = "request";
    public static final String RESPONSE = "response";
    public static final String SESSION = "session";
    public static final String FILE_UPLOAD_PARAMETERS = "fileUploadParameters";
    public static final String MODEL = "model";
    public final static String VALID_ERRORS = "validErrors";
    public final static String REQUEST_URL = "requestUrl";

    private static final ThreadLocal<SessionContext> context = new ThreadLocal<>();

    private Map<String, Object> map = new HashMap<>();

    public static SessionContext buildContext(){
        context.set(new SessionContext());
        return context.get();
    }
}
