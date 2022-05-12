package pageLayers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ConstantUtil;
import utils.ElementUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductInfoPage {

    private WebDriver driver;
    private ElementUtil eleUtil;

    private By productinfoHeader = By.cssSelector("div#content h1");
    private By productImages = By.cssSelector("div#content img");
    private By productMetaData = By.cssSelector("div#content ul.list-unstyled:nth-of-type(1) li");
    private By productPrice = By.cssSelector("div#content ul.list-unstyled:nth-of-type(2) li");
    private By productQuantiyt = By.id("input-quantity");
    private By addToCart = By.id("button-cart");
    private By successMsg = By.cssSelector("div.alert.alert-success.alert-dismissible");

    private Map<String, String > productInfoMap;

    public ProductInfoPage(WebDriver driver) {
        this.driver = driver;
        eleUtil = new ElementUtil(driver);
    }

    public String productHeader(){
        if(eleUtil.getElement(productinfoHeader).isDisplayed()){
            return eleUtil.doElementGetText(productinfoHeader);
        }
        return null;
    }

    public int getProductImageCount(){
        return eleUtil.waitForElementsToBeVisible(productImages, ConstantUtil.DEFAULT_WAIT_TIME).size();
    }

    public Map<String, String> getProductInfo(){
        productInfoMap = new HashMap<String, String>();
        productInfoMap.put("productName", productHeader());
        productInfoMap.put("imageCount", String.valueOf(getProductImageCount()));
        productMetaData();
        productPrice();
        return productInfoMap;
    }

    /*
    Brand: Apple
    Product Code: Product 18
    Reward Points: 800
    Availability: In Stock
     */
    private void productMetaData(){
        List<WebElement> metaDataList = eleUtil.getElements(productMetaData);
        for(WebElement e: metaDataList){
            String[] metaDataItem = e.getText().split(":");
            String metaDatakey = metaDataItem[0].trim();
            String metaDataValue = metaDataItem[1].trim();
            productInfoMap.put(metaDatakey, metaDataValue);
        }
    }

    /*
    $2,000.00
    Ex Tax: $2,000.00
     */

    private void productPrice(){
        List<WebElement> metaDataList = eleUtil.getElements(productPrice);
        productInfoMap.put("productPrice", metaDataList.get(0).getText().trim());
        productInfoMap.put("ExProductPrice", metaDataList.get(1).getText().trim());
        }

}
