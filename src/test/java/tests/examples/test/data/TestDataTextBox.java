package tests.examples.test.data;

import com.github.javafaker.Faker;

import static utils.RandomUtils.*;

public class TestDataTextBox {
   private static final Faker faker = new Faker();
    public static String userName = faker.name().fullName();
    public static String userEmailCorrect = faker.internet().emailAddress();
    public static String currentAddress = faker.address().fullAddress();
    public static String permanentAddress = faker.address().fullAddress();

}
