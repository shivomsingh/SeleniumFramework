package pageLayers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ConstantUtil;
import utils.ElementUtil;

public class LoginPage {

    private WebDriver driver;
    private ElementUtil eleUtil;

    private By email = By.id("input-email");
    private By password = By.id("input-password");
    private By logIn = By.xpath("//input[@name='email']");
    private By forgotPassword = By.linkText("Forgotten Password");
    private By register = By.linkText("Register");

    public LoginPage(WebDriver driver){
        this.driver = driver;
        eleUtil = new ElementUtil(driver);
    }

//    3. public page actions
    public String getPageTitle(){
        return eleUtil.waitForTitleIs(ConstantUtil.DEFAULT_WAIT_TIME, ConstantUtil.LOGIN_PAGE_TITLE);
    }

    public String getCurrentUrl(){
        return eleUtil.waitForUrl(ConstantUtil.DEFAULT_WAIT_TIME, ConstantUtil.LOGIN_PAGE_URL_FRACTION);
    }

    public boolean isForgotPasswordLinkExist(){
        return eleUtil.doIsDisplayed(forgotPassword);
    }

    public AccountsPage doLogin(String userName, String pwd){
        eleUtil.waitForElementToBeVisible(email, ConstantUtil.DEFAULT_WAIT_TIME).sendKeys(userName);
        eleUtil.doSendKeys(password, pwd);
        eleUtil.doClick(logIn);
        return new AccountsPage(driver);
    }

    public boolean isRegistrationLinkExist(){
        return eleUtil.doIsDisplayed(register);
    }

    public void navigateToRegistrationPage(){
        if(isRegistrationLinkExist()){
            eleUtil.doClick(register);
        }
    }
}
