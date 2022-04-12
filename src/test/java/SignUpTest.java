import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class SignUpTest {

    //private static final String baseUrl = "https://sharelane.com/cgi-bin/register.py;
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void sendFiveDigitsToZipCodeFieldTest(){
        Faker faker = new Faker();
        String zipCade = faker.address().zipCode();
        //Open Zip code page
        driver.get("https://sharelane.com/cgi-bin/register.py");
        //Input 5 digits zip
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        //Click the 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //Check the 'Register' button is shown
        boolean isRegisterButtonDisplayed = driver.findElement(By.cssSelector("[value=Register]")).isDisplayed();
        Assert.assertTrue(isRegisterButtonDisplayed, "Register button isn't shown");
    }
    @Test
    public void sendFourDigitsToZipCodeFieldTest(){
        //Open Zip code page
        driver.get("https://sharelane.com/cgi-bin/register.py");
        //Input 4 digits zip
        driver.findElement(By.name("zip_code")).sendKeys("1234");
        //Click the 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //Check error message is shown
        boolean isErrorMessageShown = driver.findElement(By.className("error_message")).isDisplayed();
        //Assert.fail(); в catch
        Assert.assertTrue(isErrorMessageShown, "Error massage isn't shown");
    }
    @Test
    public void sendSignInFormTest(){
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
        //Check massage 'Account is created'
        boolean isSuccessMessageShown = driver.findElement(By.className("confirmation_message")).isDisplayed();
        Assert.assertTrue(isSuccessMessageShown, "Success massage isn't shown");
    }
    @Test
    public void fillFirstNameFieldWithSpaceTest(){
        //Open Zip code page
        driver.get("https://sharelane.com/cgi-bin/register.py");
        //Input 5 digits zip
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        //Click the 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //Input data into fields
        driver.findElement(By.name("first_name")).sendKeys(" ");
        driver.findElement(By.name("last_name")).sendKeys("Vasilkevich");
        driver.findElement(By.name("email")).sendKeys("some_email@test.com");
        driver.findElement(By.name("password1")).sendKeys("string@1");
        driver.findElement(By.name("password2")).sendKeys("string@1");
        //Click register button
        driver.findElement(By.cssSelector("[value=Register]")).click();
        //Check massage 'Account is created'
        boolean isSuccessMessageShown = driver.findElement(By.className("confirmation_message")).isDisplayed();
        Assert.assertTrue(isSuccessMessageShown, "Success massage isn't shown");
    }
    @Test
    public void fillLastNameFieldWithSpaceTest(){
        //Open Zip code page
        driver.get("https://sharelane.com/cgi-bin/register.py");
        //Input 5 digits zip
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        //Click the 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //Input data into fields
        driver.findElement(By.name("first_name")).sendKeys("Vera");
        driver.findElement(By.name("last_name")).sendKeys(" ");
        driver.findElement(By.name("email")).sendKeys("some_email@test.com");
        driver.findElement(By.name("password1")).sendKeys("string@1");
        driver.findElement(By.name("password2")).sendKeys("string@1");
        //Click register button
        driver.findElement(By.cssSelector("[value=Register]")).click();
        //Check massage 'Account is created'
        boolean isSuccessMessageShown = driver.findElement(By.className("confirmation_message")).isDisplayed();
        Assert.assertTrue(isSuccessMessageShown, "Success massage isn't shown");
    }
    @Test
    public void fillPasswordFieldWithInvalidDataTest(){
        //Open Zip code page
        driver.get("https://sharelane.com/cgi-bin/register.py");
        //Input 5 digits zip
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        //Click the 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //Input data into fields
        driver.findElement(By.name("first_name")).sendKeys("Vera");
        driver.findElement(By.name("last_name")).sendKeys(" ");
        driver.findElement(By.name("email")).sendKeys("@1234567.");
        driver.findElement(By.name("password1")).sendKeys("string@1");
        driver.findElement(By.name("password2")).sendKeys("string@1");
        //Click register button
        driver.findElement(By.cssSelector("[value=Register]")).click();
        //Check massage 'Account is created'
        boolean isSuccessMessageShown = driver.findElement(By.className("confirmation_message")).isDisplayed();
        Assert.assertTrue(isSuccessMessageShown, "Success massage isn't shown");
    }
    @Test
    public void fillPasswordAndConfirmPasswordFieldsWithSpacesTest(){
        //Open Zip code page
        driver.get("https://sharelane.com/cgi-bin/register.py");
        //Input 5 digits zip
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        //Click the 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //Input data into fields
        driver.findElement(By.name("first_name")).sendKeys("Vera");
        driver.findElement(By.name("last_name")).sendKeys(" Vasilkevich");
        driver.findElement(By.name("email")).sendKeys("some_email@test.com");
        driver.findElement(By.name("password1")).sendKeys("    ");//4 spaces
        driver.findElement(By.name("password2")).sendKeys("    ");
        //Click register button
        driver.findElement(By.cssSelector("[value=Register]")).click();
        //Check massage 'Account is created'
        boolean isSuccessMessageShown = driver.findElement(By.className("confirmation_message")).isDisplayed();
        Assert.assertTrue(isSuccessMessageShown, "Success massage isn't shown");
    }

    @Test
    public void fieldsPasswordAndConfirmPasswordDoNotMatchTest(){
        //Open Zip code page
        driver.get("https://sharelane.com/cgi-bin/register.py");
        //Input 5 digits zip
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        //Click the 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //Input data into fields
        driver.findElement(By.name("first_name")).sendKeys("Vera");
        driver.findElement(By.name("last_name")).sendKeys(" ");
        driver.findElement(By.name("email")).sendKeys("some_email@test.com");
        driver.findElement(By.name("password1")).sendKeys("string@1");
        driver.findElement(By.name("password2")).sendKeys("@1string");
        //Click register button
        driver.findElement(By.cssSelector("[value=Register]")).click();
        //Check massage 'Account is created'
        boolean isSuccessMessageShown = driver.findElement(By.className("confirmation_message")).isDisplayed();
        Assert.assertTrue(isSuccessMessageShown, "Success massage isn't shown");
    }
    @Test
    public void sentMoreThanFiveDigitsToZipCodeTest() throws FileNotFoundException{
        //Open Zip code page
        driver.get("https://sharelane.com/cgi-bin/register.py");
        //Input 6 digits zip
        driver.findElement(By.name("zip_code")).sendKeys("123456");
        //Click the 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        try{
            boolean isErrorMessageShown = driver.findElement(By.className("error_message")).isDisplayed();
            Assert.assertTrue(isErrorMessageShown,"Check Message");
        } catch (NoSuchElementException exception){
            Assert.fail();
        } finally {
            driver.quit();
        }
    }


    @AfterMethod
        public void tearDown(){
        driver.quit();//закрыть браузер
    }
}
