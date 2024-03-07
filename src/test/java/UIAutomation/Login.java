package UIAutomation;

import InstantiateDriver.EdgeStart;
import UtilsMethods.LoginUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login extends EdgeStart {

    @Test

     /*
     Given I am an existing user
     When I navigate to https://parabank.parasoft.com/parabank/index.htm website
     And I pass the correct credentials for the Username and Password fields
     Then I should see that I am successfully logged in on the site
     */


    public void userLogin() {
        LoginUtils loginUtils = new LoginUtils(driver);
        loginUtils.login("username.txt", "password.txt");

        // Asserting that the user was able to login successfully
        WebElement getText = driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/p/b"));
        String welcome = getText.getText();
        System.out.println(welcome);
        Assert.assertEquals("Welcome", welcome);
    }


}

