package step_definitions;

import command_providers.ActOn;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import page_objects.Home;
import page_objects.RealAPR;
import utilities.ReadConfigFiles;

import java.util.List;
import java.util.Map;

public class MortgageCalculatorSteps {
    private static final Logger LOGGER = LogManager.getLogger(MortgageCalculatorSteps.class);
    WebDriver driver = Hooks.driver;

    @Given("^user is in mortgage calculator homepage$")
    public void navigateToMortgageCalculatorHomePage() {
        ActOn.browser(driver).openBrowser(ReadConfigFiles.getPropertyValues("MortgageURL"));
        LOGGER.info("Landed on the Mortgage Calculator Home Page");
     }

    @And("^user navigates to the Real APR page$")
    public void userNavigatesToRealAprPage() {
        new Home(driver)
                .mouseHoverToRates()
                .navigateToRealApr();
        LOGGER.info("Navigate to the Real APR page");
    }

    @When("^user clicks on the Calculate button upon entering data$")
    public void clickOnCalculateButtonUponEnteringData(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (Map<String, String> cells: data) {
            new RealAPR(driver)
                    .typeHousePrice(cells.get("HomePrice"))
                    .clickOnDownPaymentInDollar()
                    .typeDownPayment(cells.get("DownPayment"))
                    .typeInterestRate(cells.get("InterestRate"))
                    .ClickingOnCalculateButton();
            LOGGER.info("Entering data to calculate Real APR");
        }
    }

   @Then("^the Real APR is \"(.+?)\"$")
    public void validateRealAPR(String realApr) {
        new RealAPR(driver)
                .validateActualRealAPR(realApr);
        LOGGER.info("Validating the Real APR");
    }
}
