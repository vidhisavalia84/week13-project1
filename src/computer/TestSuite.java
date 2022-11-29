package computer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

import java.beans.IntrospectionException;

public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void browserSetUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyproductArrangeAlphabeticalOrder() {
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));//click computer tab

        //click on desktop tab
        clickOnElement(By.xpath("/html[1]/body[1]/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));
        //clickOnElement(By.xpath("//a[@href='/desktops'and@xpath='1' ]"));

        //selectByVisibleTextFromDropDown(By.cssSelector("#products-orderby"),"Name: Z to A");

//clickOnElement(By.id("products-orderby"));
        selectOptionsByValue(By.id("products-orderby"), "6");//works
        String expectedResult = "Name: Z to A";
        String actualResult = getTextFromElement(By.xpath("//select[@id='products-orderby']/option[3]"));
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void verifyProductAddedtoShoppingCartSuccessfully() throws InterruptedException {
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));//click computer
        //click on desktop 2.2
        clickOnElement(By.xpath("//div[@class='sub-category-item']/h2//a[@title='Show products in category Desktops']"));
        selectOptionsByValue(By.id("products-orderby"), "5");//select op A to Z
        Thread.sleep(3000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]"));
        String expectedText = "Build your own computer";
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Build your own computer')]"));
        Assert.assertEquals(actualText, expectedText);
        Thread.sleep(1000);
        clickOnElement(By.xpath("//dd[@id='product_attribute_input_1']//option[2]"));//Q-2.6
        Thread.sleep(1000);
        clickOnElement(By.xpath("//dd[@id='product_attribute_input_2']//option[4]"));//2.7
        Thread.sleep(2000);
        clickOnElement(By.xpath("//dd[@id='product_attribute_input_3']/ul/li[2]/label"));//2.8
        clickOnElement(By.xpath("//dd[@id='product_attribute_input_4']/ul/li[2]/input"));//2.9
        Thread.sleep(2000);
        // clickOnElement(By.xpath("//input[@id='product_attribute_5_10'and@value='10']"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@id='product_attribute_5_12']"));
        Thread.sleep(1000);
        String expectedText1 = "$1,475.00";
        String actualText1 = getTextFromElement(By.id("price-value-1"));
        Thread.sleep(4000);
        Assert.assertEquals(expectedText1, actualText1);
        clickOnElement(By.id("add-to-cart-button-1"));
        String expectedMessage = "The product has been added to your shopping cart";
        String actualMessage = getTextFromElement(By.xpath("//p[@class='content']"));
        Assert.assertEquals(expectedMessage, actualMessage);
        clickOnElement(By.xpath("//span[@class='close']"));
        Thread.sleep(2000);
        mouseHoverToElement(By.xpath("//a[@class='ico-cart']"));
        Thread.sleep(3000);
        mouseHoverToElementAndClick(By.xpath("//button[@class='button-1 cart-button']"));
        //Verify mesage
        String expectedMessage2 = "Shopping cart";
        String actualMessage2 = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals(expectedMessage2, actualMessage2);
        // change quantity to 2
        Actions actions1 = new Actions(driver);
        WebElement quantity = driver.findElement(By.xpath("//input[@value='1']"));
        quantity.clear();
        Thread.sleep(3000);
        sendTextToElement(By.xpath("//input[@value='1']"), "2");
        //update cart
        clickOnElement(By.xpath("//button[@id='updatecart']"));
        Thread.sleep(2000);
        String expectedMessage3 = "$2,950.00";
        String actualMessage3 = getTextFromElement(By.xpath("//tbody/tr[4]/td[2]"));
        Assert.assertEquals(actualMessage3, expectedMessage3);
        //2.18
        mouseHoverToElementAndClick(By.id("termsofservice"));
        clickOnElement(By.xpath("//button[@id='checkout']"));
        //verify message Welcome, Please Sign In!
        String expectedMessage4 = "Welcome, Please Sign In!";
        String actualMessage4 = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals(actualMessage4, expectedMessage4);
        //2.21Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));
        //2.22 Fill the all mandatory field
        Thread.sleep(2000);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"), "Krishna");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"), "Krishna");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"), "Krishna@gmail.com");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Company']"), "PrimeTesting");
        selectOptionsByValue(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "158");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "Parva");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "block No. 123");
        sendTextToElement(By.id("BillingNewAddress_Address2"), "Block Road");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "HA3 2LT");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "01234567898");
        sendTextToElement(By.id("BillingNewAddress_FaxNumber"), "0123456788");
//2.23 Click on “CONTINUE”
        Thread.sleep(2000);
        clickOnElement(By.name("save"));
        // switchToAlert();
        clickOnElement(By.xpath("//input[@id='shippingoption_1']"));//2.24
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));//2.25
//2.26 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@Id='paymentmethod_1']"));

        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));//continue button
        //2.27 Select “Master card” From Select credit card dropdown
        selectOptionByIndex(By.id("CreditCardType"), 1);
        //2.28 Fill all the details
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Krishna Krishna");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "1111222233334444");
        selectOptionsByValue(By.id("ExpireMonth"),"5");
        selectOptionsByValue(By.id("ExpireYear"),"2024");
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "802");
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
//2.29 Click on “CONTINUE”

        //2.30 Verify “Payment Method” is “Credit Card”

        Thread.sleep(1000);
        verifyMessage("Credit Card", getTextFromElement(By.xpath("//li[@class='payment-method']/span[2]")));
        //2.32 Verify “Shipping Method” is “Next Day Air”
        verifyMessage("Next Day Air", getTextFromElement(By.xpath("//li[@class='shipping-method']//span[2]")));
        //2.33 Verify Total is “$2,950.00”
        verifyMessage("$2,950.00", getTextFromElement(By.xpath("//tr[@class='order-total']/td[2]/span/strong")));
        //2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[@class='button-1 confirm-order-next-step-button']"));
        //2.35 Verify the Text “Thank You”
        Thread.sleep(1000);
        verifyMessage("Thank you", getTextFromElement(By.xpath("//div[@class='page-title']/h1")));
        //2.36 Verify the message “Your order has been successfully processed!”
        Thread.sleep(2000);
        verifyMessage("Your order has been successfully processed!", getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]")));
        //2.37 Click on “CONTINUE”
        clickOnElement(By.cssSelector("div.master-wrapper-page:nth-child(6) div.master-wrapper-content div.master-column-wrapper div.center-1 div.page.checkout-page.order-completed-page div.page-body.checkout-data div.section.order-completed div.buttons > button.button-1.order-completed-continue-button"));
        //37 Verify the text “Welcome to our store”
        verifyMessage("Welcome to our store",getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]")));
    }

    @After
    public void tearDown() {
         closeBrowser();
    }
}
