package pageLayers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ConstantUtil;
import utils.ElementUtil;

import java.util.ArrayList;
import java.util.List;

public class AccountsPage {

    private WebDriver driver;
    private ElementUtil eleUtil;

    private By header = By.xpath("//*[text()='Account']");
    private By search = By.name("search");
    private By searchButton = By.cssSelector("div#search button");
    private By accSectionList = By.cssSelector("div#content h2");

    public AccountsPage(WebDriver driver){
        this.driver = driver;
        eleUtil = new ElementUtil(driver);
    }

    public List<String> getAccountsPageSectionList(){
        List<WebElement> secList = eleUtil.getElements(accSectionList);
        List<String> accSecValList = new ArrayList<String>();
        for(WebElement e: secList){
            accSecValList.add(e.getText());
        }
        return accSecValList;
    }

    public String getAccountPageTitle(){
        return eleUtil.waitForTitleIs(ConstantUtil.DEFAULT_WAIT_TIME, ConstantUtil.ACCOUNT_PAGE_TITLE);
    }

    public boolean isAccPageHeaderExists(){
        return eleUtil.doIsDisplayed(header);
    }

    public String getAccPageHeader() {
        return driver.findElement(header).getText();
    }

    public boolean isAccPageSearchOptionExits(){
        return eleUtil.doIsDisplayed(search);
    }

    public SearchResultPage doSearch(String productName){
        if(isAccPageSearchOptionExits()){
            eleUtil.doSendKeys(search, productName);
            eleUtil.doClick(searchButton);
            return new SearchResultPage(driver);
        }
        return null;
    }

}
