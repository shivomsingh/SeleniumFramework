package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DriverFactory {

    public WebDriver driver;
    public Properties prop;
    public static String highlight;
    public OptionsManager om;
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

    /**
     * This method is initialising driver on the basis of browser name provided in method
     * This driver will take care of local and remote execution
     * Here, we're taking prop as parameter in init_driver method, this is also example of call by reference (as prop is reference)
     * @param prop
     * @return the webdriver object driver
     */
    public WebDriver init_driver(Properties prop){
        String browserName = prop.getProperty("browser").trim();
        System.out.println("Given browser name is "+ browserName);
        highlight = prop.getProperty("highlight").trim();

        om = new OptionsManager(prop);

        if(browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver(om.getChromeOptions());
            tlDriver.set(new ChromeDriver(om.getChromeOptions()));
        }
        else if(browserName.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
//            driver = new FirefoxDriver(om.getFirefoxOptions());
            tlDriver.set(new FirefoxDriver(om.getFirefoxOptions()));
        }
        else if(browserName.equalsIgnoreCase("safari")){
            WebDriverManager.safaridriver().setup();
//            driver = new SafariDriver();
            tlDriver.set(new SafariDriver());
        }
        else {
            System.out.println("please enter the correct browser name " + browserName);
        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().fullscreen();
        getDriver().get(prop.getProperty("url"));

        return getDriver();
    }

    /**
     * This methos is created to return driver instance
     */
    public static WebDriver getDriver(){
        return tlDriver.get();
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
            FileInputStream fis = new FileInputStream(propertiesFileName);
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

    public static String getScreenshot(){
        File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir")+ "/screenshot/" + System.currentTimeMillis() + ".png";
        File destination = new File(path);
        try {
            FileUtils.copyFile(srcFile, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;

    }
}
