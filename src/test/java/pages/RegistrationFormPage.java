package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static tests.examples.test.data.TestDataRegistrationForm.*;

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
    private SelenideElement userHobbyInput = $("#hobbiesWrapper");
    private SelenideElement userUploadPicture = $("#uploadPicture");
    private SelenideElement userCurrentAddress = $("#currentAddress");
    private SelenideElement stateSelect =$("#state");
    private SelenideElement citySelect = $("#city");
    private SelenideElement stateCityContainer = $("#stateCity-wrapper");
    private SelenideElement submitButton = $("#submit");
    private SelenideElement outputResults = $(".modal-content");


    //Actions

    public RegistrationFormPage openPage(){
        open("/automation-practice-form");

        return this;
    }

    public RegistrationFormPage typeFirstName(String value){
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage typeLastName(String value){
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage userEmailCorrect(String value){
        userEmailCorrectInput.setValue(value);

        return this;
    }

    public RegistrationFormPage userEmailIncorrect(String value){
        userEmailIncorrectInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setGender (String value){
        genderContainer.$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage userNumberCorrect(String value){
        userNumberCorrectInput.setValue(value);

        return this;
    }

    public RegistrationFormPage userNumberIncorrect(String value){
        userNumberIncorrectInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setDateOfBirth(String day, String month, String year){
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month, year);

        return this;
    }

    public RegistrationFormPage setSubject (String value){
        userSubjectsInput.setValue(subject).pressEnter();

        return this;
    }

    public RegistrationFormPage setHobby (String value) {
        userHobbyInput.$(byText(hobby)).click();

        return this;
    }

        public RegistrationFormPage setUploadPicture(){
            userUploadPicture.uploadFromClasspath("test.txt");

            return this;
    }

    public RegistrationFormPage setCurrentAddress(String value){
        userCurrentAddress.setValue(value);

        return this;
    }

    public RegistrationFormPage setState (String value){
        stateSelect.click();
        stateCityContainer.$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage setCity (String value){
        citySelect.click();
        stateCityContainer.$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage setStateAndCity (String state, String city){
        setState(state);
        setCity(city);

        return this;
    }

    public RegistrationFormPage  submitForm(){
        submitButton.click();

        return this;
    }

    public RegistrationFormPage checkModalWindow (){
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        return this;
    }

    public RegistrationFormPage checkTable(String key, String value) {
        resultsComponent.checkTable(key, value);

        return this;
    }

    public RegistrationFormPage checkFieldInvisible(){
        outputResults.shouldNotBe(visible);

        return this;
    }
}
