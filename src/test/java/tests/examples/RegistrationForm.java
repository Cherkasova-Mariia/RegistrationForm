package tests.examples;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationForm extends TestBase {

    @Test
    void firstTest() {
        open("/automation-practice-form");
        $("[id=firstName]").setValue("Mary");
        $("[id=lastName]").setValue("Cher");
        $("[id=userEmail]").setValue("mary023@gmail.com");
        $("[for='gender-radio-2']").click();

        $("[id=userNumber]").setValue("1234567890");

        // Открываем календарь
        $("[id=dateOfBirthInput]").click();

// Месяц выбирается стандартным селектором ТЕКСТОМ
        $("[class^='react-datepicker__month-select']").selectOption("September");

// Год выбираем через кнопку и ввод цифр
        $("[class*='react-datepicker__year-option']") // Это именно та кнопка со стрелками
                .scrollTo()
                .doubleClick();                     // Двойной клик открывает поле ввода года
        $("[class*='react-datepicker__input']")
                .setValue("1983");                 // Вводим год вручную;

        CharSequence Enter;
        $("[id=subjectsInput]").sendKeys("Maths", Keys.ENTER);;

        $(byText("Reading")).click();

        $("[id=currentAddress]").setValue("First address");


        $("id=output] [id=firstName]").shouldHave(text("Mary"));
        $("[id=output] [id=email]").shouldHave(text("mary023@gmail.com"));
        $("[id=output] [id=currentAddress]").shouldHave(text("first address 1"));
        $("[id=output] [id=permanentAddress]").shouldHave(text("second address 2"));
    }
}