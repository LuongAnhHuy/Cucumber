package org.automation.steps.uiChrome;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.automation.webdriver.WebDriverFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuruTestChrome extends WebDriverFactory {
    WebDriver driver;
    public static final String USER_ID = "//input[@name='uid']";
    public static final String PASSWORD_TEXTBOX = "//input[@name='password']";
    public static final String LOGIN_BUTTON = "//input[@name='btnLogin']";
    public static final String HEADING = "//marquee[@class='heading3']";
    @When("I open page on Guru {string}")
    public void iOpenPageOnGuru(String pageUrl) {

        getDriver().get(pageUrl);
    }

    @And("I click to login button")
    public void i_click_to_login_button(){
        getDriver().findElement(By.xpath(LOGIN_BUTTON)).click();
    }

    @Then("I verify homepage name {string}")
    public void iVerifyHomepageName(String expected) {
        String actual = getDriver().findElement(By.xpath(HEADING)).getText();
        assertEquals(actual, expected);
    }


    @And("I fill {string} to username")
    public void iFillToUsername(String username) {
        getDriver().findElement(By.xpath(USER_ID)).sendKeys(username);
    }

    @And("I fill {string} to password")
    public void iFillToPassword(String password) {
        getDriver().findElement(By.xpath(PASSWORD_TEXTBOX)).sendKeys(password);
    }
}
