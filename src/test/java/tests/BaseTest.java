package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.PropertiesManager;

public class BaseTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        PropertiesManager propertiesManager = new PropertiesManager();
        System.setProperty("webdriver.chrome.driver",propertiesManager.get("PATH_TO_CHROME_DRIVER"));
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();//закрыть браузер
    }
}
