package tests.examples.test.data;

import com.github.javafaker.Faker;

import java.util.List;
import java.util.Locale;
import java.util.Map;

public class TestDataRegistrationForm {
    public final Faker faker = new Faker();
    public final Faker fakerRu = new Faker(new Locale("ru"));

    private static final Map<String, List<String>> STATE_CITIES = Map.of(
            "NCR",           List.of("Delhi", "Gurgaon", "Noida"),
            "Uttar Pradesh", List.of("Agra", "Lucknow", "Merrut"),
            "Haryana",       List.of("Karnal", "Panipat"),
            "Rajasthan",     List.of("Jaipur", "Jaiselmer")
    );

    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String userEmailCorrect = faker.internet().emailAddress();
    public String userEmailIncorrect = fakerRu.internet().emailAddress();
    public String gender = faker.options().option("Male", "Female", "Other");
    public String userNumberCorrect = faker.number().digits(10);
    public String userNumberIncorrect = faker.number().digits(5);
    public String currentAddress = faker.address().fullAddress();
    public String monthOfBirth = faker.options().option(
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December");
    public String yearOfBirth = String.valueOf(faker.number().numberBetween(1940, 2026));
    public String dayOfBirth = String.valueOf(faker.number().numberBetween(1, 28));
    public String subject = faker.options().option(
            "Maths", "Physics", "Chemistry", "Computer Science",
            "English", "Arts", "Biology", "History", "Economics", "Civics");
    public String hobby = faker.options().option("Sports", "Reading", "Music");
    public String[] stateCity = randomStateAndCity();
    public String state = stateCity[0];
    public String city  = stateCity[1];
    public static String[] randomStateAndCity() {
        Faker faker = new Faker(); // Локальный Faker
        String state = faker.options().option(STATE_CITIES.keySet().toArray(new String[0]));
        List<String> cities = STATE_CITIES.get(state);
        String city = faker.options().option(cities.toArray(new String[0]));
        return new String[]{state, city};
    }
}