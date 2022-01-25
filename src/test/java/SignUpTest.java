import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest {

    @Test
    public void sendFiveDigitsToZipCodeFieldTest(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        //Open Zip code page
        driver.get("https://sharelane.com/cgi-bin/register.py");
        //Input 5 digits zip
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        //Click the 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //Check the 'Register' button is shown
        boolean isRegisterButtonDisplayed = driver.findElement(By.cssSelector("[value=Register]")).isDisplayed();
        driver.quit(); //закрывать браузер
        Assert.assertTrue(isRegisterButtonDisplayed, "Register button isn't shown");
    }
    @Test
    public void sendFourDigitsToZipCodeFieldTest(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        //Open Zip code page
        driver.get("https://sharelane.com/cgi-bin/register.py");
        //Input 4 digits zip
        driver.findElement(By.name("zip_code")).sendKeys("1234");
        //Click the 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //Check error message is shown
        boolean isErrorMessageShown = driver.findElement(By.className("error_message")).isDisplayed();
        driver.quit(); //закрывать браузер
        //Assert.fail(); в catch
        Assert.assertTrue(isErrorMessageShown, "Error massage isn't shown");
    }
    @Test
    public void sendSignInFormTest(){
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
        //Check massage 'Account is created'
        boolean isSuccessMessageShown = driver.findElement(By.className("confirmation_message")).isDisplayed();
        driver.quit();
        Assert.assertTrue(isSuccessMessageShown, "Success massage isn't shown");
    }
    @Test
    public void fillFirstNameFieldWithSpaceTest(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
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
        driver.quit();
        Assert.assertTrue(isSuccessMessageShown, "Success massage isn't shown");
    }
    @Test
    public void fillLastNameFieldWithSpaceTest(){
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
        driver.findElement(By.name("last_name")).sendKeys(" ");
        driver.findElement(By.name("email")).sendKeys("some_email@test.com");
        driver.findElement(By.name("password1")).sendKeys("string@1");
        driver.findElement(By.name("password2")).sendKeys("string@1");
        //Click register button
        driver.findElement(By.cssSelector("[value=Register]")).click();
        //Check massage 'Account is created'
        boolean isSuccessMessageShown = driver.findElement(By.className("confirmation_message")).isDisplayed();
        driver.quit();
        Assert.assertTrue(isSuccessMessageShown, "Success massage isn't shown");
    }
    @Test
    public void fillPasswordFieldWithInvalidDataTest(){
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
        driver.findElement(By.name("last_name")).sendKeys(" ");
        driver.findElement(By.name("email")).sendKeys("@1234567.");
        driver.findElement(By.name("password1")).sendKeys("string@1");
        driver.findElement(By.name("password2")).sendKeys("string@1");
        //Click register button
        driver.findElement(By.cssSelector("[value=Register]")).click();
        //Check massage 'Account is created'
        boolean isSuccessMessageShown = driver.findElement(By.className("confirmation_message")).isDisplayed();
        driver.quit();
        Assert.assertTrue(isSuccessMessageShown, "Success massage isn't shown");
    }
    @Test
    public void fillPasswordAndConfirmPasswordFieldsWithSpacesTest(){
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
        driver.findElement(By.name("last_name")).sendKeys(" Vasilkevich");
        driver.findElement(By.name("email")).sendKeys("some_email@test.com");
        driver.findElement(By.name("password1")).sendKeys("    ");//4 spaces
        driver.findElement(By.name("password2")).sendKeys("    ");
        //Click register button
        driver.findElement(By.cssSelector("[value=Register]")).click();
        //Check massage 'Account is created'
        boolean isSuccessMessageShown = driver.findElement(By.className("confirmation_message")).isDisplayed();
        driver.quit();
        Assert.assertTrue(isSuccessMessageShown, "Success massage isn't shown");
    }

    @Test
    public void fieldsPasswordAndConfirmPasswordDoNotMatchTest(){
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
        driver.findElement(By.name("last_name")).sendKeys(" ");
        driver.findElement(By.name("email")).sendKeys("some_email@test.com");
        driver.findElement(By.name("password1")).sendKeys("string@1");
        driver.findElement(By.name("password2")).sendKeys("@1string");
        //Click register button
        driver.findElement(By.cssSelector("[value=Register]")).click();
        //Check massage 'Account is created'
        boolean isSuccessMessageShown = driver.findElement(By.className("confirmation_message")).isDisplayed();
        driver.quit();
        Assert.assertTrue(isSuccessMessageShown, "Success massage isn't shown");
    }
}
