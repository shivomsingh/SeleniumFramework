package pageLayers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AccountsPage {

    private WebDriver driver;
    private By header = By.cssSelector("div#logo a");
    private By search = By.name("search");
    private By accSectionList = By.cssSelector("div#content h2");

    public AccountsPage(WebDriver driver){
        this.driver = driver;
    }

    public List<String> getAccountsPageSectionList(){
        List<WebElement> secList = driver.findElements(accSectionList);
        List<String> accSecValList = new ArrayList<String>();
        for(WebElement e: secList){
            accSecValList.add(e.getText());
        }
        return accSecValList;
    }

    public String getAccountPageTitle(){
        return driver.getTitle();
    }

    public boolean isAccPageHeaderExists(){
        return driver.findElement(header).isDisplayed();
    }

    public boolean isAccPageSearchOptionExits(){
        return driver.findElement(search).isDisplayed();
    }

}
