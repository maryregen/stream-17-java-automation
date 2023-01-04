package github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class LoadingTheCorrectPage {
    @Test
    void loadingPageWithSpecificTitle() {
        //открыть github
        open("https://github.com");
        //выбрать меню Solutions (с помощью команды hover для Solutions)
        $("li button.HeaderMenu-link", 1).hover();
        //выбрать меню Solutions -> Enterprise
        $(byText("Enterprise")).click();
        //убедиться, что заголовок "Build like the best."
        $("h1").shouldHave(text("Build like the best"));
    }
}
