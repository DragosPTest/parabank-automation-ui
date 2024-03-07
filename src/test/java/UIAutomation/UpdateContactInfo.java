package UIAutomation;

import InstantiateDriver.EdgeStart;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UpdateContactInfo extends EdgeStart {

    @Test
    /*

     */

    public void updateInfo() throws InterruptedException {
        String username = null;
        String password = null;
        try {
            username = new String(Files.readAllBytes(Paths.get("username.txt")));
            password = new String(Files.readAllBytes(Paths.get("password.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int sendDetails = 1; sendDetails <= 3; sendDetails++) {
            WebElement loginDetails = driver.findElement(By.xpath(
                    "//*[@id=\"loginPanel\"]/form/div[" + sendDetails + "]/input"));
            if (sendDetails == 1) {
                loginDetails.sendKeys(username);
                System.out.println(username);
            } else if (sendDetails == 2) {
                loginDetails.sendKeys(password);
                System.out.println(password);
            } else if (sendDetails == 3) ;
            loginDetails.click();
        }

        WebElement updateContactInfoClick = driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/ul/li[6]/a"));
        updateContactInfoClick.click();

        Thread.sleep(1500);

        String expectedTitle = driver.getTitle();
        System.out.println(expectedTitle);

        //Deleting the actual user details from the profile using CTRL + a + BACKSPACE Keys.
        for (int delete = 1; delete <= 7; delete++) {
            WebElement updateDetails = driver.findElement(By.xpath(
                    "//*[@id=\"rightPanel\"]/div/div/form/table/tbody/tr[" + delete + "]/td/input"));
            updateDetails.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        }
        //Updating the account with new details.
        for (int addDetails = 1; addDetails <= 8; addDetails++) {
            WebElement updateDetails = driver.findElement(By.xpath(
                    "//*[@id=\"rightPanel\"]/div/div/form/table/tbody/tr[" + addDetails + "]/td/input"));
            updateDetails.sendKeys("NewData");
            if (addDetails == 8) {
                updateDetails.click();
            }
        }
        Thread.sleep(1500);

        //Asserting that we successfully updated user's details
        WebElement updateSuccess = driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/div/div/p"));
        String getText = updateSuccess.getText();
        System.out.println(getText);
        Assert.assertEquals("Your updated address and phone number have been added to the system.", getText);

    }

}

