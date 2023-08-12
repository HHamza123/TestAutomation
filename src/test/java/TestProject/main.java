package TestProject;

import com.google.common.base.Predicates;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.ConfigUtils;


import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class main {



    @Test(description = "Final Project", priority = 1)
    public static void main (String [] args) throws InterruptedException, IOException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hamza Aleem.SIBISOFTNS\\Downloads\\chromedriver.exe");


        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);

        Properties prop = ConfigUtils.getProps( "data");

        driver.get(prop.getProperty("URL"));
        Thread.sleep(2000);

        LoginPage loginPg = new LoginPage();
        loginPg.login(driver);


        try {
            org.openqa.selenium.support.ui.WebDriverWait wait = new org.openqa.selenium.support.ui.WebDriverWait(driver, 1 /*timeout in seconds*/);
            if (wait.until(org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent()) == null) {
                System.out.println("alert was not present");
            } else {
                System.out.println("alert was present");
                //Handle Alert here
                driver.switchTo().alert().accept();

                //driver.switchTo().alert().dismiss();
            }
        } catch (Exception e) {
            System.out.println("alert was not present");

        }

        Thread.sleep(3000);
// Assertion
        String text = driver.findElement(By.cssSelector("div.page_wrapper div.inventory_container div.inventory_list div.inventory_item:nth-child(1) div.inventory_item_description div.inventory_item_label a:nth-child(1) > div.inventory_item_name")).getText();
        if (text.contains("Sauce Labs Backpack"))
            System.out.println("Login Successfully");


        loginPg.logout(driver);
        Thread.sleep(5000);

        String url = driver.getCurrentUrl();
        System.out.println(url);


        System.out.println("Logout Successfully");
        driver.quit();

        }
   {

        }

    }

















   /*   System.setProperty("webdriver.chrome.driver","C:\\Users\\Hamza Aleem\\Downloads\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://demoqa.com/");
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
        driver.findElement(By.cssSelector("div.body-height:nth-child(2) div.home-content div.home-body div.category-cards div.card.mt-4.top-card:nth-child(2) div:nth-child(1) div.avatar.mx-auto.white > svg:nth-child(1)")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(),'Practice Form')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Hafiz");
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Hamza");
        driver.findElement(By.cssSelector(" #userEmail")).sendKeys("heavenbrave123@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath(" //label[contains(text(),'Male')]")).click();
        driver.findElement(By.xpath(" //input[@id='userNumber']")).sendKeys("034178215416");
        Thread.sleep(1000);
        driver.findElement(By.xpath(" //input[@id='dateOfBirthInput']")).click();

        // wait of 4 seconds

       driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        // choose month from dropdown

        WebElement m = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[5]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/select[1]"));
        Select s = new Select(m);
        s.selectByVisibleText("January");
        Thread.sleep(1000);

        // select day

        driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[5]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/div[3]")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#subjectsInput"))).sendKeys("English");
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.subjects-auto-complete__menu"))).click();

        // Select Hobbies

        driver.findElement(By.xpath("  //label[contains(text(),'Reading')]")).click();
        Thread.sleep(1000);

        // upload picture

        WebElement upload_file = driver.findElement(By.xpath("//input[@id='uploadPicture']"));
        upload_file.sendKeys("C:\\Users\\Hamza Aleem\\Desktop\\hamza.jpg");

        // submit

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("$('#submit').click()");
        Thread.sleep(1000);
        // Assertion Validation
        String text= driver.findElement(By.xpath("//div[@id='example-modal-sizes-title-lg']")).getText();
        if(text.contains("Thanks for submitting the form"))
            System.out.println("Foam submitted successfully");
        //Switch to frame
        js.executeScript("$('#closeLargeModal').click()");
        String title= driver.getTitle();
        System.out.println(title);
        driver.quit();


/*        driver.findElement(By.id("uploadPicture")).click();

// This will invoke AutoIT script here give the path of the script
//and this will throw IO exception so u can use throw or try catch
// In my case I am using throws

        Runtime.getRuntime().exec("C:\\Users\\Hamza Aleem\\Desktop\\AutoIT\\Blog.exe");
        Thread.sleep(5000);

// Once you will run this program AutoIt script will be invoked and respective f//ile will be attached

        String title= driver.getTitle();
        System.out.println(title);
        driver.quit();*/

    /*  WebElement products=driver.findElement(By.id("subjectsContainer"));
        products.sendKeys("English");
        products.sendKeys(Keys.ARROW_DOWN);
        products.sendKeys(Keys.ENTER); */

  /*   WebElement m1 = driver.findElement(By.id("subjectsContainer"));
       s.selectByVisibleText("Computer Science");
        Thread.sleep(1000); */












