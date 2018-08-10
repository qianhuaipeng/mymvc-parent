package com.alan.aop;

import com.alan.utils.SessionContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.util.Enumeration;

/**
 * author: alan.peng
 * description:
 * date: create in 16:22 2018/8/6
 * modified By：
 */
public class MyHttpSession implements HttpSession {
    @Override
    public long getCreationTime() {
        return SessionContext.getSession().getCreationTime();
    }

    @Override
    public String getId() {
        return SessionContext.getSession().getId();
    }

    @Override
    public long getLastAccessedTime() {
        return SessionContext.getSession().getLastAccessedTime();
    }

    @Override
    public ServletContext getServletContext() {
        return SessionContext.getSession().getServletContext();
    }

    @Override
    public void setMaxInactiveInterval(int i) {
        SessionContext.getSession().setMaxInactiveInterval(i);
    }

    @Override
    public int getMaxInactiveInterval() {
        return SessionContext.getSession().getMaxInactiveInterval();
    }

    @Override
    public HttpSessionContext getSessionContext() {
        return SessionContext.getSession().getSessionContext();
    }

    @Override
    public Object getAttribute(String s) {
        return SessionContext.getSession().getAttribute(s);
    }

    @Override
    public Object getValue(String s) {
        return SessionContext.getSession().getValue(s);
    }

    @Override
    public Enumeration<String> getAttributeNames() {
        return SessionContext.getSession().getAttributeNames();
    }

    @Override
    public String[] getValueNames() {
        return SessionContext.getSession().getValueNames();
    }

    @Override
    public void setAttribute(String s, Object o) {
        SessionContext.getSession().setAttribute(s,o);
    }

    @Override
    public void putValue(String s, Object o) {
        SessionContext.getSession().putValue(s,o);
    }

    @Override
    public void removeAttribute(String s) {
        SessionContext.getSession().removeAttribute(s);
    }

    @Override
    public void removeValue(String s) {
        SessionContext.getSession().removeValue(s);
    }

    @Override
    public void invalidate() {
        SessionContext.getSession().invalidate();
    }

    @Override
    public boolean isNew() {
        return SessionContext.getSession().isNew();
    }
}
