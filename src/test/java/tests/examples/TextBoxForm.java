package tests.examples;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static tests.examples.test.data.TestDataTextBox.*;

public class TextBoxForm extends TestBase{

    @Test
    @DisplayName("Позитивный - все поля заполнены")
    void AllFields() {
        open("/text-box");
        $("[id=userName]").setValue(userName);
        $("[id=userEmail]").setValue(userEmailCorrect);
        $("[id=currentAddress]").setValue(currentAddress);
        $("[id=permanentAddress]").setValue(permanentAddress);
        $("[id=submit]").click();

        $("[id=output] [id=name]").shouldHave(text(userName));
        $("[id=output] [id=email]").shouldHave(text(userEmailCorrect));
        $("[id=output] [id=currentAddress]").shouldHave(text(currentAddress));
        $("[id=output] [id=permanentAddress]").shouldHave(text(permanentAddress));
    }

    @Test
    @DisplayName("Негативный - некорретный email")
    void IncorrectEmail() {
        open("/text-box");
        $("[id=userName]").setValue(userName);
        $("[id=userEmail]").setValue(userEmailIncorrect);
        $("[id=currentAddress]").setValue(currentAddress);
        $("[id=permanentAddress]").setValue(permanentAddress);
        $("[id=submit]").click();

        $("[id=output]").shouldNotBe(visible);
    }
}


