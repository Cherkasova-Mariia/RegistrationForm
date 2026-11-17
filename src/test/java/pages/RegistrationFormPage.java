package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsComponent;

import static com.codeborne.selenide.Condition.*;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormPage {
    //Elements
    CalendarComponent calendar = new CalendarComponent();
    RegistrationResultsComponent resultsComponent = new RegistrationResultsComponent();

    private SelenideElement firstNameInput = $("#firstName");
    private SelenideElement lastNameInput = $("#lastName");
    private SelenideElement userEmailCorrectInput = $("#userEmail");
    private SelenideElement userEmailIncorrectInput = $("#userEmail");
    private SelenideElement genderContainer = $("#genterWrapper");
    private SelenideElement userNumberCorrectInput = $("#userNumber");
    private SelenideElement userNumberIncorrectInput = $("#userNumber");
    private SelenideElement userSubjectsInput = $("#subjectsInput");
    private SelenideElement subjectsComplete = $(".subjects-auto-complete__option");
    private SelenideElement userHobbyInput = $("#hobbiesWrapper");
    private SelenideElement userUploadPicture = $("#uploadPicture");
    private SelenideElement userCurrentAddress = $("#currentAddress");
    private SelenideElement stateSelect =$("#state");
    private SelenideElement citySelect = $("#city");
    private SelenideElement stateCityContainer = $("#stateCity-wrapper");
    private SelenideElement submitButton = $("#submit");
    private SelenideElement outputResults = $(".modal-content");

    //Actions
    @Step("Открываем форму регистрации")
    public RegistrationFormPage openPage(){
        open("/automation-practice-form");

        return this;
    }
    @Step("Вводим имя: {value}")
    public RegistrationFormPage typeFirstName(String value){
        firstNameInput.setValue(value);

        return this;
    }

    @Step("Вводим фамилию: {value}")
    public RegistrationFormPage typeLastName(String value){
        lastNameInput.setValue(value);

        return this;
    }

    @Step("Вводим email: {value}")
    public RegistrationFormPage userEmailCorrect(String value){
        userEmailCorrectInput.setValue(value);

        return this;
    }

    @Step("Вводим email: {value}")
    public RegistrationFormPage userEmailIncorrect(String value){
        userEmailIncorrectInput.setValue(value);

        return this;
    }

    @Step("Выбираем пол: {value}")
    public RegistrationFormPage setGender (String value){
        genderContainer.$(byText(value)).click();

        return this;
    }

    @Step("Вводим номер телефона: {value}")
    public RegistrationFormPage userNumberCorrect(String value){
        userNumberCorrectInput.setValue(value);

        return this;
    }

    @Step("Вводим номер телефона: {value}")
    public RegistrationFormPage userNumberIncorrect(String value){
        userNumberIncorrectInput.setValue(value);

        return this;
    }

    @Step("Устанавливаем дату рождения: {day} {month} {year}")
    public RegistrationFormPage setDateOfBirth(String day, String month, String year){
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month, year);

        return this;
    }

    @Step("Выбираем предмет: {value}")
    public RegistrationFormPage setSubject(String value) {
        userSubjectsInput.setValue(value);
        subjectsComplete.click();
        return this;
    }

    @Step("Выбираем хобби: {value}")
    public RegistrationFormPage setHobby (String value) {
        userHobbyInput.$(byText(value)).click();

        return this;
    }

    @Step("Загружаем фотографию")
        public RegistrationFormPage setUploadPicture(){
            userUploadPicture.uploadFromClasspath("test.txt");

            return this;
    }
    @Step("Вводим текущий адрес: {value}")
    public RegistrationFormPage setCurrentAddress(String value){
        userCurrentAddress.setValue(value);

        return this;
    }

    @Step("Выбираем штат: {value}")
    public RegistrationFormPage setState (String value){
        stateSelect.click();
        stateCityContainer.$(byText(value)).click();

        return this;
    }

    @Step("Выбираем город: {value}")
    public RegistrationFormPage setCity (String value){
        citySelect.click();
        stateCityContainer.$(byText(value)).click();

        return this;
    }

    @Step("Выбираем штат '{state}' и город '{city}'")
    public RegistrationFormPage setStateAndCity (String state, String city){
        setState(state);
        setCity(city);

        return this;
    }

    @Step("Нажимаем кнопку Submit")
    public RegistrationFormPage submitForm() {
        submitButton.scrollTo().click();
        return this;
    }

    @Step("Проверяем успешное появление модального окна")
    public RegistrationFormPage checkModalWindow (){
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        return this;
    }

    @Step("Проверяем, что в таблице результатов поле {key} содержит значение {value}")
    public RegistrationFormPage checkTable(String key, String value) {
        resultsComponent.checkTable(key, value);

        return this;
    }

    @Step("Проверяем, что модальное окно не появилось")
    public RegistrationFormPage checkFieldInvisible(){
        outputResults.shouldNotBe(visible);

        return this;
    }
}
