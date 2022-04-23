package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DriverFactory {

    public WebDriver driver;
    public Properties prop;

    /**
     * This method is initialising driver on the basis of browser name provided in method
     * This driver will take care of local and remote execution
     * @param browserName
     * @return the webdriver object driver
     */
    public WebDriver init_driver(String browserName){
        System.out.println("Given browser name is "+ browserName);
        if(browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if(browserName.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else if(browserName.equalsIgnoreCase("safari")){
            driver = new SafariDriver();
        }
        else {
            System.out.println("please enter the correct browser name " + browserName);
        }

        driver.manage().deleteAllCookies();
        driver.manage().window().fullscreen();
        driver.get("");

        return driver;
    }

    /**
     * This method is to initialize the properties on the basis of given environment
     * QA/DEV/PROD
     * @param propertiesFileName
     * @return the properties class object prop
     */
    public Properties init_prop(String propertiesFileName){
        prop = new Properties();
        try{
            FileInputStream fis = new FileInputStream("./src/test/resources/config/config.properties");
            prop.load(fis);
        }
/*
        If file is not found then go for FileNotFoundExeption and IO exception for problem with loading properties.
        As we can have multiple catch blocks we can use other ctach block for IOException
*/
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
//        while loading properties if any kind of error is coming then go for IO exception
        catch (IOException e){
            e.printStackTrace();
        }

        return prop;

    }
}
