package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Utility;

public class TopMenuTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";
@Before
    public void open(){
        openBrowser(baseUrl);
    }

    public void selectMenu(String Menu){
        driver.findElement(By.linkText(Menu)).click();
    }
@Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully(){
        // mouse hover on Desktop and click
        mouseHoverToElementAndClick(By.xpath("//a[normalize-space()=\"Desktops\"]"));
        // call the SelectMenu method
        selectMenu("Show AllDesktops");


        //Verify the text Dessktops
        String expectedText = "Desktops";
        String actualText = driver.findElement(By.xpath("//h2[normalize-space()=\"Desktops\"]")).getText();
        Assert.assertEquals("Wrong page",expectedText,actualText);

    }
    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){
        // mouse hover on Laptops and Notebook and click
        mouseHoverToElementAndClick(By.xpath("//a[normalize-space()=\"Laptops & Notebooks\"]"));
        // call SelectMenu method
        selectMenu("Show AllLaptops & Notebooks");
        //Verify the text Laptops and Notepads
        String expectedText1 = "Laptops & Notebooks";
        String actualText1 = driver.findElement(By.xpath("//h2[normalize-space()=\"Laptops & Notebooks\"]")).getText();
        Assert.assertEquals("Wrong page",expectedText1,actualText1);

          }
          @Test
          public void verifyUserShouldNavigateToComponentsPageSuccessfully(){
        //Mouse hover on the “Components” Tab and click
              mouseHoverToElementAndClick(By.xpath("//a[normalize-space()=\"Components\"]"));
          // call the selectMenu method
              selectMenu("Show AllComponents");

              // Verify the text components
              String expectedText2 = "Components";
              String actualText2 = driver.findElement(By.xpath("//h2[normalize-space()=\"Components\"]")).getText();
              Assert.assertEquals("Wrong page",expectedText2,actualText2);


    }
    @After
    public void close(){
    closeBrowser();
    }
}