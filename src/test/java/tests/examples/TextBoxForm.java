package tests.examples;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static tests.examples.test.data.TestDataTextBox.*;
import static com.codeborne.selenide.Selectors.byId;

public class TextBoxForm extends TestBase{
    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    @DisplayName("Позитивный - все поля заполнены")
    void allFields() {
        textBoxPage.openPage()
                .typeUserName(userName)
                .typeUserEmailCorrect(userEmailCorrect)
                .typeCurrentAddress(currentAddress)
                .typePermanentAddress(permanentAddress)
                .submitForm()

                .checkField("name", userName)
                .checkField("email", userEmailCorrect)
                .checkField("currentAddress", currentAddress)
                .checkField("permanentAddress", permanentAddress);
    }

    @Test
    @DisplayName("Негативный - некорретный email")
    void incorrectEmail() {
        textBoxPage.openPage()
                .typeUserName(userName)
                .typeUserEmailIncorrect(userEmailIncorrect)
                .typeCurrentAddress(currentAddress)
                .typePermanentAddress(permanentAddress)
                .submitForm()

                .checkFieldInvisible();
    }
}


