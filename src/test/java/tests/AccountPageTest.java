package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.ConstantUtil;

import java.util.List;

public class AccountPageTest extends BaseTest {

    /**
     * This before class method we have created as in BaseTest class we have Beforetest method and we don't want to make it more complex.
     * so during execution, first BeforeTest will execute first and then BeforeClass will execute later
     * in this BeforeClass method, we're initialising account page class object
     */
    @BeforeClass
    public void accountPageSetup(){
        accPage = loginpage.doLogin(prop.getProperty("userName"), prop.getProperty("password"));
    }

    @Test
    public void accountPageTitleTest(){
        String pageTitle = accPage.getAccountPageTitle();
        System.out.println(pageTitle);
        Assert.assertEquals(pageTitle, ConstantUtil.ACCOUNT_PAGE_TITLE);
    }

    @Test
    public void accountPgaeHeaderTest(){
        Assert.assertTrue(accPage.isAccPageHeaderExists());
        System.out.println("Header Test");
    }

    @Test
    public void accountPageSearchOptionTest(){
        Assert.assertTrue(accPage.isAccPageSearchOptionExits());
        System.out.println("Search Test");
    }

    @Test
    public void accSectionTest(){
        List<String> actualSectionList = accPage.getAccountsPageSectionList();
        System.out.println("Actual Section List: "+ actualSectionList);
        Assert.assertEquals(actualSectionList, ConstantUtil.EXPECTED_ACCOUNT_SECTION_LIST);
    }
}
