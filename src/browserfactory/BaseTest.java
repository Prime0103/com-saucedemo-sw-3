package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest
{
    public static WebDriver driver;
    public void openBrowser(String baseUrl){
        //launch the Chrome Browser
        driver = new ChromeDriver();
        //open URL into browser
        driver.get(baseUrl);
        //Maximise Browser
        driver .manage().window().maximize();
        //we give implicit wait to Driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    public void closeBrowser(){
        driver.quit();
    }
}
