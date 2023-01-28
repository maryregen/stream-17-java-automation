package github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SoftAssertionsHaveJUnit5 {
    @Test
    void softAssertionsHaveCodeJUnit5() {
        //открыть страницу Selenide в Github
        open("https://www.github.com/selenide/selenide");
        //перейти в раздел Wiki проекта
        $("#wiki-tab").click();
        //убедиться, что в списке страниц pages есть страница SoftAssertions, открыть страницу SoftAssertions
        $("#wiki-body li a[href='/selenide/selenide/wiki/SoftAssertions']").click();
        //проверить, что внутри есть пример кода для JUnit5
        $("#user-content-3-using-junit5-extend-test-class").parent().shouldHave(text("3. Using JUnit5 extend test class:"));
    }
}
