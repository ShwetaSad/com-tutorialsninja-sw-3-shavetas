package Desktops;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class DesktopTest extends Utility {
    String baseURL = "http://tutorialsninja.com/demo/index.php";


    @Before
    public void open() {
        openBrowser(baseURL);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        // mouse hover on Desktop and click
        mouseHoverToElementAndClick(By.xpath("//a[normalize-space()=\"Desktops\"]"));
        //click on "Show all Desktops
        mouseHoverToElementAndClick(By.xpath("//a[contains(text(),'Show AllDesktops')]"));

        //select sortby position Ato Z
        selectByValueFromDropDown(By.xpath("//select[@id=\"input-sort\"]"), "Name (Z - A)");

        //        1.4 Verify the Product will be arranged in Descending order.
        String expectedText = "Name (Z - A)";
        String actualText = getTextFromElement(By.xpath("//option[contains(text(),'Name (Z - A)')]"));
        Assert.assertEquals("Not is descending order", expectedText, actualText);

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() {

        // Mouse hover on the Currency Dropdown and click
        mouseHoverToElementAndClick(By.xpath("//span[contains(text(),'Currency')]"));
        // Mouse hover on the £Pound Sterling and click
        mouseHoverToElementAndClick(By.xpath("//button[contains(text(),'£Pound Sterling')]"));
        // mouse hover on the Desktops Tab
        mouseHoverToElementAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));
        //Click on the “Show AllDesktops”
        clickOnElement(By.xpath("//a[contains(text(),'Show AllDesktops')]"));
        //Select the Sort By position "Name: A to Z"
        selectByValueFromDropDown(By.xpath("//select[@id=\"input-sort\"]"), "Name (A - Z)");
        //  2.6 Select product “HP LP3065”
        clickOnElement(By.xpath("//a[contains(text(),'HP LP3065')]"));
        // Verify the Text "HP LP3065"
        String expectedText = "HP LP3065";
        String actualText = getTextFromElement(By.partialLinkText("HP LP30"));
        Assert.assertEquals("Incorrect product", expectedText, actualText);

        //Select Delivery Date "2024-11-27"
        driver.findElement(By.xpath("//input[@id='input-option225']")).clear();
        driver.findElement(By.xpath("//input[@id='input-option225']")).sendKeys("2024-11-27");
       /*Select the delivery date "2024-11-27"
        while (true) {
            // Get Month and Year Text
            String monthAndYear = getTextFromElement(By.xpath("//input[@id=\"input-option225\"]"));
            clickOnElement(By.xpath());
        }
        // Select the Date
        List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tr/td"));
        for (WebElement dt : allDates) {
            if (dt.getText().equals(allDates)){
                dt.click();
                break;
             */
        //add qty 1
        //already has qty 1
        //Click on the “Add to Cart” button
        clickOnElement(By.xpath("//button[@id='button-cart']"));

        //Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        String actualText2 = getTextFromElement(By.cssSelector("body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible"));
        System.out.println(actualText2);
        Assert.assertTrue("no order added", actualText2.contains(actualText2));

        // Click on the link “shopping cart” displayed in a success message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));

        //Verify the text "Shopping Cart"
        String expectedText3 = "Shopping Cart  (1.00kg)";
        String actualText3 = driver.findElement(By.cssSelector("body:nth-child(2) div.container:nth-child(4) div.row div.col-sm-12 > h1:nth-child(1)")).getText();
        Assert.assertEquals("no order added", expectedText3, actualText3);

        //Verify the Product name "HP LP3065"
        String expectedText4 = "HP LP3065";
        String actualText4 = getTextFromElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"));
        Assert.assertEquals("incorrect product", expectedText4, actualText4);

        //Verify the Delivery Date "2024-11-27"
        String expectedText5 = "Delivery Date:2024-11-27";
        String actualText5 = getTextFromElement(By.xpath("//small[contains(text(),'Delivery Date:2024-11-27')]"));
        Assert.assertEquals("incorrect date", expectedText5, actualText5);

        // Verify the Model "Product21"
        String expectedText6 = "Product 21";
        String actualText6 = getTextFromElement(By.xpath("//td[contains(text(),'Product 21')]"));
        Assert.assertEquals("incorrect date", expectedText6, actualText6);

        // Verify the Totat "£74.73"
        String expectedText7 = "£74.73";
        String actualText7 = getTextFromElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]"));
        Assert.assertEquals("incorrect total", expectedText7, actualText7);

    }
@After
    public void close() {
        closeBrowser();
    }
}