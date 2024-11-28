package myaccounts;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class MyAccountsTest extends Utility {

    String baseURL = "http://tutorialsninja.com/demo/index.php";


    @Before
    public void setup() {
        openBrowser(baseURL);
    }

    public void selectMyAccountOptions(String option) {
        // Locate the list of account options (assuming they are links inside a <ul> or <div>)
        List<WebElement> options = driver.findElements(By.linkText(option));

        // Iterate over the list of options and click the one that matches the given option text
        for (WebElement optionElement : options) {
            if (optionElement.getText().equalsIgnoreCase(option)) {
                optionElement.click();  // Click the matching option
                break;  // Exit the loop after clicking
            }
        }
    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
//            1.1 Click on the My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

        // Call the method “selectMyAccountOptions()” method and pass the parameter “Register”
        selectMyAccountOptions("Register");


        //  Verify the text “Register Account”.
        String expectedText = "Register Account";
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Register Account')]"));
        Assert.assertEquals("Incorrect page", expectedText, actualText);

    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
//    2.1 Click on the My Account Link.
        clickOnElement(By.xpath("//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]"));

        // Call the method “selectMyAccountOptions()” method and pass the parameter “Login”
        selectMyAccountOptions("Login");
//Verify the text “Returning Customer”.
        String expectedText = "Returning Customer";
        String actualText = getTextFromElement(By.xpath(("//h2[normalize-space()='Returning Customer']")));
        Assert.assertEquals("Incorrect page", expectedText, actualText);
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() {
        //   Click on the My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

        //   Call the method “selectMyAccountOptions()” method and pass the parameter “Register”
        selectMyAccountOptions("Register");

        //    Enter the First Name
        driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("Sima");

        //   Enter the Last Name
        driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("Patel");

        //   Enter the Email
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("computer.0009@gmail.com");

        //    Enter the Telephone
        driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("02083573573");
        //    Enter the Password
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("Tester123");
        //    Enter the Password Confirm
        driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("Tester123");

        //     Select Subscribe Yes radio button
        clickOnElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/fieldset[3]/div[1]/div[1]"));

        //     Click on the Privacy Policy check box
        clickOnElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]"));

        //    Click on the Continue button
        clickOnElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/div[1]/div[1]/input[2]"));

        //    Verify the message “Your Account Has Been Created!”
        String expectedText1 = "Your Account Has Been Created!";
        String actualText1 = driver.findElement(By.linkText("Your Account Has Been Created!")).getText();
        Assert.assertEquals("Account creation message mismatch!",expectedText1,actualText1 );


        //     Click on the Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

        //    Click on the My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

        //    Call the method “selectMyAccountOptions()” method and pass the parameter “Logout”
        selectMyAccountOptions("Logout");

        //    Verify the text “Account Logout”
        Assert.assertEquals("Not logged out", "Account Logout",
                getTextFromElement(By.xpath("//h1[normalize-space()='Account Logout']")));

        //   Click on the Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

    }
@Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {

        //  Click on the My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

        // Call the method “selectMyAccountOptions()” method and pass the parameter “Login”
        selectMyAccountOptions("Login");

        // Enter the Email address
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("computer.0009@gmail.com");


        // Enter the Password
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("Tester123");


        // Click on the Login button
        clickOnElement(By.xpath("//body/div[@id='account-login']/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/input[1]"));

        //  Verify text “My Account”
        Assert.assertEquals("Not My Account", "My Account",
                getTextFromElement(By.xpath("//h2[contains(text(),'My Account')]")));
        // Click on the My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

        // Call the method “selectMyAccountOptions()” method and pass the parameter “Logout”
        selectMyAccountOptions("Logout");

        // Verify the text “Account Logout”
        Assert.assertEquals("Not logged out", "Account Logout",
                getTextFromElement(By.xpath("//h1[normalize-space()='Account Logout']")));

        //  Click on the Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

    }

    @After
    public void close() {
        driver.quit();
    }
}

