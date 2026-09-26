package tests.examples;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxForm extends TestBase{
    @Test
    void TestFirst() {
        open("/text-box");
        $("[id=userName]").setValue("Ivanov Ivan");
        $("[id=userEmail]").setValue("Ivanov@gmail.com");
        $("[id=currentAddress]").setValue("Moscow");
        $("[id=permanentAddress]").setValue("Ryazan");
        $("[id=submit]").click();

        $("[id=output] [id=name]").shouldHave(text("Ivanov Ivan"));
        $("[id=output] [id=email]").shouldHave(text("Ivanov@gmail.com"));
        $("[id=output] [id=currentAddress]").shouldHave(text("Moscow"));
        $("[id=output] [id=permanentAddress]").shouldHave(text("Ryazan"));
    }

    @Test
    void TestSecond() {
        open("/text-box");
        $("[id=userName]").setValue("Ivanov Ivan");
        $("[id=userEmail]").setValue("Ivanov@gmail");
        $("[id=currentAddress]").setValue("Moscow");
        $("[id=permanentAddress]").setValue("Ryazan");
        $("[id=submit]").click();

        $("[id=output]").shouldNotBe(visible);
    }
}
