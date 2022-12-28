package github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class BestContributorToSelenide {
    @Test
    void solntsevShouldBeTheTopContributor(){
        //открыть страницу репозитория selenide
        open("https://www.github.com/selenide/selenide");
        // подвести мышку к первому аватару из блока contributors
        $(".BorderGrid").$(Selectors.byText("Contributors")).ancestor(".BorderGrid-row")
                .$$("ul li").first().hover();
        //убедиться, что есть текст Andrei Solntsev
        $$(".Popover .Popover-message").findBy(Condition.visible).shouldHave(Condition.text("Andrei Solntsev"));
    }
}
