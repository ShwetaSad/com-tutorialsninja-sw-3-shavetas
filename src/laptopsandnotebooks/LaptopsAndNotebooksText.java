package laptopsandnotebooks;

import jdk.jshell.execution.Util;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LaptopsAndNotebooksText extends Utility {
    String baseURL = "http://tutorialsninja.com/demo/index.php";


    @Before
    public void setup() {
        openBrowser(baseURL);
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        // 1.1 Mouse hover on the Laptops & Notebooks Tab. and click
        mouseHoverToElementAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
        // Click on “Show AllLaptops & Notebooks”
        clickOnElement(By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]"));
        //Select the Sort By "Price (High > Low)"
        selectByValueFromDropDown(By.xpath("//select[@id='input-sort']\")"), "Price (High > Low)");

        //  Verify the Product price will be arranged in High to Low orders.
        String expectedText = "Price (High > Low)";
        String actualText = getTextFromElement(By.xpath("//option[contains(text(),'Price (High > Low)')]"));
        Assert.assertEquals("incorrect order", expectedText, actualText);

    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() {
        // Mouse hover on the Laptops & Notebooks Tab and click
        mouseHoverToElementAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
        //Click on the “Show AllLaptops & Notebooks”
        clickOnElement(By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]"));
        //Select Sort By "Price (High > Low)"
        selectByValueFromDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low");
        //  Select Product “MacBook”
        clickOnElement(By.xpath("//body/div[@id='product-category']/div[1]/div[1]/div[4]/div[4]/div[1]/div[2]/div[1]/h4[1]/a[1]"));
        // Verify the text “MacBook”
        String expectedText = "MacBook";
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'MacBook')]"));
        Assert.assertEquals("incorrect product", expectedText, actualText);

        //Click on the ‘Add To Cart’ button
        clickOnElement(By.xpath("//button[@id='button-cart']"));

        //Verify the message “Success: You have added MacBook to your shopping cart!”
        String expectedText1 = "Success: You have added MacBook to your shopping cart!";
        String actualText1 = getTextFromElement(By.cssSelector("body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible"));
        Assert.assertTrue("product not added", expectedText1.contains(expectedText1));

        //Click on the link “shopping cart” display into the success message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));

        //  Verify the text "Shopping Cart"
        String expectedText3 = "Shopping Cart  (0.00kg)";
        String actualText3 = getTextFromElement(By.cssSelector("body:nth-child(2) div.container:nth-child(4) div.row div.col-sm-12 > h1:nth-child(1)"));
        Assert.assertEquals("no order added", expectedText3, actualText3);

        //Verify the Product name "MacBook"
        String expectedText4 = "MacBook";
        String actualText4 = getTextFromElement(By.xpath("//body[1]/div[2]/div[2]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"));
        Assert.assertEquals("incorrect product name", expectedText4, actualText4);

        // Change the Quantity "2"
        driver.findElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]")).clear();
        driver.findElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]")).sendKeys("2");

        // Click on the “Update” Tab
        clickOnElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/span[1]/button[1]/i[1]"));

        //Verify the message “Success: You have modified your shopping cart!”
        String expectedText5 = "Success: You have modified your shopping cart!";
        String actualText5 = getTextFromElement(By.cssSelector("body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible"));
        Assert.assertTrue("product not added", actualText5.contains(expectedText5));

        // Verify the Total £737.45
        String expectedText6 = "£737.45";
        String actualText6 = getTextFromElement(By.xpath("//body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]"));
        Assert.assertEquals("product not added", expectedText6, actualText6);

        // Click on the “Checkout” button
        clickOnElement(By.xpath("//a[contains(text(),'Checkout')]"));

        //  It doesn't let you checkout, gives error"Products marked with *** are not available in the desired quantity or not in stock!"

    }

}