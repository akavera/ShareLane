import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ShoppingCartTest {

    @Test
    public void addToCartFunctionTest(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        //Open Zip code page
        driver.get("https://sharelane.com/cgi-bin/register.py");
        //Input 5 digits zip
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        //Click the 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //Input data into fields
        driver.findElement(By.name("first_name")).sendKeys("Vera");
        driver.findElement(By.name("last_name")).sendKeys("Vasilkevich");
        driver.findElement(By.name("email")).sendKeys("some_email@test.com");
        driver.findElement(By.name("password1")).sendKeys("string@1");
        driver.findElement(By.name("password2")).sendKeys("string@1");
        //Click register button
        driver.findElement(By.cssSelector("[value=Register]")).click();
        //Return to homepage
//        driver.findElement(By.name("./main.py")).click();
//        //add book to cart
//        driver.findElement(By.name("./show book.py?book id=4")).click();// 10 7 6 2 1
//        driver.findElement(By.name("../images/add_to_cart.gif")).click();
//        driver.findElement(By.name("./shopping_cart.py")).click();
//        driver.findElement(By.name("text")).click();

    }
}
