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

    private static final String BASE_URL = "https://sharelane.com/cgi-bin/register.py";
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void sendFiveDigitsToZipCodeFieldTest(){
        Faker faker = new Faker();
        sendZipCode("12345");
        //Check the 'Register' button is shown
        boolean isRegisterButtonDisplayed = driver.findElement(By.cssSelector("[value=Register]")).isDisplayed();
        Assert.assertTrue(isRegisterButtonDisplayed, "Register button isn't shown");
    }
    @Test
    public void sendFourDigitsToZipCodeFieldTest(){
        Faker faker = new Faker();
        sendZipCode("1234");
        //Check error message is shown
        boolean isErrorMessageShown = driver.findElement(By.className("error_message")).isDisplayed();
        //Assert.fail(); в catch
        Assert.assertTrue(isErrorMessageShown, "Error massage isn't shown");
    }
    @Test
    public void sendSignInFormTest(){
        Faker faker = new Faker();
        sendZipCode("12345");
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
        Faker faker = new Faker();
        sendZipCode("12345");
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
        Faker faker = new Faker();
        sendZipCode("12345");
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
        Faker faker = new Faker();
        sendZipCode("12345");
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
        Faker faker = new Faker();
        sendZipCode("12345");
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
        Faker faker = new Faker();
        sendZipCode("12345");
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
//    @Test
//    public void sentMoreThanFiveDigitsToZipCodeTest(){
//        Faker faker = new Faker();
//        sendZipCode("123456");
//        try{
//            boolean isErrorMessageShown = driver.findElement(By.className("error_message")).isDisplayed();
//            Assert.assertTrue(isErrorMessageShown,"Check Message");
//        } catch (NoSuchElementException exception){
//            Assert.fail();
//        }
//    }
    private void sendZipCode(String zipCode){
        driver.get(BASE_URL);
        driver.findElement(By.name("zip_code")).sendKeys(zipCode);
        driver.findElement(By.cssSelector("[value=Continue]")).click();
    }


    @AfterMethod
        public void tearDown(){
        driver.quit();//закрыть браузер
    }
}
