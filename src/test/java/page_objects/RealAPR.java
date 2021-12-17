package page_objects;

import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RealAPR extends NavigationBar {
    private final By CalculatorTab = By.xpath("//label[text()='Calculator']");
    private final By HomePriceInputField = By.name("HomeValue");
    private final By DownPaymentInDollar = By.name("DownPaymentSel");
    private final By DownPaymentInputField = By.name("DownPayment");
    private final By InterestRateInputField = By.name("Interest");
    private final By CalculateRateButton = By.name("calculate");
    private final By ActualAPRRate = By.xpath("//*[@id='analysisDiv']/table[1]/tbody/tr/td/strong[text()='Actual APR:']/../../td[2]/strong");

    private static final Logger LOGGER = LogManager.getLogger(RealAPR.class);

    public WebDriver driver;

    public RealAPR(WebDriver driver) {
        this.driver = driver;
    }

    public RealAPR waitForPageToLoad() {
        LOGGER.debug("Wait for the page to load");
        ActOn.wait(driver, CalculatorTab).waitForElementToBeVisible();
        return this;
    }
    public RealAPR typeHousePrice(String value) {
        LOGGER.debug("Typing the House price: " + value);
        ActOn.elements(driver, HomePriceInputField).setValue(value);
        return this;
    }

    public RealAPR clickOnDownPaymentInDollar() {
        LOGGER.debug("Clicking on the Down Payment in Dollar");
        ActOn.elements(driver, DownPaymentInDollar).click();
        return this;
    }

    public RealAPR typeDownPayment(String value) {
        LOGGER.debug("Typing the Down Payment: " + value);
        ActOn.elements(driver, DownPaymentInputField).setValue(value);
        return this;
    }

    public RealAPR typeInterestRate(String value) {
        LOGGER.debug("Typing the Interest Rate: " + value);
        ActOn.elements(driver, InterestRateInputField).setValue(value);
        return this;
    }

    public RealAPR ClickingOnCalculateButton() {
        LOGGER.debug("Clicking on the calculate button");
        ActOn.elements(driver, CalculateRateButton).click();
        return this;
    }

    public RealAPR validateActualRealAPR(String expectedAprRate) {
        LOGGER.debug("Validate APR rate is: " + expectedAprRate);
        String actualRealAprRate = ActOn.elements(driver, ActualAPRRate).getTextValue();
        Assert.assertEquals(expectedAprRate, actualRealAprRate);
        return this;
    }
}
