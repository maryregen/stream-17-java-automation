package github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class SelenideRepositorySearch {
    @Test
    void shouldFindSelenideRepositoryAtTheTop() {
        //открыть страницу
        open("https://www.github.com/");
        //вввести в поле поиска
        $("[data-scoped-placeholder=Search]").setValue("selenide").pressEnter();
        //кликнуть на первый репозиторий из списка найденных
        $$("ul.repo-list li").first().$("a").click();
        //проверить заголовок selenide/selenide
        $("#repository-container-header").shouldHave(text("selenide / selenide"));
    }
}
