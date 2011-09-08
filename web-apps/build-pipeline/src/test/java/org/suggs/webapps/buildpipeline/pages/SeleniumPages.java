package org.suggs.webapps.buildpipeline.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class to build out the selenium webdriver implementation.
 * <p/>
 * User: suggitpe
 * Date: 11/08/11
 * Time: 18:16
 */

public final class SeleniumPages extends AbstractPages {

    @SuppressWarnings("unused")
    private static final Logger LOG = LoggerFactory.getLogger( SeleniumPages.class );

    private final WebDriver webDriver = new HtmlUnitDriver( true );

    @Override
    protected WebDriver getWebDriver() {
        return webDriver;
    }
}

