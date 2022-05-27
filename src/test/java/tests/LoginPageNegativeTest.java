package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Errorsutil;

@Epic("Epic 100 - QA cart story")
@Story("USR-101 Consider all negative scenarios")
public class LoginPageNegativeTest extends BaseTest {

    @DataProvider
    public Object[][] getUserData(){
        return new Object[][]{
                {"ramsh@pokemail.net", "Test@1234"},
                {"kl", "test"},
                {"lalal@gmail", "dkjsdkl"},
                {"tgb@pal.com", "hjk"}
        };
    }

    @Test(dataProvider = "getUserData")
    @Description("Validating login test cases with invalid scenarios")
    @Severity(SeverityLevel.NORMAL)
    public void invalidLoginTest(String userEmail, String password){
        Assert.assertTrue(loginpage.invalidLogin(userEmail, password), Errorsutil.LOGIN_PAGE_ERROR_MSG_NOT_DSPD);
    }

}
