package tests.examples;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;
import tests.examples.test.data.TestDataRegistrationForm;

import static io.qameta.allure.Allure.step;

public class RegistrationFormTests extends TestBase {

    @Test
    @DisplayName("Все поля заполнены")
    void registrationFormMaxFields() {
        TestDataRegistrationForm data = new TestDataRegistrationForm();

        step("Открываем главную страницу", () ->
                registrationFormPage.openPage());

        step("Заполняем все поля формы", () -> {
            registrationFormPage.typeFirstName(data.firstName)
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
                    .submitForm();
        });

        step("Проверяем результат", () -> {
            registrationFormPage.checkModalWindow()
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
        });
    }

    @Test
    @DisplayName("Только обязательные поля заполнены")
    void registrationFormMinFields() {
        TestDataRegistrationForm data = new TestDataRegistrationForm();

        step("Открываем главную страницу", () ->
                registrationFormPage.openPage());

        step("Заполняем обязательные поля формы", () -> {
            registrationFormPage.typeFirstName(data.firstName)
                    .typeLastName(data.lastName)
                    .setGender(data.gender)
                    .userNumberCorrect(data.userNumberCorrect)
                    .submitForm();
        });

        step("Проверяем результат", () -> {
            registrationFormPage.checkModalWindow()
                    .checkTable("Student Name", (data.firstName + " " + data.lastName))
                    .checkTable("Gender", data.gender)
                    .checkTable("Mobile", data.userNumberCorrect);
        });
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

        step("Открываем главную страницу", () ->
                registrationFormPage.openPage());

        step("Заполняем обязательные поля формы, указывая номер телефона в некорректном формате", () -> {

            registrationFormPage.typeFirstName(data.firstName)
                    .typeLastName(data.lastName)
                    .setGender(data.gender)
                    .userNumberIncorrect(data.userNumberIncorrect)
                    .submitForm();
        });

        step("Проверяем, что модальное окно не появилось", () ->
                registrationFormPage.checkFieldInvisible());
    }

    @Test
    @DisplayName("Некорректная электронная почта")
    void registrationFormIncorrectEmail() {
        TestDataRegistrationForm data = new TestDataRegistrationForm();

        step("Открываем главную страницу", () ->
                registrationFormPage.openPage());

        step("Заполняем обязательные поля формы, указывая некорректный email", () -> {
            registrationFormPage.typeFirstName(data.firstName)
                    .typeLastName(data.lastName)
                    .userEmailIncorrect(data.userEmailIncorrect)
                    .setGender(data.gender)
                    .userNumberCorrect(data.userNumberCorrect)
                    .submitForm();
        });

        step("Проверяем, что модальное окно не появилось", () ->
                registrationFormPage.checkFieldInvisible());
    }
}