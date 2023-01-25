package demoqa.tests;

import org.junit.jupiter.api.Test;
import demoqa.pages.CheckingFormPage;

import java.io.File;
import java.time.Month;

public class CheckingFormWithPageObjects extends TestBase {
    CheckingFormPage checkingFormPage = new CheckingFormPage();
    @Test
    public void fillForm() {
        File picture = new File ("src/test/resources/picture.jpg");
        String firstName = "Naum";
        String lastName = "Ivanov";
        String email = "ivanov@yandex.ru";
        String gender = "Male";
        String number = "9001234567";
        String dateOfBirth = "03";
        int numberOfMonth = 10;
        String stringOfMonth = String.valueOf(numberOfMonth);
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
        checkingFormPage.openPage()
                //Validate title
                .validateTitle()
                .firstNameInput(firstName)
        //Input Last Name
                .lastNameInput(lastName)
        // Input Email
                .emailInput(email)
        // Choose one gender (radio-button)
                .chooseGender(gender)
        // Input Mobile Number
                .numberInput(number)
        // Choose Date of Birth
                .chooseDateOfBirth(dateOfBirth, stringOfMonth, yearOfBirth)
        // Input Subjects
                .subjectsInput(letters, subject)
        // Choose Hobbies (one, two or all)
                .chooseHobbies(hobby)
        // Upload Picture
                .uploadPicture(picture)
        // Input Current Address
                .addressInput(address)
        // Select State and City
                .selectStateAndCity(state, city)
        // Press button "Submit"
                .pressButton()

        //2. Check that output data equals input data
                .verifyResultsAppears()
                .checkAllOutputData(firstName + " " + lastName)
                .checkAllOutputData(email)
                .checkAllOutputData(gender)
                .checkAllOutputData(number)
                .checkAllOutputData(dateOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkAllOutputData(subject)
                .checkAllOutputData(hobby)
                .checkAllOutputData(address)
                .checkAllOutputData(state + " " + city);

    }
}

