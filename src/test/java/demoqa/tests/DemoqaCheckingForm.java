package demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.Month;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoqaCheckingForm {

    @BeforeAll
    static void beforeAll (){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void fillForm(){
        File picture = new File ("src/test/resources/picture.jpg");
        String firstName = "Naum";
        String lastName = "Ivanov";
        String email = "ivanov@yandex.ru";
        String gender = "Male";
        String number = "9001234567";
        String dateOfBirth = "03";
        int numberOfMonth = 10;
        String monthOfBirth = Month.of(numberOfMonth+1).name();
        String yearOfBirth = "1992";
        String letters = "M";
        String subject = "Maths";
        String hobby = "Music";
        String address = "Moscow, Sadovnicheskaya street 3";
        String state = "NCR";
        String city = "Delhi";

        // 1. Fill all areas at form
        //Open url
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        //Validate title
        $("div.main-header").shouldHave(text("Practice Form"));
        //Input First Name
        $("#firstName").setValue(firstName);
        //Input Last Name
        $("#lastName").setValue(lastName);
        // Input Email
        $("#userEmail").setValue(email);
        // Choose one gender (radio-button)
        $(byText(gender)).click();
        // Input Mobile Number
        $("#userNumber").setValue(number);
        // Choose Date of Birth
        $("#dateOfBirthInput").click();
        $("select.react-datepicker__month-select").selectOptionByValue(String.valueOf(numberOfMonth));
        $("select.react-datepicker__year-select").selectOptionByValue(yearOfBirth);
        $("div.react-datepicker__day--0" + dateOfBirth).click();
        // Input Subjects
        $("#subjectsInput").setValue(letters);
        $(byText(subject)).click();
        // Choose Hobbies (one, two or all)
        $(byText(hobby)).click();
        // Upload Picture
        $("#uploadPicture").uploadFile(picture);
        // Input Current Address
        $("#currentAddress").setValue(address);
        // Select State and City
        $(".css-1wa3eu0-placeholder").click();
        $(byText(state)).click();
        $("#city").click();
        $(byText(city)).click();
        // Press button "Submit"
        $("#submit").click();

        //2. Check that output data equals input data
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        $("tbody").shouldHave(text(firstName + " " + lastName));
        $("tbody").shouldHave(text(email));
        $("tbody").shouldHave(text(gender));
        $("tbody").shouldHave(text(number));
        $("tbody").shouldHave(text(dateOfBirth + " " + monthOfBirth + "," + yearOfBirth));
        $("tbody").shouldHave(text(subject));
        $("tbody").shouldHave(text(hobby));
        $("tbody").shouldHave(text(address));
        $("tbody").shouldHave(text(state + " " + city));
    }
}
