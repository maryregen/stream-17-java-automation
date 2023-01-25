package github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class CheckIssueName {

    public static final String REPOSITORY = "eroshenkoam/allure-example";
    public static final String ISSUE_NAME = "issue_to_test_allure_report";
    @Test
    @Story("Проверка названия задачи на github")
    @DisplayName("Тест на проверку задачи с использованием Listener")
    public void testCheckIssueNameUsingListener (){
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com");
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(REPOSITORY);
        $(".header-search-input").submit();
        $(linkText(REPOSITORY)).click();
        $("#issues-tab").click();
        $(withText(ISSUE_NAME)).should(Condition.exist);
    }

    @Test
    @Story("Проверка названия задачи на github")
    @DisplayName("Тест на проверку задачи с использованием step")
    public void testCheckIssueNameUsingSteps(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открыть главную страницу", () -> {
            open("https://github.com");
        });
        step("Найти репозиторий " + REPOSITORY + " и перейти в него", () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
            $(linkText(REPOSITORY)).click();
            $("#issues-tab").click();
        });

        step("Проверить название задачи " + ISSUE_NAME + " в репозитории " + REPOSITORY, () -> {
            $(withText(ISSUE_NAME)).should(Condition.exist);
        });
    }

    @Test
    @Story("Проверка названия задачи на github")
    @DisplayName("Тест на проверку задачи с использованием аннотации Step")
    public void testCheckIssueNameUsingAnnotatedSteps(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        AnnotatedSteps steps = new AnnotatedSteps();
        steps.openMainPage();
        steps.findRepositoryAndClick(REPOSITORY);
        steps.checkIssueName(ISSUE_NAME);
    }
}
