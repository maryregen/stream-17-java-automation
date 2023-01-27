package demoqa.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class GenerationDataForCheckingForm extends TestBase {
    @Tag("Jenkins")
    @Test
    public void fillForm() {
        // 1. Fill all areas at form
        //Open url
        checkingFormPage.openPage()
                //Validate title
                .validateTitle()
                .firstNameInput(testData.firstName)
        //Input Last Name
                .lastNameInput(testData.lastName)
        // Input Email
                .emailInput(testData.email)
        // Choose one gender (radio-button)
                .chooseGender(testData.gender)
        // Input Mobile Number
                .numberInput(testData.number)
        // Choose Date of Birth
                .chooseDateOfBirth(testData.dayOfBirth, testData.stringOfMonth, testData.yearOfBirth)
        // Input Subjects
                .subjectsInput(testData.subject)
        // Choose Hobbies (one, two or all)
                .chooseHobbies(testData.hobby)
        // Upload Picture
                .uploadPicture(testData.picture)
        // Input Current Address
                .addressInput(testData.address)
        // Select State and City
                .selectStateAndCity(testData.state, testData.city)
        // Press button "Submit"
                .pressButton()

        //2. Check that output data equals input data
                .verifyResultsAppears()
                .checkAllOutputData(testData.firstName + " " + testData.lastName)
                .checkAllOutputData(testData.email)
                .checkAllOutputData(testData.gender)
                .checkAllOutputData(testData.number)
                .checkAllOutputData(testData.dayOfBirth + " " + testData.monthOfBirth + "," + testData.yearOfBirth)
                .checkAllOutputData(testData.subject)
                .checkAllOutputData(testData.hobby)
                .checkAllOutputData(testData.address)
                .checkAllOutputData(testData.state + " " + testData.city);

    }
}

