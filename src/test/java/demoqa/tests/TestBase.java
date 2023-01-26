package demoqa.tests;

import com.codeborne.selenide.Configuration;
import demoqa.pages.CheckingFormPage;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    TestData testData = new TestData();
    CheckingFormPage checkingFormPage = new CheckingFormPage();

    @BeforeAll
    static void beforeAll (){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }
}
