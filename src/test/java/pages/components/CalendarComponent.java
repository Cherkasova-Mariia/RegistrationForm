package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    private SelenideElement monthSelect = $(".react-datepicker__month-select");
    private SelenideElement yearSelect = $(".react-datepicker__year-select");
    private SelenideElement daySelect = $("[role = table]");


    public void setDate(String day, String month, String year) {

        monthSelect.selectOption(month);
        yearSelect.selectOption(year);
        daySelect.find(byText(day)).click();
    }
}

