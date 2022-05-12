package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ConstantUtil;

public class LoginPageTest extends BaseTest {

    @Test
    public void loginPageTitleTest(){
        String accTitle = loginpage.getPageTitle();
        System.out.println("account page title: " + accTitle);
        Assert.assertEquals(accTitle, ConstantUtil.LOGIN_PAGE_TITLE);
    }

    @Test
    public void loginPageUrlTest(){
        String currentUrl = loginpage.getCurrentUrl();
        System.out.println("current  url: "+ currentUrl);
        Assert.assertTrue(currentUrl.contains(ConstantUtil.LOGIN_PAGE_URL_FRACTION));
    }

    @Test
    public void forgotPasswordLinkTest(){
        Assert.assertTrue(loginpage.isForgotPasswordLinkExist());
    }

    @DataProvider
    public Object[][] getUserData(){
        return new Object[][]{
                {"ramshankar@pokemail.net", "Test@1234"}
        };
    }

    @Test(dataProvider = "getUserData")
    public void loginTest(String userEmail, String password) {
        accPage = loginpage.doLogin(userEmail, password);
        Assert.assertTrue(accPage.isAccPageHeaderExists());
        Assert.assertEquals(accPage.getAccPageHeader(), "Account");
    }

    @Test
    public void isRegistrationLinkExist(){

        Assert.assertTrue(loginpage.isRegistrationLinkExist());
    }
}
