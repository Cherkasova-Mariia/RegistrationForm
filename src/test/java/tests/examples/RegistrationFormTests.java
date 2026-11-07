package tests.examples;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;

import static tests.examples.test.data.TestDataRegistrationForm.*;

public class RegistrationFormTests extends TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @Test
    @DisplayName("Все поля заполнены")
    void registrationFormMaxFields () {

        registrationFormPage.openPage()
                        .typeFirstName(firstName)
                        .typeLastName(lastName)
                        .userEmailCorrect(userEmailCorrect)
                        .setGender(gender)
                        .userNumberCorrect(userNumberCorrect)
                        .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                        .setSubject(subject)
                        .setHobby(hobby)
                        .setUploadPicture()
                        .setCurrentAddress(currentAddress)
                        .setStateAndCity(state, city)
                        .submitForm()

                        .checkModalWindow()
                        .checkTable("Student Name", (firstName + " " + lastName))
                        .checkTable("Student Email", userEmailCorrect)
                        .checkTable("Gender", gender)
                        .checkTable("Mobile", userNumberCorrect)
                        .checkTable("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                        .checkTable("Subjects", subject)
                        .checkTable("Hobbies", hobby)
                        .checkTable("Picture", "test.txt")
                        .checkTable("Address", currentAddress)
                        .checkTable("State and City", state + " " + city);
    }

    @Test
    @DisplayName("Только обязательные поля заполнены")
    void registrationFormMinFields() {
        registrationFormPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .setGender(gender)
                .userNumberCorrect(userNumberCorrect)
                .submitForm()

                .checkModalWindow()
                .checkTable("Student Name", (firstName + " " + lastName))
                .checkTable("Gender", gender)
                .checkTable("Mobile", userNumberCorrect);
    }

    @Test
    @DisplayName("Все поля пустые")
    void registrationFormEmptyFields() {
        registrationFormPage.openPage()
                .submitForm()

                .checkFieldInvisible();

    }

    @Test
    @DisplayName("Некорректный номер телефона")
    void registrationFormIncorrectNumber() {
        registrationFormPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .setGender(gender)
                .userNumberIncorrect(userNumberIncorrect)
                .submitForm()

                .checkFieldInvisible();
    }

    @Test
    @DisplayName("Некорретная электронная почта")
    void registrationFormIncorrectEmail() {
        registrationFormPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .userEmailIncorrect(userEmailIncorrect)
                .setGender(gender)
                .userNumberCorrect(userNumberCorrect)
                .submitForm()

                .checkFieldInvisible();
    }
}


