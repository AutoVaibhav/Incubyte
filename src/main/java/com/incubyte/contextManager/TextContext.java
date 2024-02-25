package com.incubyte.contextManager;

import com.incubyte.manager.DriverManager;
import com.incubyte.manager.PageManager;

public class TextContext {
    private DriverManager driverManager;
    private PageManager pageManager;

    public TextContext(){
        driverManager = new DriverManager();
        pageManager = new PageManager(driverManager.getDriverForLaunch());
    }

    public DriverManager getDriverManager() {
        return driverManager;
    }

    public PageManager getPageManager() {
        return pageManager;
    }
}
