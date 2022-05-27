package pageLayers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Xls_Reader;

import java.util.List;

public class HomePage {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();



//        List<WebElement> columns = driver.findElements(By.xpath("//tbody/tr[1]/td"));
//        System.out.println(columns.size());

        String beforeXpath = "//tbody/tr[";
        String afterXpath = "]/td[1]";

        String beforeXpath2 = "//tbody/tr[";
        String afterXpath2 = "]/td[2]";

        String beforeXpath3 = "//tbody/tr[";
        String afterXpath3 = "]/td[3]";

        String beforeXpath4 = "//tbody/tr[";
        String afterXpath4 = "]/td[4]";

        String beforeXpath5 = "//tbody/tr[";
        String afterXpath5 = "]/td[5]";

        String beforeXpath6 = "//tbody/tr[";
        String afterXpath6 = "]/td[6]";

        String beforeXpath7 = "//tbody/tr[";
        String afterXpath7 = "]/td[7]";

        String beforeXpath8 = "//tbody/tr[";
        String afterXpath8 = "]/td[8]";

        String beforeXpath9 = "//tbody/tr[";
        String afterXpath9 = "]/td[9]";

        String beforeXpath10 = "//tbody/tr[";
        String afterXpath10 = "]/td[10]";

        String beforeXpath11 = "//tbody/tr[";
        String afterXpath11 = "]/td[11]";

        String beforeXpath12 = "//tbody/tr[";
        String afterXpath12 = "]/td[12]";

        String beforeXpath13 = "//tbody/tr[";
        String afterXpath13 = "]/td[13]";

        String beforeXpath14 = "//tbody/tr[";
        String afterXpath14 = "]/td[14]";

        String beforeXpath15 = "//tbody/tr[";
        String afterXpath15 = "]/td[15]";

        Xls_Reader reader = new Xls_Reader("C:\\Users\\user\\IdeaProjects\\HybridFrameworkCreation\\src\\main\\java\\pageLayers");
          reader.addSheet("TableData");
          reader.addColumn("TableData", "Sr. No.");
          reader.addColumn("TableData", "PSN");
          reader.addColumn("TableData", "NIC");
          reader.addColumn("TableData", "Manufacturing Activity");
          reader.addColumn("TableData", "Factory Name");
          reader.addColumn("TableData", "Gala no/Plot no");
          reader.addColumn("TableData", "Industrial Estate");
          reader.addColumn("TableData", "Landmark");
          reader.addColumn("TableData", "Village/M-corp");
          reader.addColumn("TableData", "Tahsil");
          reader.addColumn("TableData", "Dist");
          reader.addColumn("TableData", "Pincode");
          reader.addColumn("TableData", "Male workers");
          reader.addColumn("TableData", "Female Workers");
          reader.addColumn("TableData", "Total Workers");

//          WebElement nextBtn = driver.findElement(By.xpath("//a[normalize-space()='>']"));
        int row = 1;

        for(int j=1;j<=193;j++){
            if(j==1){
                driver.get("https://mahadish.in/registered_factories/index?district=SOLAPUR&tahsil=&pincode=&submit=submit");
                List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));
                System.out.println(rows.size());
                for(int i=1; i<=rows.size();i++){
                    row++;
                    String actualXpath = beforeXpath+i+afterXpath;
                    String actualXpath2 = beforeXpath+i+afterXpath2;
                    String actualXpath3 = beforeXpath+i+afterXpath3;
                    String actualXpath4 = beforeXpath+i+afterXpath4;
                    String actualXpath5 = beforeXpath+i+afterXpath5;
                    String actualXpath6 = beforeXpath+i+afterXpath6;
                    String actualXpath7 = beforeXpath+i+afterXpath7;
                    String actualXpath8 = beforeXpath+i+afterXpath8;
                    String actualXpath9 = beforeXpath+i+afterXpath9;
                    String actualXpath10 = beforeXpath+i+afterXpath10;
                    String actualXpath11 = beforeXpath+i+afterXpath11;
                    String actualXpath12 = beforeXpath+i+afterXpath12;
                    String actualXpath13 = beforeXpath+i+afterXpath13;
                    String actualXpath14 = beforeXpath+i+afterXpath14;
                    String actualXpath15 = beforeXpath+i+afterXpath15;

                    String dataIncell = driver.findElement(By.xpath(actualXpath)).getText();
                    String dataIncell2 = driver.findElement(By.xpath(actualXpath2)).getText();
                    String dataIncell3 = driver.findElement(By.xpath(actualXpath3)).getText();
                    String dataIncell4 = driver.findElement(By.xpath(actualXpath4)).getText();
                    String dataIncell5 = driver.findElement(By.xpath(actualXpath5)).getText();
                    String dataIncell6 = driver.findElement(By.xpath(actualXpath6)).getText();
                    String dataIncell7 = driver.findElement(By.xpath(actualXpath7)).getText();
                    String dataIncell8 = driver.findElement(By.xpath(actualXpath8)).getText();
                    String dataIncell9 = driver.findElement(By.xpath(actualXpath9)).getText();
                    String dataIncell10 = driver.findElement(By.xpath(actualXpath10)).getText();
                    String dataIncell11 = driver.findElement(By.xpath(actualXpath11)).getText();
                    String dataIncell12 = driver.findElement(By.xpath(actualXpath12)).getText();
                    String dataIncell13 = driver.findElement(By.xpath(actualXpath13)).getText();
                    String dataIncell14 = driver.findElement(By.xpath(actualXpath14)).getText();
                    String dataIncell15 = driver.findElement(By.xpath(actualXpath15)).getText();

                    reader.setCellData("TableData", "Sr. No.", row, dataIncell);
                    reader.setCellData("TableData", "PSN", row, dataIncell2);
                    reader.setCellData("TableData", "NIC", row, dataIncell3);
                    reader.setCellData("TableData", "Manufacturing Activity", row, dataIncell4);
                    reader.setCellData("TableData", "Factory Name", row, dataIncell5);
                    reader.setCellData("TableData", "Gala no/Plot no", row, dataIncell6);
                    reader.setCellData("TableData", "Industrial Estate", row, dataIncell7);
                    reader.setCellData("TableData", "Landmark", row, dataIncell8);
                    reader.setCellData("TableData", "Village/M-corp", row, dataIncell9);
                    reader.setCellData("TableData", "Tahsil", row, dataIncell10);
                    reader.setCellData("TableData", "Dist", row, dataIncell11);
                    reader.setCellData("TableData", "Pincode", row, dataIncell12);
                    reader.setCellData("TableData", "Male workers", row, dataIncell13);
                    reader.setCellData("TableData", "Female Workers", row, dataIncell14);
                    reader.setCellData("TableData", "Total Workers", row, dataIncell15);

                }
            }
            else{
                driver.get("https://mahadish.in/registered_factories/index/"+j+ "?district=SOLAPUR&tahsil=&pincode=&submit=submit");
                List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));
                System.out.println(rows.size());
                for(int i=1; i<=rows.size();i++){
                    row++;
                    String actualXpath = beforeXpath+i+afterXpath;
                    String actualXpath2 = beforeXpath+i+afterXpath2;
                    String actualXpath3 = beforeXpath+i+afterXpath3;
                    String actualXpath4 = beforeXpath+i+afterXpath4;
                    String actualXpath5 = beforeXpath+i+afterXpath5;
                    String actualXpath6 = beforeXpath+i+afterXpath6;
                    String actualXpath7 = beforeXpath+i+afterXpath7;
                    String actualXpath8 = beforeXpath+i+afterXpath8;
                    String actualXpath9 = beforeXpath+i+afterXpath9;
                    String actualXpath10 = beforeXpath+i+afterXpath10;
                    String actualXpath11 = beforeXpath+i+afterXpath11;
                    String actualXpath12 = beforeXpath+i+afterXpath12;
                    String actualXpath13 = beforeXpath+i+afterXpath13;
                    String actualXpath14 = beforeXpath+i+afterXpath14;
                    String actualXpath15 = beforeXpath+i+afterXpath15;

                    String dataIncell = driver.findElement(By.xpath(actualXpath)).getText();
                    String dataIncell2 = driver.findElement(By.xpath(actualXpath2)).getText();
                    String dataIncell3 = driver.findElement(By.xpath(actualXpath3)).getText();
                    String dataIncell4 = driver.findElement(By.xpath(actualXpath4)).getText();
                    String dataIncell5 = driver.findElement(By.xpath(actualXpath5)).getText();
                    String dataIncell6 = driver.findElement(By.xpath(actualXpath6)).getText();
                    String dataIncell7 = driver.findElement(By.xpath(actualXpath7)).getText();
                    String dataIncell8 = driver.findElement(By.xpath(actualXpath8)).getText();
                    String dataIncell9 = driver.findElement(By.xpath(actualXpath9)).getText();
                    String dataIncell10 = driver.findElement(By.xpath(actualXpath10)).getText();
                    String dataIncell11 = driver.findElement(By.xpath(actualXpath11)).getText();
                    String dataIncell12 = driver.findElement(By.xpath(actualXpath12)).getText();
                    String dataIncell13 = driver.findElement(By.xpath(actualXpath13)).getText();
                    String dataIncell14 = driver.findElement(By.xpath(actualXpath14)).getText();
                    String dataIncell15 = driver.findElement(By.xpath(actualXpath15)).getText();

                    reader.setCellData("TableData", "Sr. No.", row, dataIncell);
                    reader.setCellData("TableData", "PSN", row, dataIncell2);
                    reader.setCellData("TableData", "NIC", row, dataIncell3);
                    reader.setCellData("TableData", "Manufacturing Activity", row, dataIncell4);
                    reader.setCellData("TableData", "Factory Name", row, dataIncell5);
                    reader.setCellData("TableData", "Gala no/Plot no", row, dataIncell6);
                    reader.setCellData("TableData", "Industrial Estate", row, dataIncell7);
                    reader.setCellData("TableData", "Landmark", row, dataIncell8);
                    reader.setCellData("TableData", "Village/M-corp", row, dataIncell9);
                    reader.setCellData("TableData", "Tahsil", row, dataIncell10);
                    reader.setCellData("TableData", "Dist", row, dataIncell11);
                    reader.setCellData("TableData", "Pincode", row, dataIncell12);
                    reader.setCellData("TableData", "Male workers", row, dataIncell13);
                    reader.setCellData("TableData", "Female Workers", row, dataIncell14);
                    reader.setCellData("TableData", "Total Workers", row, dataIncell15);

                }
            }
        }





        driver.quit();
    }
}
