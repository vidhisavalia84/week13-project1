package electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void SetUpDriver() {
        openBrowser(baseUrl);
    }

    @Test
    public void veifyUserShouldNavigateTocellPhonesPageSuccessfully() {
        mouseHoverToElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));
        mouseHoverToElementAndClick(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
        String expectedText = "Cell phones";
        String actualText = getTextFromElement(By.xpath("//div[@class='page-title']/h1"));
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void verifyThatProductAddedSuccessfullyAndPlaceOrderSucceessfully() throws InterruptedException {
        mouseHoverToElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));
        mouseHoverToElementAndClick(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
        String expectedText = "Cell phones";
        String actualText = getTextFromElement(By.xpath("//div[@class='page-title']/h1"));
        Assert.assertEquals(expectedText, actualText);
        //2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[contains(text(),'Nokia Lumia 1020')]"));
        //Verify the text “Nokia Lumia 1020”
        Thread.sleep(4000);
        String expectedText1 = "Nokia Lumia 1020";
        String actualText1 = getTextFromElement(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"));
        Assert.assertEquals(expectedText1, actualText1);
        //2.7 Verify the price “$349.00”
        String expectedText2 = "$349.00";
        String actualText2 = getTextFromElement(By.xpath("//span[@id='price-value-20']"));
        Assert.assertEquals(expectedText2, actualText2);
        Thread.sleep(2000);
//2.8 Change quantity to 2
        clearText(By.cssSelector("#product_enteredQuantity_20"));
        sendTextToElement(By.cssSelector("#product_enteredQuantity_20"), "2");
//2.9 Click on “ADD TO CART” tab
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));
        //2.10 Verify the Message "The product has been added to your shopping cart" on Top
        //green Bar
        verifyMessage("The product has been added to your shopping cart", getTextFromElement(By.xpath("//p[@class='content']")));

        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@class='close']"));

        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverToElement(By.xpath("//a[@href='/cart'and@class='ico-cart']"));
        Thread.sleep(4000);
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));
        //2.12 Verify the message "Shopping cart"
        Thread.sleep(2000);
        verifyMessage("Shopping cart", getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]")));

        //2.13 Verify the quantity is 2
        Thread.sleep(3000);
//verifyMessage("2",getTextFromElement(By.id("itemquantity11287")));
        verifyMessage("(2)",getTextFromElement(By.xpath("//span[contains(text(),'(2)')]")));
        //2.14 Verify the Total $698.00
        Thread.sleep(3000);
        verifyMessage("$698.00", getTextFromElement(By.xpath("//table[@class='cart-total']/tbody/tr[4]/td[2]")));
        //2.15 click on checkbox “I agree with the terms of service”
        Thread.sleep(3000);
        mouseHoverToElementAndClick(By.id("termsofservice"));
        //2.16 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        //2.17 Verify the Text “Welcome, Please Sign In!”
        Thread.sleep(3000);
        verifyMessage("Welcome, Please Sign In!", getTextFromElement(By.xpath("//div[@class='page-title']/h1")));
        //2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
        //2.19 Verify the text “Register”
        Thread.sleep(3000);
        verifyMessage("Register", getTextFromElement(By.xpath("//h1[contains(text(),'Register')]")));
        //2.20 Fill the mandatory fields
        clickOnElement(By.id("gender-female"));
        sendTextToElement(By.id("FirstName"), "Krishna12");
        sendTextToElement(By.id("LastName"), "vara");
        selectOptionsByValue(By.xpath("//select[@name='DateOfBirthDay']"), "10");
        Thread.sleep(1000);
        selectOptionsByValue(By.xpath("//select[@name='DateOfBirthMonth']"), "2");
        selectOptionsByValue(By.xpath("//select[@name='DateOfBirthYear']"), "1928");
        sendTextToElement(By.xpath("//input[@id='Email']"), "Krishnavala123@gmail.com");
        sendTextToElement(By.xpath("//input[@id='Company']"), "Prime");
        Thread.sleep(2000);
        sendTextToElement(By.xpath("//input[@id='Password']"), "prime1");
        sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"), "prime1");
        //2.21 Click on “REGISTER” Button
        clickOnElement(By.xpath("//button[@id='register-button']"));
        //2.22 Verify the message “Your registration completed”
        Thread.sleep(2000);
//verifyMessage("Your registration completed",getTextFromElement(By.xpath("//div[contains(text(),'Your registration completed')]")));
        //2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
        //click on continue
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
        //2.24 Verify the text “Shopping card”
        Thread.sleep(2000);
        verifyMessage("Shopping cart", getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]")));
        //2.25 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));
        //2.26 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));
//2.27 Fill the Mandatory fields
       // sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"), "Krishna");
       // sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"), "vara");
       // sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"), "Krishnavala@gmail.com");
       // sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Company']"), "Prime");
        selectOptionsByValue(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "158");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "Parva");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "block No. 123");
        sendTextToElement(By.id("BillingNewAddress_Address2"), " RBlockoad");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "HA3 2LT");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "01234567898");
        sendTextToElement(By.id("BillingNewAddress_FaxNumber"), "0123456788");
        //2.28 Click on “CONTINUE”
        Thread.sleep(2000);
        clickOnElement(By.name("save"));
        Thread.sleep(2000);
        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.id("shippingoption_2"));
        //2.30 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        //2.31 Select Radio Button “Credit Card”
        clickOnElement(By.id("paymentmethod_1"));
//click on continue button
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));//continue button
        //2.32 Select “Visa” From Select credit card dropdown
        selectOptionsByValue(By.id("CreditCardType"), "visa");
        //2.33 Fill all the details
        sendTextToElement(By.id("CardholderName"), "krishnavala");
        sendTextToElement(By.id("CardNumber"), "1111222233334444");
        selectOptionsByValue(By.id("ExpireMonth"), "3");
        selectOptionsByValue(By.id("ExpireYear"), "2023");
        sendTextToElement(By.id("CardCode"), "607");
        //2.34 Click on “CONTINUE
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        //2.35 Verify “Payment Method” is “Credit Card”
        Thread.sleep(2000);
        verifyMessage("Credit Card", getTextFromElement(By.xpath("//li[@class='payment-method']/span[2]")));
        //2.36 Verify “Shipping Method” is “2nd Day Air”
        Thread.sleep(2000);
        verifyMessage("2nd Day Air", getTextFromElement(By.xpath("//li[@class='shipping-method']/span[2]")));
        //2.37 Verify Total is “$698.00”
        Thread.sleep(2000);
        verifyMessage("$698.00", getTextFromElement(By.xpath("//tr[@class='order-total']/td[2]/span/strong")));
        //2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[@class='button-1 confirm-order-next-step-button']"));
        //2.39 Verify the Text “Thank You”
        Thread.sleep(2000);
        verifyMessage("Thank you", getTextFromElement(By.xpath("//div[@class='page-title']/h1")));
        //2.40 Verify the message “Your order has been successfully processed!”
        Thread.sleep(3000);
        //verifyMessage("Your order has been successfully processed!", getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]")));
        // verifyMessage("Your order has been successfully processed!", getTextFromElement(By.xpath("//div[@class='title'and@xpath='1']//strong[1]")));
        verifyMessage("Your order has been successfully processed!",getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]")));
         //2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 order-completed-continue-button']"));
        //2.42 Verify the text “Welcome to our store”
        Thread.sleep(2000);
        verifyMessage("Welcome to our store", getTextFromElement(By.xpath("//div[@class='topic-block-title']/h2")));
        //2.43 Click on “Logout” link
        clickOnElement(By.xpath("//a[@class='ico-logout']"));
        //2.44 Verify the URL is “https://demo.nopcommerce.com/”
        //String url = driver.getCurrentUrl();
        Thread.sleep(2000);
        verifyMessage("https://demo.nopcommerce.com/", driver.getCurrentUrl());

    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
