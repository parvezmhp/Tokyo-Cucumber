package page_objects;

import command_providers.ActOn;
import command_providers.AssertThat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home extends NavigationBar {
    private final By HomeValueInputField = By.id("homeval");
    private final By DownPaymentInputField = By.id("downpayment");
    private final By SelectDownPaymentInDollar = By.name("param[downpayment_type]");
    private final By LoanAmountInputField = By.id("loanamt");
    private final By InterestRateInputField = By.id("intrstsrate");
    private final By LoanTermInputField = By.id("loanterm");
    private final By StartMonthDropDown = By.name("param[start_month]");
    private final By StartYearInputField = By.id("start_year");
    private final By PropertyTaxInputField = By.id("pptytax");
    private final By PMIInputFiled = By.id("pmi");
    private final By HOIInputField = By.id("hoi");
    private final By HOAInputField = By.id("hoa");
    private final By LoanTypeDropDown = By.name("param[milserve]");
    private final By PurchaseOptionDropDown = By.name("param[refiorbuy]");
    private final By ClickingOnCalculateButton = By.name("cal");

    private static final Logger LOGGER = LogManager.getLogger(Home.class);

    public WebDriver driver;

    public Home(WebDriver driver) {
       super(driver);
       }

    public Home typeHomePrice(String value) {
        LOGGER.debug("Typing the home price: " + value);
        ActOn.elements(driver, HomeValueInputField).setValue(value);
        return this;
    }

    public Home typeDownPayment(String value) {
        LOGGER.debug("Typing the down payment: " + value);
        ActOn.elements(driver, DownPaymentInputField).setValue(value);
        return this;
    }

    public Home clickOnDownPaymentInDollar() {
        LOGGER.debug("Clicking on the $ Radio Button");
        ActOn.elements(driver, SelectDownPaymentInDollar).click();
        return this;
    }

    public Home typeLoanAmount(String value) {
        LOGGER.debug("Typing the Loan amount: " + value);
        ActOn.elements(driver, LoanAmountInputField).setValue(value);
        return this;
    }

    public Home typeInterestRate(String value) {
        LOGGER.debug("Typing the Interest Rate: " + value);
        ActOn.elements(driver, InterestRateInputField).setValue(value);
        return this;
    }

    public Home typeLoanTermYears(String value) {
        LOGGER.debug("Typing the Loan Term: " + value);
        ActOn.elements(driver, LoanTermInputField).setValue(value);
        return this;
    }

    public Home selectMonth(String value) {
        LOGGER.debug("Selecting the start month: " + value);
        ActOn.elements(driver, StartMonthDropDown).selectValue(value);
        return this;
    }

    public Home selectYear(String value) {
        LOGGER.debug("Selecting the start month: " + value);
        ActOn.elements(driver, StartYearInputField).setValue(value);
        return this;
    }

   public Home typePropertyTax(String value) {
        LOGGER.debug("Typing the Property Tax: " + value);
       ActOn.elements(driver, PropertyTaxInputField).setValue(value);
       return this;
   }

   public Home typePMIRate(String value) {
        LOGGER.debug("Typing PMI Rate: " + value);
       ActOn.elements(driver, PMIInputFiled).setValue(value);
       return this;
   }

   public Home typeHOIAmount(String value) {
        LOGGER.debug("Typing HOI amount: " + value);
       ActOn.elements(driver, HOIInputField).setValue(value);
       return this;
   }

   public Home typeHOAAmount(String value) {
        LOGGER.debug("Typing the HOA amount: " + value);
       ActOn.elements(driver, HOAInputField).setValue(value);
       return this;
   }

   public Home selectLoanType(String value) {
        LOGGER.debug("Selecting Loan type: " + value);
       ActOn.elements(driver, LoanTypeDropDown).selectValue(value);
       return this;
   }

   public Home selectPurchaseOption(String value) {
        LOGGER.debug("Selecting Purchase option: " + value);
       ActOn.elements(driver, PurchaseOptionDropDown).selectValue(value);
       return this;
   }

   public Home clickCalculateButton() {
        LOGGER.debug("Clicking on the Calculate Button");
       ActOn.elements(driver, ClickingOnCalculateButton).click();
       return this;
   }

   public Home validateTotalMonthlyPayment(String expectedTotalMonthlyPayment) {
       String formattedXpath = String.format("//h3[text() ='$%s']",expectedTotalMonthlyPayment);
       By monthlyPayment = By.xpath(formattedXpath);
        LOGGER.debug("Validating the Total Monthly Payment is: " + expectedTotalMonthlyPayment);
       AssertThat.elementAssertions(driver, monthlyPayment).elementIsDisplayed();
        return this;
   }
}
