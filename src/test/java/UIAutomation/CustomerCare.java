package UIAutomation;

import InstantiateDriver.EdgeStart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerCare extends EdgeStart {

    @Test
    /*
    Given I navigate to https://parabank.parasoft.com/parabank/index.htm website
    And I click on the mailbox
    And I add all the necessary details on the form
    When I click on the Send To Customer Care button
    Then I should see a thank-you message with my name
    And I should see that my email was successfully sent to the customer care team
    */

    public void sendEmailToCustomerCare() {

        WebElement emailBoxElement = driver.findElement(By.xpath("//*[@id=\"headerPanel\"]/ul[2]/li[3]/a"));
        emailBoxElement.click();
        WebElement nameElement = driver.findElement(By.id("name"));
        nameElement.sendKeys("John Doe");
        WebElement emailElement = driver.findElement(By.id("email"));
        emailElement.sendKeys("email");
        WebElement phoneElement = driver.findElement(By.id("phone"));
        phoneElement.sendKeys("4074819263");
        WebElement messageElement = driver.findElement(By.id("message"));
        messageElement.sendKeys("This is a test message");
        WebElement buttonElement = driver.findElement(By.xpath(
                "//*[@id=\"contactForm\"]/table/tbody/tr[5]/td[2]/input"));
        buttonElement.click();
        WebElement getMessageElement = driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/p[1]"));
        String expectedMessage = getMessageElement.getText();
        Assert.assertEquals("Thank you John Doe", expectedMessage);
        System.out.println(expectedMessage);

    }


}
