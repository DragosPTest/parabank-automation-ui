package UtilsMethods;

import InstantiateDriver.EdgeStart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BillPayUtils extends EdgeStart {

    //This method will add data to the bill payment form
    private WebDriver driver;

    public BillPayUtils(WebDriver driver) {
        this.driver = driver;
    }


    public void billUtils() {

        WebElement clickBill = driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/ul/li[4]/a"));
        clickBill.click();

        for (int sendDetails = 1; sendDetails <= 11; sendDetails++) {
            if (sendDetails == 7 || sendDetails == 10) {
                continue;
            }
            WebElement randomData = this.driver.findElement(By.xpath(
                    "//*[@id=\"rightPanel\"]/div/div[1]/form/table/tbody/tr["
                            + sendDetails + "]/td/input"));
            if (sendDetails == 8 || sendDetails == 9) {
                randomData.sendKeys("12345");
            } else if (sendDetails == 11) {
                randomData.sendKeys("100");
            } else {
                randomData.sendKeys("RandomDetails");
            }
        }
        WebElement sendPayment = driver.findElement(By.xpath(
                "//*[@id=\"rightPanel\"]/div/div[1]/form/table/tbody/tr[14]/td[2]/input"));
        sendPayment.click();
    }
}

