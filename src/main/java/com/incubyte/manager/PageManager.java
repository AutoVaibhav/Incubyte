package com.incubyte.manager;

import com.incubyte.baseClass.BaseClass;
import com.incubyte.pageObjects.gmailDraftPage.GmailDraftPage;
import org.openqa.selenium.WebDriver;

public class PageManager {
    private WebDriver driver;
    private BaseClass baseclass;
    private GmailDraftPage gmailDraftPage;


    public PageManager(WebDriver driver) {
        this.driver = driver;
    }

    public BaseClass getBaseClass() {
        return (baseclass == null) ? baseclass = new BaseClass(driver) : baseclass;
    }

    public GmailDraftPage getGmailDraftPage() {
        return (gmailDraftPage == null) ? gmailDraftPage = new GmailDraftPage(driver) : gmailDraftPage;
    }
}
