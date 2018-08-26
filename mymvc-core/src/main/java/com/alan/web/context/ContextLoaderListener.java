package com.alan.web.context;

import com.alan.utils.ConfigUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * author: alan.peng
 * description:
 * date: create in 16:12 2018/8/2
 * modified By：
 */
public class ContextLoaderListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ConfigUtils.init();
        AppContext.init();

        UrlMappingRegistry.init();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
