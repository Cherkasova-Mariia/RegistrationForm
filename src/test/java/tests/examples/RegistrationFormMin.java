package tests.examples;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormMin extends TestBase {

    @Test
    void TestTwo() {
    open("/automation-practice-form");
    $("[id=firstName]").setValue("Mary");
    $("[id=lastName]").setValue("Cher");
    $("[id=gender-radio-2]").click();
    $("[id=userNumber]").setValue("1234567890");
    $("[id=submit]").click();

    $("[id=example-modal-sizes-title-lg]").shouldHave(text("Thanks for submitting the form"));
    $(".table-responsive").shouldHave(text("Mary Cher"));
    $(".table-responsive").shouldHave(text("Female"));
    $(".table-responsive").shouldHave(text("1234567890"));
    }
}
