package TestProject.test;

import TestProject.LoginPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import utils.ConfigUtils;

import java.util.Properties;

public class loginsteps {



    private WebDriver driver;
    private LoginPage loginPage = new LoginPage();

    public void user_is_on_the_login_page() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hamza Aleem.SIBISOFTNS\\Downloads\\chromedriver.exe");


        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);

        Properties prop = ConfigUtils.getProps( "data");

        driver.get(prop.getProperty("URL"));
        Thread.sleep(2000);

    }

    @When("User enters valid username and password")
    public void user_enters_valid_username_and_password() {
        loginPage.login(driver);
    }

    @And("User clicks the login button")
    public void user_clicks_the_login_button() {

    }

    @Then("User should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        // Your existing assertion
    }

    @When("User clicks the logout button")
    public void user_clicks_the_logout_button() throws InterruptedException {
        loginPage.logout(driver);
        Thread.sleep(5000);
    }

    @Then("User should be logged out successfully")
    public void user_should_be_logged_out_successfully() {
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("logout_page_url"));
    }
}
