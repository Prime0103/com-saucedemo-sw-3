package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility
{
    String baseUrl="https://www.saucedemo.com/";

    @Before
    public void setUp()
    {
        openBrowser(baseUrl);
    }
    @Test
    public void VerifyUserShouldLoginSuccessfullyWithCredentials()
    {
        //Enter “standard_user” username
        sendTextToElement(By.xpath("//input[@id='user-name']"),"standard_user");
        //Enter “secret_sauce” password
        sendTextToElement(By.xpath("//input[@id='password']"),"secret_sauce");
        //Click on 'LOGIN' button
        clickOnElement(By.xpath("//input[@id='login-button']"));
        //Verify the text "PRODUCTS"
        String expectedMessage="Products";
        String actualMessage=getTextFromElement(By.xpath("//span[contains(text(),'Products')]"));
        Assert.assertEquals(expectedMessage,actualMessage);
    }
    @Test
    public void verifyThatSixProductsAreDisplayOnPage()
    {

        //Enter “standard_user” username
        sendTextToElement(By.xpath("//input[@id='user-name']"),"standard_user");
        //Enter “secret_sauce” password
        sendTextToElement(By.xpath("//input[@id='password']"),"secret_sauce");
        //Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@id='login-button']"));
        //Verify that six products are displayed on page
        int expectedMessage = 6;
        List<WebElement> totalProduct = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        int actualMessage = totalProduct.size();
        Assert.assertEquals(expectedMessage, actualMessage);
    }
    @After
    public void tearDown()
    {
        //close the Browser
        driver.quit();
    }
}
