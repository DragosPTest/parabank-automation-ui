package InstantiateDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class EdgeStart {
    protected WebDriver driver;
    private String url = "https://parabank.parasoft.com/parabank/index.htm";

    @BeforeMethod
    public void driverStart() {
        System.setProperty("webdriver.edge.driver", "D:\\Testare software\\edgedriver_win32\\msedgedriver.exe");
        this.driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }
}
