package pageLayers;

import factory.DriverFactory;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ConstantUtil;
import utils.ElementUtil;
import utils.Errorsutil;

public class LoginPage {

    public static final Logger log = Logger.getLogger(LoginPage.class);
    private WebDriver driver;
    private ElementUtil eleUtil;

    private By email = By.id("input-email");
    private By password = By.id("input-password");
    private By logIn = By.xpath("//input[@value='Login']");
    private By forgotPassword = By.linkText("Forgotten Password");
    private By register = By.linkText("Register");
    private By errorMsg = By.cssSelector("div.alert.alert-danger.alert-dismissible");

    public LoginPage(WebDriver driver){
        this.driver = driver;
        eleUtil = new ElementUtil(driver);
    }

//    3. public page actions
    public String getPageTitle(){
        log.info("in login page title test");
        return eleUtil.waitForTitleIs(ConstantUtil.DEFAULT_WAIT_TIME, ConstantUtil.LOGIN_PAGE_TITLE);
    }

    public String getCurrentUrl(){
        return eleUtil.waitForUrl(ConstantUtil.DEFAULT_WAIT_TIME, ConstantUtil.LOGIN_PAGE_URL_FRACTION);
    }

    public boolean isForgotPasswordLinkExist(){
        return eleUtil.doIsDisplayed(forgotPassword);
    }

    @Step("Valid Login with valid username {0} and password {1}")
    public AccountsPage doLogin(String userName, String pwd){
        eleUtil.waitForElementToBeVisible(email, ConstantUtil.DEFAULT_WAIT_TIME).sendKeys(userName);
        eleUtil.doSendKeys(password, pwd);
        eleUtil.doClick(logIn);
        return new AccountsPage(driver);
    }

    @Step("Login with invalid username and password")
    public boolean invalidLogin(String un, String pwd){
        WebElement email_ele = eleUtil.waitForElementToBeVisible(email, ConstantUtil.DEFAULT_WAIT_TIME);
        email_ele.clear();
        email_ele.sendKeys(un);
        eleUtil.doSendKeys(password, pwd);
        eleUtil.doClick(logIn);
        WebElement errMsg = driver.findElement(errorMsg);
        if(errMsg.getText().contains(Errorsutil.LOGIN_ERROR_MESSAGE)){
            return true;
        }
        return false;
    }
    public boolean isRegistrationLinkExist(){
        return eleUtil.doIsDisplayed(register);
    }

    public RegistrationPage navigateToRegistrationPage(){
        if(isRegistrationLinkExist()){
            eleUtil.doClick(register);
            return new RegistrationPage(driver);
        }
        return null;
    }
}
