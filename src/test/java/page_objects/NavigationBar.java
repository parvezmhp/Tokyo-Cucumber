package page_objects;

import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBar {
    private final By RatesLink = By.linkText("Rates");
    private final By RealAPRLink = By.linkText("Real APR");
    private final By MortgageCalculatorLogo = By.xpath("//a/img[@alt='Logo']");

    private static final Logger LOGGER = LogManager.getLogger(NavigationBar.class);

    public WebDriver driver;

    public NavigationBar(WebDriver driver) {
        this.driver = driver;
    }

//    Mouse hover to Rates, page doesn't change, so same return class
    public NavigationBar mouseHoverToRates() {
        LOGGER.debug("Mouse hover to Rates Link text");
        ActOn.elements(driver, RatesLink).mouseHover();
        return this;
    }

// Clicking on the Rates takes toa different page/class, so return will be RealAPR
    public RealAPR navigateToRealApr() {
        LOGGER.debug("Navigating to Rates Link");
        ActOn.elements(driver, RealAPRLink).click();
        return new RealAPR(driver);
    }

//    Clicking on Home, will take to the Home page
    public Home navigateToHome() {
        LOGGER.debug("Navigating to Home Page");
        ActOn.elements(driver, MortgageCalculatorLogo).click();
        return new Home(driver);
    }
}
