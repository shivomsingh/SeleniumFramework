package pageLayers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ConstantUtil;
import utils.ElementUtil;

public class RegistrationPage {
    private WebDriver driver;
    private ElementUtil eleUtil;

    private By firstName = By.id("input-firstname");
    private By lastName = By.id("input-lastname");
    private By emailId = By.id("input-email");
    private By telephone = By.id("input-telephone");
    private By password = By.id("input-password");
    private By confirmPassword = By.id("input-confirm");
    private By checkboxNo = By.xpath("//input[@type='radio' and @name='newsletter' and @value='0']");
    private By checkboxYes = By.xpath("//input[@type='radio' and @name='newsletter' and @value='1']");
    private By agreeCheckbox = By.xpath("//input[@type='checkbox' and @name='agree']");
    private By continueBtn = By.xpath("//input[@type='submit' and @value='Continue']");
    private By successMsg = By.cssSelector("div#content h1");
    private By logoutBtn = By.linkText("Logout");
    private By registerBtn = By.linkText("Register");


    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        eleUtil = new ElementUtil(driver);
    }

    public boolean registerUser(String firstName, String lastName, String emailId, String telephone, String password, String checkbox ){
        eleUtil.waitForElementsToBeVisible(this.firstName, ConstantUtil.DEFAULT_WAIT_TIME);
        eleUtil.doSendKeys(this.firstName, firstName);
        eleUtil.doSendKeys(this.lastName, lastName);
        eleUtil.doSendKeys(this.emailId, emailId);
        eleUtil.doSendKeys(this.telephone, telephone);
        eleUtil.doSendKeys(this.password, password);
        eleUtil.doSendKeys(this.confirmPassword, password);

        if(checkbox.equalsIgnoreCase("yes")){
            eleUtil.doClick(checkboxYes);
        }
        else
            eleUtil.doClick(checkboxNo);

        eleUtil.doClick(agreeCheckbox);
        eleUtil.doClick(continueBtn);
        if(getAccountCreateSuccessMsg().contains(ConstantUtil.SUCCESS_MSG)){
            goToRegistrationPage();
            return true;
        }
        return false;
    }

    public String getAccountCreateSuccessMsg(){
        return eleUtil.waitForElementToBeVisible(successMsg, ConstantUtil.DEFAULT_WAIT_TIME).getText();
    }

    private void goToRegistrationPage(){
        eleUtil.doClick(logoutBtn);
        eleUtil.doClick(registerBtn);
    }


}
