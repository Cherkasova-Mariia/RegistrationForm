package tests.examples;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;
import tests.examples.test.data.TestDataRegistrationForm;

public class RegistrationFormTests extends TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @Test
    @DisplayName("Все поля заполнены")
    void registrationFormMaxFields() {
        TestDataRegistrationForm data = new TestDataRegistrationForm();

        registrationFormPage.openPage()
                .typeFirstName(data.firstName)
                .typeLastName(data.lastName)
                .userEmailCorrect(data.userEmailCorrect)
                .setGender(data.gender)
                .userNumberCorrect(data.userNumberCorrect)
                .setDateOfBirth(data.dayOfBirth, data.monthOfBirth, data.yearOfBirth)
                .setSubject(data.subject)
                .setHobby(data.hobby)
                .setUploadPicture()
                .setCurrentAddress(data.currentAddress)
                .setStateAndCity(data.state, data.city)
                .submitForm()

                .checkModalWindow()
                .checkTable("Student Name", (data.firstName + " " + data.lastName))
                .checkTable("Student Email", data.userEmailCorrect)
                .checkTable("Gender", data.gender)
                .checkTable("Mobile", data.userNumberCorrect)
                .checkTable("Date of Birth", data.dayOfBirth + " " + data.monthOfBirth + "," + data.yearOfBirth)
                .checkTable("Subjects", data.subject)
                .checkTable("Hobbies", data.hobby)
                .checkTable("Picture", "test.txt")
                .checkTable("Address", data.currentAddress)
                .checkTable("State and City", data.state + " " + data.city);
    }

    @Test
    @DisplayName("Только обязательные поля заполнены")
    void registrationFormMinFields() {
        TestDataRegistrationForm data = new TestDataRegistrationForm();

        registrationFormPage.openPage()
                .typeFirstName(data.firstName)
                .typeLastName(data.lastName)
                .setGender(data.gender)
                .userNumberCorrect(data.userNumberCorrect)
                .submitForm()

                .checkModalWindow()
                .checkTable("Student Name", (data.firstName + " " + data.lastName))
                .checkTable("Gender", data.gender)
                .checkTable("Mobile", data.userNumberCorrect);
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
        TestDataRegistrationForm data = new TestDataRegistrationForm();

        registrationFormPage.openPage()
                .typeFirstName(data.firstName)
                .typeLastName(data.lastName)
                .setGender(data.gender)
                .userNumberIncorrect(data.userNumberIncorrect)
                .submitForm()
                .checkFieldInvisible();
    }

    @Test
    @DisplayName("Некорретная электронная почта")
    void registrationFormIncorrectEmail() {
        TestDataRegistrationForm data = new TestDataRegistrationForm();

        registrationFormPage.openPage()
                .typeFirstName(data.firstName)
                .typeLastName(data.lastName)
                .userEmailIncorrect(data.userEmailIncorrect)
                .setGender(data.gender)
                .userNumberCorrect(data.userNumberCorrect)
                .submitForm()
                .checkFieldInvisible();
    }
}