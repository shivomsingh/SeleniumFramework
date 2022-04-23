package pageLayers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    private By email = By.id("input-email");
    private By password = By.id("input-password");
    private By logIn = By.xpath("//input[@value='login']");
    private By forgotPassword = By.linkText("Forgotten Password");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

//    3. public page actions
    public String getPageTitle(){
        return driver.getTitle();
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public boolean isForgotPasswordLinkExist(){
        return driver.findElement(forgotPassword).isDisplayed();
    }

    public void doLogin(String userName, String pwd){
        driver.findElement(email).sendKeys(userName);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(logIn).click();
    }
}
