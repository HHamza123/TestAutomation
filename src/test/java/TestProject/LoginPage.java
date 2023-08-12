package TestProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    // Page Class using POM
    public void login (WebDriver driver) {

        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

    }

    // Filter Product
    public void filter(WebDriver driver) throws InterruptedException {

     driver.findElement(By.xpath("//option[contains(text(),'Name (Z to A)')]")).click();
     Thread.sleep(2000);

    }


    public void logout (WebDriver driver) throws InterruptedException {

        driver.findElement(By.id("react-burger-menu-btn")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("logout_sidebar_link")).click();



         //     driver.quit();
        //      driver.close();

    }


}
