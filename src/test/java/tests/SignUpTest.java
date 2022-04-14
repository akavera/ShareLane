package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import staticdata.WebUrls;
import utilities.GenerateFakeMessage;


public class SignUpTest extends BaseTest{

    @Test
    public void sendFiveDigitsToZipCodeFieldTest(){
        sendZipCode(GenerateFakeMessage.getValidZipCode());
        //Check the 'Register' button is shown
        boolean isRegisterButtonDisplayed = driver.findElement(By.cssSelector("[value=Register]")).isDisplayed();
        Assert.assertTrue(isRegisterButtonDisplayed, "Register button isn't shown");
    }
    @Test
    public void sendFourDigitsToZipCodeFieldTest(){
        sendZipCode(GenerateFakeMessage.getFourDigitsZipCode());
        //Check error message is shown
        boolean isErrorMessageShown = driver.findElement(By.className("error_message")).isDisplayed();
        //Assert.fail(); в catch
        Assert.assertTrue(isErrorMessageShown, "Error massage isn't shown");
    }
    @Test
    public void sendSignInFormTest(){
        sendZipCode(GenerateFakeMessage.getValidZipCode());
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
        sendZipCode(GenerateFakeMessage.getValidZipCode());
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
        sendZipCode(GenerateFakeMessage.getValidZipCode());
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
        sendZipCode(GenerateFakeMessage.getValidZipCode());
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
        sendZipCode(GenerateFakeMessage.getValidZipCode());
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
        sendZipCode(GenerateFakeMessage.getValidZipCode());
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
//        sendZipCode(GenerateFakeMessage.getValidZipCode);
//        try{
//            boolean isErrorMessageShown = driver.findElement(By.className("error_message")).isDisplayed();
//            Assert.assertTrue(isErrorMessageShown,"Check Message");
//        } catch (NoSuchElementException exception){
//            Assert.fail();
//        }
//    }
    private void sendZipCode(String zipCode){
        driver.get(WebUrls.SHARELANE_REGISTER_URL);
        driver.findElement(By.name("zip_code")).sendKeys(zipCode);
        driver.findElement(By.cssSelector("[value=Continue]")).click();
    }



}
