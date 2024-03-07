package UIAutomation;

import InstantiateDriver.EdgeStart;
import UtilsMethods.LoginUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountOverview extends EdgeStart {


    @Test
    /*
    Given I am an existing user
    When I navigate to https://parabank.parasoft.com/parabank/index.htm
    And I add the correct credentials for the login
    Then I should see my accounts information
    And I should see my account number, balance, available amount, total amount
    */

    public void accountOverview() throws InterruptedException {
        LoginUtils loginUtils = new LoginUtils(driver);
        loginUtils.login("username.txt", "password.txt");

        Thread.sleep(2000);


        //Asserting that the user can navigate to AccountOverview page.
        String accountOverview = driver.getTitle();
        Assert.assertEquals("ParaBank | Accounts Overview", accountOverview);

        //Getting the account details of the user
        for (int x = 1; x <= 2; x++) {
            for (int i = 1; i <= 3; i++) {
                System.out.println(driver.findElement(By.xpath("//*[@id=\"accountTable\"]/tbody/tr[" + x +
                        "]/td[" + i + "]")).getText());
            }
        }


    }
}
