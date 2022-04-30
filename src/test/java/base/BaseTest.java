package base;

import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageLayers.AccountsPage;
import pageLayers.LoginPage;

import java.util.Properties;

public class BaseTest {
    public DriverFactory df;
    public Properties prop;
    public WebDriver driver;

    /*
    Advantage of these below references is that we don't have to create them again in respective test classes
     */

    public LoginPage loginpage;
    public AccountsPage accPage;

    @BeforeTest
    public void setup(){
        df = new DriverFactory();
        prop = df.init_prop("./src/test/resources/config/config.properties");
        driver = df.init_driver(prop);
        loginpage = new LoginPage(driver);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
