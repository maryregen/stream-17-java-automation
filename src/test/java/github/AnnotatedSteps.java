package github;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class AnnotatedSteps {

    @Step("Открыть главную страницу")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Найти репозиторий {repo}  и перейти в него")
    public void findRepositoryAndClick(String repo) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repo);
        $(".header-search-input").submit();
        $(linkText(repo)).click();
        $("#issues-tab").click();
    }

    @Step("Проверить название задачи {issue}")
    public void checkIssueName(String issue) {
        $(withText(issue)).should(Condition.exist);
    }
}
