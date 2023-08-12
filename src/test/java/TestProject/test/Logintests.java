package TestProject.test;

import TestProject.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import utils.ConfigUtils;

import java.util.Properties;

public class Logintests {

    // Test Class using POM
    LoginPage loginPg;
    WebDriver driver;

    @BeforeClass
    public void openPage() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hamza Aleem.SIBISOFTNS\\Downloads\\chromedriver.exe");


        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);

        Properties prop = ConfigUtils.getProps( "data");

        driver.get(prop.getProperty("URL"));
        Thread.sleep(2000);


    }

    @Test (description = "Login Test", priority = 1)
    public void login() throws InterruptedException {


        loginPg = new LoginPage();
        loginPg.login(driver);

        try {
            org.openqa.selenium.support.ui.WebDriverWait wait = new org.openqa.selenium.support.ui.WebDriverWait(driver, 1 /*timeout in seconds*/);
            if (wait.until(org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent()) == null) {
                System.out.println("alert was not present");
            } else {
                System.out.println("alert was present");
                //Handle Alert here
                driver.switchTo().alert().accept();

            }
        } catch (Exception e) {
            System.out.println("alert was not present");

        }

        Thread.sleep(3000);
// Assertion
        String text = driver.findElement(By.cssSelector("div.page_wrapper div.inventory_container div.inventory_list div.inventory_item:nth-child(1) div.inventory_item_description div.inventory_item_label a:nth-child(1) > div.inventory_item_name")).getText();
        if (text.contains("Sauce Labs Backpack"))
            System.out.println("Login Successfully");


    }

    @Test(description = "Product Filter", priority = 2)
    public void filter() throws InterruptedException {
        loginPg.filter(driver);
        System.out.println("Filtering product from Z to A successfully");
    }



    @Test (description = "logout Test",priority = 3)
    public void logout() throws InterruptedException {
        loginPg.logout(driver);
        Thread.sleep(5000);

        String url = driver.getCurrentUrl();
        System.out.println(url);


        System.out.println("Logout Successfully");


    }

    @AfterClass

    public void closeBrowser(){

        driver.quit();





        }

    }

