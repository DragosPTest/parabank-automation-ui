package UIAutomation;

import InstantiateDriver.EdgeStart;
import UtilsMethods.LoginUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenNewAccount extends EdgeStart {

    /*
    Given I am existing user logged in on https://parabank.parasoft.com/parabank/index.htm
    And I navigate to Open New Account page
    When I select Checking or Savings account type
    And I click on Open New Account button
    Then I should see that my account was successfully created
    */

    @Test

    public void openAccount()throws InterruptedException{
        LoginUtils loginUtils = new LoginUtils(driver);
        loginUtils.login("username.txt", "password.txt");

        WebElement openNewAccountPage = driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/ul/li[1]/a"));
        openNewAccountPage.click();

        //Opening a Checking account

        WebElement checkingAccount = driver.findElement(By.id("type"));
        Select checking = new Select(checkingAccount);
        checking.selectByValue("0");
        Thread.sleep(1000);
        WebElement openCheckingAccountButtonClick = driver.findElement(By.xpath(
                "//*[@id=\"rightPanel\"]/div/div/form/div/input"));
        openCheckingAccountButtonClick.click();

        Thread.sleep(1000);

        //Asserting that the Checking account was successfully opened

        WebElement successfullyOpenChecking = driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/div/div/p[1]"));
        String checkingOpened = successfullyOpenChecking.getText();
        Assert.assertEquals("Congratulations, your account is now open.", checkingOpened);
        System.out.println(checkingOpened);



        //Opening a Savings account
        WebElement openNewAccountRetry = driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/ul/li[1]/a"));
        openNewAccountRetry.click();

        WebElement savingsAccount = driver.findElement(By.id("type"));
        Select savings = new Select(savingsAccount);
        savings.selectByValue("1");
        Thread.sleep(1000);
        WebElement openSavingsAccountButtonClick = driver.findElement(By.xpath(
                "//*[@id=\"rightPanel\"]/div/div/form/div/input"));
        openSavingsAccountButtonClick.click();

        Thread.sleep(1000);


        //Asserting that Savings account was successfully opened

        WebElement successfullyOpenSavings = driver.findElement(By.xpath(
                "//*[@id=\"rightPanel\"]/div/div/p[1]"));
        String savingsOpened = successfullyOpenSavings.getText();
        Assert.assertEquals("Congratulations, your account is now open.", savingsOpened);
        System.out.println(savingsOpened);
    }
}
