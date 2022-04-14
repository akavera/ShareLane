package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class MyPageTest extends BaseTest{


    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
        driver = new ChromeDriver();
        System.out.println("Start Driver");
    }

}
