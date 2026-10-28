package tests.examples;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static tests.examples.test.data.TestDataRegistrationForm.*;


public class RegistrationFormTests extends TestBase {

    @Test
    @DisplayName("Все поля заполнены")
    void RegistrationFormMaxFields () {
        open("/automation-practice-form");

        $("[id=firstName]").setValue(firstName);
        $("[id=lastName]").setValue(lastName);
        $("[id=userEmail]").setValue(userEmail);
        $("[id=genterWrapper]").$(byText(gender)).click();
        $("[id=userNumber]").setValue(userNumber);
        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $("[role = table]").find(byText(dayOfBirth)).click();
        $("[id=subjectsInput]").setValue(subject).pressEnter();
        $("[id=hobbiesWrapper]").$(byText(hobbie)).click();
        $("[id=uploadPicture]").uploadFromClasspath("test.txt");
        $("[id=currentAddress]").setValue(currentAddress);
        $("[id=state] input").click();
        $("[id=state]").$(byText(state)).click();
        $("[id=city]").click();
        $("[id=city]").$(byText(city)).click();
        $("[id=submit]").click();

        $("[id=example-modal-sizes-title-lg]").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(firstName + " " + lastName));
        $(".table-responsive").shouldHave(text(userEmail));
        $(".table-responsive").shouldHave(text(gender));
        $(".table-responsive").shouldHave(text(userNumber));
        $(".table-responsive").shouldHave(text(dayOfBirth + " " + monthOfBirth + "," + yearOfBirth));
        $(".table-responsive").shouldHave(text(subject));
        $(".table-responsive").shouldHave(text(hobbie));
        $(".table-responsive").shouldHave(text("test.txt"));
        $(".table-responsive").shouldHave(text(currentAddress));
        $(".table-responsive").shouldHave(text(state + " " + city));
    }

    @Test
    @DisplayName("Только обязательные поля заполнены")
    void RegistrationFormMinFields() {
        open("/automation-practice-form");

        $("[id=firstName]").setValue(firstName);
        $("[id=lastName]").setValue(lastName);
        $("[id=genterWrapper]").$(byText(gender)).click();
        $("[id=userNumber]").setValue(userNumber);
        $("[id=submit]").click();

        $("[id=example-modal-sizes-title-lg]").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(firstName + " " +  lastName));
        $(".table-responsive").shouldHave(text(gender));
        $(".table-responsive").shouldHave(text(userNumber));
    }

    @Test
    @DisplayName("Все поля пустые")
    void RegistrationFormEmptyFields() {
        open("/automation-practice-form");

        $("#submit").click();
        $(".modal-content").shouldNotBe(visible);
    }

    @Test
    @DisplayName("Некорректный номер телефона")
    void RegistrationFormIncorrectNumber() {
        open("/automation-practice-form");

        $("[id=firstName]").setValue(firstName);
        $("[id=lastName]").setValue(lastName);
        $("[id=genterWrapper]").$(byText(gender)).click();
        $("[id=userNumber]").setValue(userNumberIncorrect);
        $("[id=submit]").click();

        $(".modal-content").shouldNotBe(visible);
    }

    @Test
    @DisplayName("Некорретная электронная почта")
    void RegistrationFormIncorrectEmail() {
        open("/automation-practice-form");

        $("[id=firstName]").setValue(firstName);
        $("[id=lastName]").setValue(lastName);
        $("[id=userEmail]").setValue(userEmailIncorrect);
        $("[id=genterWrapper]").$(byText(gender)).click();
        $("[id=userNumber]").setValue(userNumber);
        $("[id=submit]").click();

        $(".modal-content").shouldNotBe(visible);
    }
}


