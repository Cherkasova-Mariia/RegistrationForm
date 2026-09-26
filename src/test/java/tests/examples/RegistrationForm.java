package tests.examples;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;


public class RegistrationForm extends TestBase {

    @Test
    void firstTest() {
        open("/automation-practice-form");
        $("[id=firstName]").setValue("Mary");
        $("[id=lastName]").setValue("Cher");
        $("[id=userEmail]").setValue("mary023@gmail.com");
        $("[id=gender-radio-2]").click();

        $("[id=userNumber]").setValue("1234567890");

        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__month-select").selectOption("September");
        $(".react-datepicker__year-select").selectOption("1983");
        $(".react-datepicker__day--015").click();

        $("[id=subjectsInput]").setValue("English").pressEnter();
        $("[id=hobbies-checkbox-1]").click();
        $("[id=uploadPicture]").uploadFile(new File("src/test/resources/test.txt"));
        $("[id=currentAddress]").setValue("First address");

        $("[id=state]").click();
        $("[id=state]").$(byText("NCR")).click();
        $("[id=city]").click();
        $("[id=city]").$(byText("Delhi")).click();

        $("[id=submit]").click();


        $("[id=example-modal-sizes-title-lg]").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Mary Cher"));
        $(".table-responsive").shouldHave(text("mary023@gmail.com"));
        $(".table-responsive").shouldHave(text("Female"));
        $(".table-responsive").shouldHave(text("1234567890"));
        $(".table-responsive").shouldHave(text("15 September,1983"));
        $(".table-responsive").shouldHave(text("English"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("test.txt"));
        $(".table-responsive").shouldHave(text("First address"));
        $(".table-responsive").shouldHave(text("NCR Delhi"));

    }
}
