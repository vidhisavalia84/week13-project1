package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void SetUpDriver() {
        openBrowser(baseUrl);
    }



   public void selectMenu(String menu) {
//clickOnElement(By.xpath("//body/div[1]/nav[1]/div[2]"));
//selectOptionsByContainText(By.xpath("//body/div[1]/nav[1]/div[2]"),menu);
       clickOnElement(By.linkText(menu));
   }

    @Test
    public void verifyPageNavigation(){

        selectMenu("Electronics");

    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}