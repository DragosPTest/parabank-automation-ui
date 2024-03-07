package UIAutomation;

import InstantiateDriver.EdgeStart;
import UtilsMethods.BillPayUtils;
import UtilsMethods.LoginUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BillPay extends EdgeStart {

    @Test
      /*
      Given I am logged in on https://parabank.parasoft.com/parabank/index.htm
      And I want to use the Bill Payment Service
      When I add the relevant details on the form
      And click on the Send Payment button
      Then I should see that my payment was completed successfully
      */
    public void payBills() throws InterruptedException {

        LoginUtils loginUtils = new LoginUtils(driver);
        loginUtils.login("username.txt", "password.txt");

        //This will send data for the Bill Payment
        BillPayUtils billPayUtils = new BillPayUtils(driver);
        billPayUtils.billUtils();


        Thread.sleep(1500);

        //Asserting that the BillPayment was successful
        String expectedTitle = driver.getTitle();
        System.out.println(expectedTitle);
        Assert.assertEquals("ParaBank | Bill Payment Complete", expectedTitle);


    }

    @Test

    /*
    Given I successfully sent a bill payment
    When I will check the success UI message
    Then I should see that the BillPayment was sent to RandomDetails
    And I should see that the amount that was sent was 100
     */

    public void checkDetails() throws InterruptedException {
        LoginUtils loginUtils = new LoginUtils(driver);
        loginUtils.login("username.txt", "password.txt");

        Thread.sleep(1000);

        WebElement getAccountNumber = driver.findElement(By.xpath(
                "//*[@id=\"accountTable\"]/tbody/tr[1]/td[1]/a"));
        String myAccountNumber = getAccountNumber.getText();
        System.out.println("My account number is: " + myAccountNumber);

        BillPayUtils billPayUtils = new BillPayUtils(driver);
        billPayUtils.billUtils();

        Thread.sleep(1000);

        //Asserting that the payee name is the one that was passed in the PayeeNAme field
        WebElement getPayeeName = driver.findElement(By.id("payeeName"));
        String payeeName = getPayeeName.getText();
        Assert.assertEquals("RandomDetails", payeeName);
        System.out.println("Payee name is: " + payeeName);

        Thread.sleep(1000);

        //Asserting that the amount paid is the one that was sent in the Amount field
        WebElement getAmount = driver.findElement(By.id("amount"));
        String amountValue = getAmount.getText();
        String parseAmount = amountValue.replaceAll("[^0-9]", "");
        int numericAmount = Integer.parseInt(parseAmount.substring(0, 3)); // Extract only the first 3 digits
        Assert.assertEquals(100, numericAmount);
        System.out.println("The amount sent is: " + numericAmount);


        //Asserting that the account from which the money were withdrawn is the correct one
        WebElement getAccount = driver.findElement(By.id("fromAccountId"));
        String accountNumber = getAccount.getText();
        Assert.assertEquals(myAccountNumber, accountNumber);
        System.out.println("The money were withdrawn from: " + accountNumber);


    }
}
