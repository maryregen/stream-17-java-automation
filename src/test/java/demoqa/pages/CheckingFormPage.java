package demoqa.pages;

import demoqa.components.CalendarComponent;
import demoqa.components.RegistrationResultsModal;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class CheckingFormPage {
    private String title = "Practice Form";
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    public CheckingFormPage openPage()
    {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }
    public CheckingFormPage validateTitle()
    {
        $("div.main-header").shouldHave(text(title));

        return this;
    }
    public CheckingFormPage firstNameInput(String value)
    {
        $("#firstName").setValue(value);

        return this;
    }
    public CheckingFormPage lastNameInput(String value)
    {
        $("#lastName").setValue(value);

        return this;
    }
    public CheckingFormPage emailInput(String value)
    {
        $("#userEmail").setValue(value);

        return this;
    }
    public CheckingFormPage chooseGender(String value)
    {
        $(byText(value)).click();

        return this;
    }
    public CheckingFormPage numberInput(String value)
    {
        $("#userNumber").setValue(value);

        return this;
    }
    public CheckingFormPage chooseDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.chooseDateOfBirth(day, month, year);
        return this;
    }

    public CheckingFormPage subjectsInput(String subject)
    {
        $("#subjectsInput").setValue(subject).pressEnter();
        return this;
    }
    public CheckingFormPage chooseHobbies(String value)
    {
        $(byText(value)).click();

        return this;
    }
    public CheckingFormPage uploadPicture(File picture)
    {
        $("#uploadPicture").uploadFile(picture);

        return this;
    }
    public CheckingFormPage addressInput(String value)
    {
        $("#currentAddress").setValue(value);

        return this;
    }
    public CheckingFormPage selectStateAndCity(String state, String city)
    {
        $(".css-1wa3eu0-placeholder").click();
        $(byText(state)).click();
        $("#city").click();
        $(byText(city)).click();

        return this;
    }
    public CheckingFormPage pressButton()
    {
        $("#submit").click();

        return this;
    }

    public CheckingFormPage verifyResultsAppears()
    {
        registrationResultsModal.verifyResultsAppears();

        return this;
    }
    public CheckingFormPage checkAllOutputData(String value)
    {
        registrationResultsModal.checkAllOutputData(value);

        return this;
    }
}
