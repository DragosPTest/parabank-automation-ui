package UIAutomation;

import AccountsData.Account;
import InstantiateDriver.EdgeStart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Register extends EdgeStart {


    @Test
    /*
    Given I navigate to Edge
    When I access https://parabank.parasoft.com/parabank/index.htm website
    Then I should see that the website loads successfully
    */

    public void accessTheWebsite() {
        String expectedTitle = driver.getTitle();
        System.out.println(expectedTitle);
        Assert.assertEquals(expectedTitle, "ParaBank | Welcome | Online Banking");


    }


    @Test
     /*
     Given I am a new user
     And I navigate to https://parabank.parasoft.com/parabank/index.htm
     When I click on the register button
     And I fill the registration form with valid data
     Then I should see that I am successfully registered on the website
     */

    public void userRegister() {
        String generatedUserName = Account.generateUserName();
        String generatedPassword = Account.generatePassword();

        WebElement registrationForm = driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/p[2]/a"));
        registrationForm.click();

        for (int sendDetails = 1; sendDetails <= 13; sendDetails++) {
            if (sendDetails == 9) {
                continue;
            }

            WebElement registrationDetails = driver.findElement(By.xpath(
                    "//*[@id=\"customerForm\"]/table/tbody/tr[" + sendDetails + "]/td/input"));
            if (sendDetails == 1) {
                registrationDetails.sendKeys("John");
            } else if (sendDetails == 2) {
                registrationDetails.sendKeys("Doe");
            } else if (sendDetails == 3) {
                registrationDetails.sendKeys("Address");
            } else if (sendDetails == 4) {
                registrationDetails.sendKeys("Bucharest");
            } else if (sendDetails == 5) {
                registrationDetails.sendKeys("Romania");
            } else if (sendDetails == 6) {
                registrationDetails.sendKeys("12345");
            } else if (sendDetails == 7) {
                registrationDetails.sendKeys("40748192345");
            } else if (sendDetails == 8) {
                registrationDetails.sendKeys("1934124566");
            } else if (sendDetails == 10) {
                registrationDetails.sendKeys(generatedUserName);
                System.out.println("The username is:" + generatedUserName);
            } else if (sendDetails == 11) {
                registrationDetails.sendKeys(generatedPassword);
            } else if (sendDetails == 12) {
                registrationDetails.sendKeys(generatedPassword);
                System.out.println("The password is:" +generatedPassword);
            } else if (sendDetails == 13) {
                registrationDetails.click();
            }
        }

        //Asserting that the user was able to register successfully
        WebElement registrationConfirmation = driver.findElement(By.xpath(
                "//*[@id=\"rightPanel\"]/p"));
        String successfulRegistrationText = registrationConfirmation.getText();
        System.out.println("Account creation message:" + successfulRegistrationText);
        Assert.assertEquals("Your account was created successfully. You are now logged in.",
                successfulRegistrationText);


    }
}
