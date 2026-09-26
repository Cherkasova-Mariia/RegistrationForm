package tests.examples;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;


public class RegistrationForm extends TestBase {

    @Test
    void firstTest() {
        open("/automation-practice-form");
        $("[#firstName]").setValue("Mary");
        $("[#lastName]").setValue("Cher");
        $("[#userEmail]").setValue("mary023@gmail.com");
        $("[#'gender-radio-2']").click();

        $("[#userNumber]").setValue("1234567890");

        //$("[#dateOfBirthInput]").click();
      //  $("[#react-datepicker__month-select]").$(byText("September")).click();;
       // $("[#react-datepicker__month-select]").$(byText("1983")).click();;
      //  $("[#=eact-datepicker__day--015]").click();

        $("[id=subjectsInput]").setValue("English").pressEnter();
        $("[id=hobbies-checkbox-1]").click();
        $("[id=uploadPicture]").uploadFromClasspath("test.txt");
        $("[id=currentAddress]").setValue("First address");

        $("[id=react-select-3-live-region]").selectOption("NCR");
        $("[id=react-select-4-live-region]").selectOption("Delhi");
        $("[id=submit]").click();



        $("[id=output] [id=example-modal-sizes-title-lg]").shouldHave(text("Thanks for submitting the form"));
        $("[id=output] [id=email]").shouldHave(text("mary023@gmail.com"));
        $("[id=output] [id=currentAddress]").shouldHave(text("first address 1"));
        $("[id=output] [id=permanentAddress]").shouldHave(text("second address 2"));
    }
}