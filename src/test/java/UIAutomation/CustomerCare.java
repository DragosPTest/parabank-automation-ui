package UIAutomation;

import InstantiateDriver.EdgeStart;
import org.openqa.selenium.By;
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

    public void sendEmail(){

        WebElement clickOnEmailBox = driver.findElement(By.xpath("//*[@id=\"headerPanel\"]/ul[2]/li[3]/a"));
        clickOnEmailBox.click();
        String expectedTitle = driver.getTitle();
        System.out.println(expectedTitle);

        WebElement name = driver.findElement(By.id("name"));
        name.sendKeys("John Doe");

        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("JohnDoe@hmail.com");

        WebElement phone = driver.findElement(By.id("phone"));
        phone.sendKeys("40748123456");

        WebElement sendMessage = driver.findElement(By.id("message"));
        sendMessage.sendKeys("I love testing on your website");

        WebElement sendToCustomerCare = driver.findElement(By.xpath(
                "//*[@id=\"contactForm\"]/table/tbody/tr[5]/td[2]/input"));
        sendToCustomerCare.click();

        //Asserting that the message was successfully sent to the Customer Care Team
        WebElement thankYouMessage = driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/p[1]"));
        String getText = thankYouMessage.getText();
        Assert.assertEquals("Thank you John Doe", getText);
        System.out.println(getText);

    }


}
