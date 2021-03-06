package step_definitions;

import command_providers.ActOn;
import command_providers.AssertThat;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ReadConfigFiles;

import java.util.List;
import java.util.Map;

public class LoginSteps {
    private static final By FullName = By.id("name");
    private static final By Password = By.id("password");
    private static final By Login = By.id("login");
    private static final By Logout = By.id("logout");
    private static final By InvalidPassword = By.xpath("//*[@id='pageLogin']/form//div[text()='Password is invalid']");

    private static final Logger LOGGER = LogManager.getLogger(LoginSteps.class);
    WebDriver driver = Hooks.driver;

    @Given("^a user is on the login page$")
    public void navigateToLogInPage() {
        ActOn.browser(driver).openBrowser(ReadConfigFiles.getPropertyValues("TestAppURL"));
        LOGGER.info("user is on the login page");
    }

    @When("^user enters username \"(.+?)\" and password \"(.+?)\"$")
    public void enterUserCredentials(String username, String password) {
        ActOn.elements(driver, FullName).setValue(username);
        ActOn.elements(driver, Password).setValue(password);
        LOGGER.info("User has entered credentials");
    }

    @And("^user clicks on login button$")
    public void clickOnLogin() {
        ActOn.elements(driver, Login).click();
        LOGGER.info("User clicked on Login button");
    }

    @When("^user clicks on login button upon entering credentials")
    public void userClickOnLoginUponEnteringCredentials(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (Map<String, String> cells: data) {
            ActOn.elements(driver, FullName).setValue(cells.get("username"));
            ActOn.elements(driver, Password).setValue(cells.get("password"));
            LOGGER.info("User has entered credentials");

            ActOn.elements(driver, Login).click();
            LOGGER.info("User clicked on the login button");
        }
    }

    @Then("^user is navigated to home page$")
    public void validateUserIsLoggedInSuccessfully() {
        AssertThat.elementAssertions(driver, Logout).elementIsDisplayed();
        LOGGER.info("User is in Home Page");
    }

    @Then("^user is failed to login$")
    public void validateUserFailedToLogin() {
        AssertThat.elementAssertions(driver, InvalidPassword).elementIsDisplayed();
        LOGGER.info("User is still on the login page");
    }
}
