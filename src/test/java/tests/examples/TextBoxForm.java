package tests.examples;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

import static utils.RandomUtils.*;

public class TextBoxForm extends TestBase{
    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    @DisplayName("Позитивный - все поля заполнены")
    void allFields_with_faker() {
        Faker faker = new Faker();
        String userName = faker.name().fullName();
        String userEmailCorrect = faker.internet().emailAddress();
        String currentAddress = faker.address().fullAddress();
        String permanentAddress = faker.address().fullAddress();

        textBoxPage.openPage()
                .typeUserName(userName)
                .typeUserEmailCorrect(userEmailCorrect)
                .typeCurrentAddress(currentAddress)
                .typePermanentAddress(permanentAddress)
                .submitForm()

                .checkField("name", userName)
                .checkField("email", userEmailCorrect)
                .checkField("currentAddress", currentAddress)
                .checkField("permanentAddress", permanentAddress);
    }

    @Test
    @DisplayName("Позитивный - все поля заполнены")
    void allFields_with_utils() {
        String userName = getRandomString(10);
        String userEmailCorrect = getRandomEmail();
        String currentAddress = getRandomString(100);
        String permanentAddress = getRandomString(90);

        textBoxPage.openPage()
                .typeUserName(userName)
                .typeUserEmailCorrect(userEmailCorrect)
                .typeCurrentAddress(currentAddress)
                .typePermanentAddress(permanentAddress)
                .submitForm()

                .checkField("name", userName)
                .checkField("email", userEmailCorrect)
                .checkField("currentAddress", currentAddress)
                .checkField("permanentAddress", permanentAddress);
    }

    @Test
    @DisplayName("Негативный - некорретный email")
    void incorrectEmail_with_utils() {
        String userName = getRandomString(10);
        String userEmailIncorrect = getRandomEmailIncorrect();
        String currentAddress = getRandomString(100);
        String permanentAddress = getRandomString(90);

        textBoxPage.openPage()
                .typeUserName(userName)
                .typeUserEmailIncorrect(userEmailIncorrect)
                .typeCurrentAddress(currentAddress)
                .typePermanentAddress(permanentAddress)
                .submitForm()

                .checkFieldInvisible();
    }
}


