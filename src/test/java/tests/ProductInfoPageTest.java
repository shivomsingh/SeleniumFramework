package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.ConstantUtil;

import java.util.Map;

public class ProductInfoPageTest extends BaseTest {

    @BeforeClass
    public void productInfoSetup(){
        accPage = loginpage.doLogin(prop.getProperty("userName"), prop.getProperty("password") );
    }

    @Test
    public void productHeaderTest(){
        searchPage = accPage.doSearch(ConstantUtil.SEARCH_STRING);
        proInfoPage = searchPage.addProduct();
        Assert.assertEquals(proInfoPage.productHeader(), "MacBook");
    }

    @Test
    public void productImageCountTest(){
        searchPage = accPage.doSearch(ConstantUtil.SEARCH_STRING);
        proInfoPage = searchPage.addProduct();
        Assert.assertEquals(proInfoPage.getProductImageCount(), 5);
    }

    @Test
    public void productInfoTest(){
        searchPage = accPage.doSearch(ConstantUtil.SEARCH_STRING);
        proInfoPage = searchPage.addProduct();
        Map<String, String> actualProductInfoMap = proInfoPage.getProductInfo();
        actualProductInfoMap.forEach((k,v) -> System.out.println(k +":" + v));

        softAssert.assertEquals(actualProductInfoMap.get("Brand"), "Apple");
        softAssert.assertEquals(actualProductInfoMap.get("Availability"), "In Stock");
        softAssert.assertEquals(actualProductInfoMap.get("Product Code"), "Product 18");
        softAssert.assertEquals(actualProductInfoMap.get("productName"), "MacBook Pro");
        softAssert.assertEquals(actualProductInfoMap.get("imageCount"), "5");
        softAssert.assertEquals(actualProductInfoMap.get("Reward Points"), "800");
        softAssert.assertEquals(actualProductInfoMap.get("productPrice"), "$2,000.00");
        softAssert.assertEquals(actualProductInfoMap.get("ExProductPrice"), "Ex Tax: $2,000.00");
        softAssert.assertAll();
    }
}

//Availability:In Stock
//        Product Code:Product 18
//        productName: :MacBook Pro
//        imageCount: :5
//        Reward Points:800
//        productPrice:$2,000.00
//        ExProductPrice:Ex Tax: $2,000.00