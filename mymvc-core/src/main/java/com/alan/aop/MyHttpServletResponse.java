package com.alan.aop;

import com.alan.utils.SessionContext;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Locale;

/**
 * author: alan.peng
 * description:
 * date: create in 17:54 2018/8/7
 * modified By：
 */
public class MyHttpServletResponse implements HttpServletResponse {

    @Override
    public void addCookie(Cookie cookie) {
        SessionContext.getResponse().addCookie(cookie);
    }

    @Override
    public boolean containsHeader(String s) {
        return SessionContext.getResponse().containsHeader(s);
    }

    @Override
    public String encodeURL(String s) {
        return SessionContext.getResponse().encodeURL(s);
    }

    @Override
    public String encodeRedirectURL(String s) {
        return SessionContext.getResponse().encodeRedirectURL(s);
    }

    @Override
    public String encodeUrl(String s) {
        return SessionContext.getResponse().encodeURL(s);
    }

    @Override
    public String encodeRedirectUrl(String s) {
        return SessionContext.getResponse().encodeRedirectUrl(s);
    }

    @Override
    public void sendError(int i, String s) throws IOException {
        SessionContext.getResponse().sendError(i,s);
    }

    @Override
    public void sendError(int i) throws IOException {
        SessionContext.getResponse().sendError(i);
    }

    @Override
    public void sendRedirect(String s) throws IOException {
        SessionContext.getResponse().sendRedirect(s);
    }

    @Override
    public void setDateHeader(String s, long l) {
        SessionContext.getResponse().setDateHeader(s,l);
    }

    @Override
    public void addDateHeader(String s, long l) {
        SessionContext.getResponse().addDateHeader(s,l);
    }

    @Override
    public void setHeader(String s, String s1) {
        SessionContext.getResponse().setHeader(s, s1);
    }

    @Override
    public void addHeader(String s, String s1) {
        SessionContext.getResponse().addHeader(s, s1);
    }

    @Override
    public void setIntHeader(String s, int i) {
        SessionContext.getResponse().setIntHeader(s, i);
    }

    @Override
    public void addIntHeader(String s, int i) {
        SessionContext.getResponse().addIntHeader(s, i);
    }

    @Override
    public void setStatus(int i) {
        SessionContext.getResponse().setStatus(i);
    }

    @Override
    public void setStatus(int i, String s) {
        SessionContext.getResponse().setStatus(i, s);
    }

    @Override
    public int getStatus() {
        return SessionContext.getResponse().getStatus();
    }

    @Override
    public String getHeader(String s) {
        return SessionContext.getResponse().getHeader(s);
    }

    @Override
    public Collection<String> getHeaders(String s) {
        return SessionContext.getResponse().getHeaders(s);
    }

    @Override
    public Collection<String> getHeaderNames() {
        return SessionContext.getResponse().getHeaderNames();
    }

    @Override
    public String getCharacterEncoding() {
        return SessionContext.getResponse().getCharacterEncoding();
    }

    @Override
    public String getContentType() {
        return SessionContext.getResponse().getContentType();
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        return SessionContext.getResponse().getOutputStream();
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        return SessionContext.getResponse().getWriter();
    }

    @Override
    public void setCharacterEncoding(String s) {
        SessionContext.getResponse().setCharacterEncoding(s);
    }

    @Override
    public void setContentLength(int i) {
        SessionContext.getResponse().setContentLength(i);
    }

    @Override
    public void setContentLengthLong(long l) {
        SessionContext.getResponse().setContentLengthLong(l);
    }

    @Override
    public void setContentType(String s) {
        SessionContext.getResponse().setContentType(s);
    }

    @Override
    public void setBufferSize(int i) {
        SessionContext.getResponse().setBufferSize(i);
    }

    @Override
    public int getBufferSize() {
        return SessionContext.getResponse().getBufferSize();
    }

    @Override
    public void flushBuffer() throws IOException {
        SessionContext.getResponse().flushBuffer();
    }

    @Override
    public void resetBuffer() {
        SessionContext.getResponse().resetBuffer();
    }

    @Override
    public boolean isCommitted() {
        return SessionContext.getResponse().isCommitted();
    }

    @Override
    public void reset() {
        SessionContext.getResponse().reset();
    }

    @Override
    public void setLocale(Locale locale) {
        SessionContext.getResponse().setLocale(locale);
    }

    @Override
    public Locale getLocale() {
        return SessionContext.getResponse().getLocale();
    }
}
