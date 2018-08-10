package com.alan.utils;

import com.alan.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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


    public static void setContext(SessionContext ctx){
        context.set(ctx);
    }

    public static SessionContext getContext(){
        return context.get();
    }

    public static void removeContext(){
        context.remove();
    }

    public SessionContext(){

    }

    public static HttpServletRequest getRequest(){
        return (HttpServletRequest)getContext().map.get(REQUEST);
    }

    public static HttpServletResponse getResponse() {
        return (HttpServletResponse) getContext().map.get(RESPONSE);
    }

    public static HttpSession getSession() {
        return (HttpSession) getContext().map.get(SESSION);
    }

    public static Model getModel() {
        return (Model) getContext().map.get(MODEL);
    }

    public boolean containsKey(String key) {
        return map.containsKey(key);
    }

    public void put(String key,Object value) {
        map.put(key,value);
    }

    public SessionContext set(String key, Object value) {
        map.put(key,value);
        return this;
    }

    public Object get(String key) {
        return map.get(key);
    }

    public Object get(String key,Object default_) {
        if (containsKey(key)) {
            return get(key);
        }
        return default_;
    }

    public String getString(String key){
        return (String) map.get(key);
    }

    public String getString(String key, String defaultValue) {
        return map.containsKey(key) ? getString(key) : defaultValue;
    }

    public boolean getBoolean(String key) {
        return (Boolean) map.get(key);
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        return map.containsKey(key) ? getBoolean(key) : defaultValue;
    }

    public int getInt(String key) {
        return (Integer) map.get(key);
    }

    public int getInt(String key, int defaultValue) {
        return map.containsKey(key) ? getInt(key) : defaultValue;
    }
}
