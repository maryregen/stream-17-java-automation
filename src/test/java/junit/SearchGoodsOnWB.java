package junit;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import junit.data.Currency;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SearchGoodsOnWB {

    @BeforeEach
    void beforeEach(){
        open ("https://www.wildberries.ru");
    }

    @CsvSource({
            "корм для кошек, 47 377",
            "корм для собак, 39 921"
    })

    @Tags({@Tag("Blocker"), @Tag("UI_TEST")})
    @ParameterizedTest (name = "По запросу {0} на сайте WB нашлось {1} товаров")
    void searchGoodsOnWB(String goods, String amount) {
        $("#searchInput").setValue(goods).pressEnter();
        $("h1.searching-results__title").shouldBe(visible, Duration.ofSeconds(10)).shouldHave(Condition.text("По запросу «" + goods + "» найдено"));
        $("span[data-link=\"html{spaceFormatted:pagerModel.totalItems}\"]").shouldHave(Condition.text(amount));
    }

    // Базовый скелет для MethodSource
    static Stream<Arguments> costDependsOnCurrentСurrency(){
        return Stream.of(
                Arguments.of(junit.data.Currency.RUB, "Российский рубль"),
                Arguments.of(junit.data.Currency.BYN,  "Белорусский рубль"),
                Arguments.of(junit.data.Currency.KZT,  "Казахстанский тенге"),
                Arguments.of(junit.data.Currency.AMD,  "Армянский драм"),
                Arguments.of(junit.data.Currency.KGS,  "Киргизский сом"),
                Arguments.of(junit.data.Currency.UZS,  "Узбекский сум")
        );
    }
    @MethodSource("costDependsOnCurrentСurrency")
    @Tags({@Tag("Blocker"), @Tag("UI_TEST")})
    @ParameterizedTest (name = "Валюта {0} на сайте WB это {1}")
    void costDependsOnСurrency(Currency currency, String description){
        $(".simple-menu__link--country").hover();
        $("div.j-b-change-currency")
                .$$(".radio-with-text__text")
                .filterBy(Condition.text(currency.name()))
                .first()
                .shouldHave(Condition.text(description));
    }

}
