package UtilsMethods;

import InstantiateDriver.EdgeStart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LoginUtils extends EdgeStart {

    //This is a login method which can be called from other classes
    private WebDriver driver;

    public LoginUtils(WebDriver driver) {
        this.driver = driver;
    }
    public void login(String usernameFile, String passwordFile) {
        String username = null;
        String password = null;
        try {
            username = new String(Files.readAllBytes(Paths.get(usernameFile)));
            password = new String(Files.readAllBytes(Paths.get(passwordFile)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int sendDetails = 1; sendDetails <= 3; sendDetails++) {
            WebElement loginDetails = driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[" + sendDetails + "]/input"));
            if (sendDetails == 1) {
                loginDetails.sendKeys(username);
                System.out.println("Username :" + username);
            } else if (sendDetails == 2) {
                loginDetails.sendKeys(password);
                System.out.println("Password :" + password);
            } else if (sendDetails == 3) ;
            loginDetails.click();
        }
    }
}
