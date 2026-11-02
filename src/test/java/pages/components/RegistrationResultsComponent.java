package pages.components;

import com.codeborne.selenide.SelenideElement;
import pages.RegistrationFormPage;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultsComponent {
    private SelenideElement outputResults = $(".table-responsive");


    public RegistrationResultsComponent checkTable (String key, String value){
        outputResults.$$("td").findBy(text(key)).sibling(0).shouldHave(text(value));

        return this;
    }
}
