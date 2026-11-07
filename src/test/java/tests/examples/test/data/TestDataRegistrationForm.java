package tests.examples.test.data;

import com.github.javafaker.Faker;

import java.util.List;
import java.util.Locale;
import java.util.Map;

public class TestDataRegistrationForm {
    public static final Faker faker = new Faker();
    public static final Faker fakerRu = new Faker(new Locale("ru"));

  private static final Map<String, List<String>> STATE_CITIES = Map.of(
          "NCR",           List.of("Delhi", "Gurgaon", "Noida"),
          "Uttar Pradesh", List.of("Agra", "Lucknow", "Merrut"),
          "Haryana",       List.of("Karnal", "Panipat"),
          "Rajasthan",     List.of("Jaipur", "Jaiselmer")
  );

    public static String firstName = faker.name().firstName();
    public static String lastName = faker.name().lastName();
    public static String userEmailCorrect = faker.internet().emailAddress();
    public static String userEmailIncorrect = fakerRu.internet().emailAddress();
    public static String gender = faker.options().option("Male", "Female", "Other");
    public static String userNumberCorrect = faker.number().digits(10);
    public static String userNumberIncorrect = faker.number().digits(5);
    public static String currentAddress = faker.address().fullAddress();
    public static String monthOfBirth = faker.options().option(
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December");
    public static String yearOfBirth = String.valueOf(faker.number().numberBetween(1940, 2026));
    public static String dayOfBirth = String.valueOf(faker.number().numberBetween(1, 28));
    public static String subject = faker.options().option(
            "Maths", "Physics", "Chemistry", "Computer Science",
            "English", "Arts", "Biology", "History", "Economics", "Civics");
    public static String hobby = faker.options().option("Sports", "Reading", "Music");
    public static String[] stateCity = randomStateAndCity();
    public static String state = stateCity[0];
    public static String city  = stateCity[1];

    public static String[] randomStateAndCity() {
        String state = faker.options().option(STATE_CITIES.keySet().toArray(new String[0]));
        List<String> cities = STATE_CITIES.get(state);
        String city = faker.options().option(cities.toArray(new String[0]));
        return new String[]{state, city};
    }
}

