package com.alan.aop;

import com.alan.utils.SessionContext;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

/**
 * author: alan.peng
 * description:
 * date: create in 17:54 2018/8/7
 * modified By：
 */
public class MyHttpServletRequest implements HttpServletRequest {

    public MyHttpServletRequest() {
    }

    @Override
    public String getAuthType() {
        return SessionContext.getRequest().getAuthType();
    }

    @Override
    public Cookie[] getCookies() {
        return SessionContext.getRequest().getCookies();
    }

    @Override
    public long getDateHeader(String s) {
        return SessionContext.getRequest().getDateHeader(s);
    }

    @Override
    public String getHeader(String s) {
        return SessionContext.getRequest().getHeader(s);
    }

    @Override
    public Enumeration<String> getHeaders(String s) {
        return SessionContext.getRequest().getHeaders(s);
    }

    @Override
    public Enumeration<String> getHeaderNames() {
        return SessionContext.getRequest().getHeaderNames();
    }

    @Override
    public int getIntHeader(String s) {
        return SessionContext.getRequest().getIntHeader(s);
    }

    @Override
    public String getMethod() {
        return SessionContext.getRequest().getMethod();
    }

    @Override
    public String getPathInfo() {
        return SessionContext.getRequest().getPathInfo();
    }

    @Override
    public String getPathTranslated() {
        return SessionContext.getRequest().getPathTranslated();
    }

    @Override
    public String getContextPath() {
        return SessionContext.getRequest().getContextPath();
    }

    @Override
    public String getQueryString() {
        return SessionContext.getRequest().getQueryString();
    }

    @Override
    public String getRemoteUser() {
        return SessionContext.getRequest().getRemoteUser();
    }

    @Override
    public boolean isUserInRole(String s) {
        return SessionContext.getRequest().isUserInRole(s);
    }

    @Override
    public Principal getUserPrincipal() {
        return SessionContext.getRequest().getUserPrincipal();
    }

    @Override
    public String getRequestedSessionId() {
        return SessionContext.getRequest().getRequestedSessionId();
    }

    @Override
    public String getRequestURI() {
        return SessionContext.getRequest().getRequestURI();
    }

    @Override
    public StringBuffer getRequestURL() {
        return SessionContext.getRequest().getRequestURL();
    }

    @Override
    public String getServletPath() {
        return SessionContext.getRequest().getServletPath();
    }

    @Override
    public HttpSession getSession(boolean b) {
        return SessionContext.getRequest().getSession(b);
    }

    @Override
    public HttpSession getSession() {
        return SessionContext.getRequest().getSession();
    }

    @Override
    public String changeSessionId() {
        return SessionContext.getRequest().changeSessionId();
    }

    @Override
    public boolean isRequestedSessionIdValid() {
        return SessionContext.getRequest().isRequestedSessionIdValid();
    }

    @Override
    public boolean isRequestedSessionIdFromCookie() {
        return SessionContext.getRequest().isRequestedSessionIdFromCookie();
    }

    @Override
    public boolean isRequestedSessionIdFromURL() {
        return SessionContext.getRequest().isRequestedSessionIdFromURL();
    }

    @Override
    public boolean isRequestedSessionIdFromUrl() {
        return SessionContext.getRequest().isRequestedSessionIdFromUrl();
    }

    @Override
    public boolean authenticate(HttpServletResponse httpServletResponse) throws IOException, ServletException {
        return SessionContext.getRequest().authenticate(httpServletResponse);
    }

    @Override
    public void login(String s, String s1) throws ServletException {
        SessionContext.getRequest().login(s,s1);
    }

    @Override
    public void logout() throws ServletException {
        SessionContext.getRequest().logout();
    }

    @Override
    public Collection<Part> getParts() throws IOException, ServletException {
        return SessionContext.getRequest().getParts();
    }

    @Override
    public Part getPart(String s) throws IOException, ServletException {
        return SessionContext.getRequest().getPart(s);
    }

    @Override
    public <T extends HttpUpgradeHandler> T upgrade(Class<T> aClass) throws IOException, ServletException {
        return SessionContext.getRequest().upgrade(aClass);
    }

    @Override
    public Object getAttribute(String s) {
        return SessionContext.getRequest().getAttribute(s);
    }

    @Override
    public Enumeration<String> getAttributeNames() {
        return SessionContext.getRequest().getAttributeNames();
    }

    @Override
    public String getCharacterEncoding() {
        return SessionContext.getRequest().getCharacterEncoding();
    }

    @Override
    public void setCharacterEncoding(String s) throws UnsupportedEncodingException {
        SessionContext.getRequest().setCharacterEncoding(s);
    }

    @Override
    public int getContentLength() {
        return SessionContext.getRequest().getContentLength();
    }

    @Override
    public long getContentLengthLong() {
        return SessionContext.getRequest().getContentLengthLong();
    }

    @Override
    public String getContentType() {
        return SessionContext.getRequest().getContentType();
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        return SessionContext.getRequest().getInputStream();
    }

    @Override
    public String getParameter(String s) {
        return SessionContext.getRequest().getParameter(s);
    }

    @Override
    public Enumeration<String> getParameterNames() {
        return SessionContext.getRequest().getParameterNames();
    }

    @Override
    public String[] getParameterValues(String s) {
        return SessionContext.getRequest().getParameterValues(s);
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        return SessionContext.getRequest().getParameterMap();
    }

    @Override
    public String getProtocol() {
        return SessionContext.getRequest().getProtocol();
    }

    @Override
    public String getScheme() {
        return SessionContext.getRequest().getScheme();
    }

    @Override
    public String getServerName() {
        return SessionContext.getRequest().getServerName();
    }

    @Override
    public int getServerPort() {
        return SessionContext.getRequest().getServerPort();
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return SessionContext.getRequest().getReader();
    }

    @Override
    public String getRemoteAddr() {
        return SessionContext.getRequest().getRemoteAddr();
    }

    @Override
    public String getRemoteHost() {
        return SessionContext.getRequest().getRemoteHost();
    }

    @Override
    public void setAttribute(String s, Object o) {
        SessionContext.getRequest().setAttribute(s,o);
    }

    @Override
    public void removeAttribute(String s) {
        SessionContext.getRequest().removeAttribute(s);
    }

    @Override
    public Locale getLocale() {
        return SessionContext.getRequest().getLocale();
    }

    @Override
    public Enumeration<Locale> getLocales() {
        return SessionContext.getRequest().getLocales();
    }

    @Override
    public boolean isSecure() {
        return SessionContext.getRequest().isSecure();
    }

    @Override
    public RequestDispatcher getRequestDispatcher(String s) {
        return SessionContext.getRequest().getRequestDispatcher(s);
    }

    @Override
    public String getRealPath(String s) {
        return SessionContext.getRequest().getRealPath(s);
    }

    @Override
    public int getRemotePort() {
        return SessionContext.getRequest().getRemotePort();
    }

    @Override
    public String getLocalName() {
        return SessionContext.getRequest().getLocalName();
    }

    @Override
    public String getLocalAddr() {
        return SessionContext.getRequest().getLocalAddr();
    }

    @Override
    public int getLocalPort() {
        return SessionContext.getRequest().getLocalPort();
    }

    @Override
    public ServletContext getServletContext() {
        return SessionContext.getRequest().getServletContext();
    }

    @Override
    public AsyncContext startAsync() throws IllegalStateException {
        return SessionContext.getRequest().startAsync();
    }

    @Override
    public AsyncContext startAsync(ServletRequest servletRequest, ServletResponse servletResponse) throws IllegalStateException {
        return SessionContext.getRequest().startAsync(servletRequest,servletResponse);
    }

    @Override
    public boolean isAsyncStarted() {
        return SessionContext.getRequest().isAsyncStarted();
    }

    @Override
    public boolean isAsyncSupported() {
        return SessionContext.getRequest().isAsyncSupported();
    }

    @Override
    public AsyncContext getAsyncContext() {
        return SessionContext.getRequest().getAsyncContext();
    }

    @Override
    public DispatcherType getDispatcherType() {
        return SessionContext.getRequest().getDispatcherType();
    }
}
