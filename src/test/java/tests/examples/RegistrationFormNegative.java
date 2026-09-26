package tests.examples;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormNegative extends TestBase {
    @Test
    void TestThree() {
        open("/automation-practice-form");
        $("#submit").click();
        $(".modal-content").shouldNotBe(visible);

    }

    @Test
    void TestFour() {
        open("/automation-practice-form");
        $("[id=firstName]").setValue("Mary");
        $("[id=lastName]").setValue("Cher");
        $("[id=gender-radio-2]").click();
        $("[id=userNumber]").setValue("111");
        $("[id=submit]").click();

        $(".modal-content").shouldNotBe(visible);

    }

    @Test
    void TestFive() {
        open("/automation-practice-form");
        $("[id=firstName]").setValue("Mary");
        $("[id=lastName]").setValue("Cher");
        $("[id=userEmail]").setValue("mary023");
        $("[id=gender-radio-2]").click();
        $("[id=userNumber]").setValue("11111111111");
        $("[id=submit]").click();

        $(".modal-content").shouldNotBe(visible);

    }
}
