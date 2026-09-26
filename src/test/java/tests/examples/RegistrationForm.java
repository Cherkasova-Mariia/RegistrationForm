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

        //$("[id=dateOfBirthInput]").click();
      //  $("[id=react-datepicker__month-select]").$(byText("September")).click();
       // $("[id=react-datepicker__month-select]").$(byText("1983")).click();
      //  $("[id=react-datepicker__day--015]").click();

        $("[id=subjectsInput]").setValue("English").pressEnter();
        $("[id=hobbies-checkbox-1]").click();
        $("[id=uploadPicture]").uploadFile(new File("src/test/resources/test.txt"));
        $("[id=currentAddress]").setValue("First address");

        $("[id=state]").click();
        $("[id=state]").$(byText("NCR")).click();
        $("[id=city]").click();
        $("[id=city]").$(byText("Delhi")).click();

        $("[id=submit]").click();


        $("[id=output] [id=modal-title]").shouldHave(text("Thanks for submitting the form"));
        $("[id=output] [id=email]").shouldHave(text("mary023@gmail.com"));
        $("[id=output] [id=currentAddress]").shouldHave(text("first address 1"));
        $("[id=output] [id=permanentAddress]").shouldHave(text("second address 2"));
        $("[id=output] [id=permanentAddress]").shouldHave(text("second address 2"));    }



    }