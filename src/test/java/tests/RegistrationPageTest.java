package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelUtil;

import java.util.Random;

public class RegistrationPageTest extends BaseTest {

    @BeforeClass
    public void registerPageSetUp(){
        registerPage = loginpage.navigateToRegistrationPage();
    }

    public String getRandomString(){
        Random random = new Random();
        String randomString = "shivAutomation" + random.nextInt(1000) + "@gmail.com";
        return randomString;
    }

//    @DataProvider
//    public Object[][] getRegistrationData(){
//        return new Object[][]{
//                {"Nitest","Agarwal","7676543456","nitest@123","yes"},
//			{"Anu","Kamath","7676543488","anu@123","no"},
//			{"Gagan","Tyagi","7676543499","gagan@123","yes"}
//        };
//    }

    @DataProvider
    public Object[][] getRegisterDataFromExcel(){
        Object[][] data = ExcelUtil.getData();
        return data;
    }

    @Test(dataProvider = "getRegisterDataFromExcel")
    public void userRegistrationTest(String firstName, String lastName, String phoneNumber, String password, String checkBox){
        registerPage.registerUser(firstName, lastName, getRandomString(), phoneNumber, password, checkBox);
    }

//    @Test
//    public void userRegistrationTest(){
//        boolean actualRes = registerPage.registerUser("shivom", "singh", "shivAutomation@gmail.com", "test@123", "yes");
//        Assert.assertTrue(actualRes);
//    }
}
