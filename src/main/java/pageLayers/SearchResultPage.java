package pageLayers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ConstantUtil;
import utils.ElementUtil;

import java.util.ArrayList;
import java.util.List;

public class SearchResultPage {

    private WebDriver driver;
    private ElementUtil eleUtil;

    private By resultPageHeader = By.cssSelector("div#content h1");
    private By products = By.cssSelector("div.caption a");

    public SearchResultPage(WebDriver driver){
        this.driver = driver;
        eleUtil = new ElementUtil(driver);
    }

    public boolean isResultsHeaderExists(){
        return eleUtil.doIsDisplayed(resultPageHeader);
    }

    public String getResultPageHeader(){
        return eleUtil.doElementGetText(resultPageHeader);
    }

    public int getProductsCount(){
        return eleUtil.waitForElementsToBeVisible(products, ConstantUtil.DEFAULT_WAIT_TIME).size();
    }

    public List<String> getProductList(){
        List<WebElement> productsList = eleUtil.waitForElementsToBeVisible(products, ConstantUtil.DEFAULT_WAIT_TIME);
        List<String> actualProductList = new ArrayList<String>();
        for(WebElement e: productsList){
            actualProductList.add(e.getText());
        }
        return actualProductList;
    }

    public ProductInfoPage addProduct(){
        List<WebElement> productList = eleUtil.waitForElementsToBeVisible(products, ConstantUtil.DEFAULT_WAIT_TIME);
        for(WebElement e: productList){
            if(e.getText().contains("Pro")){
                e.click();
                break;
            }
        }
        return new ProductInfoPage(driver);
    }



}
