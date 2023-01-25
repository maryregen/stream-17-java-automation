package demoqa.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void chooseDateOfBirth(String day, String month, String year) {
        $("select.react-datepicker__month-select").selectOptionByValue(month);
        $("select.react-datepicker__year-select").selectOptionByValue(year);
        $("div.react-datepicker__day--0" + day).click();
    }
}
