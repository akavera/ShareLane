package utilities;

import com.github.javafaker.Faker;

public class GenerateFakeMessage {
    public static String getValidZipCode(){
        Faker faker = new Faker();
        return faker.numerify("#####");
    }
    public static String getSixDigitsZipCode(){
        Faker faker = new Faker();
        return faker.numerify("######");
    }
    public static String getFourDigitsZipCode(){
        Faker faker = new Faker();
        return faker.numerify("####");
    }
}
