package github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SoftAssertionsHaveJUnit5 {
    @Test
    void softAssertionsHaveCodeJUnit5(){
        //открыть страницу Selenide в Github
        open("https://www.github.com/selenide/selenide");
        //перейти в раздел Wiki проекта
        $("#wiki-tab").click();
        //убедиться, что в списке страниц pages есть страница SoftAssertions, открыть страницу SoftAssertions
        $("li a[href='/selenide/selenide/wiki/SoftAssertions']:not(a.flex-1)").click();
        //проверить, что внутри есть пример кода для JUnit5
        $("#user-content-3-using-junit5-extend-test-class").parent().shouldHave(text("3. Using JUnit5 extend test class:"));
    }
}
