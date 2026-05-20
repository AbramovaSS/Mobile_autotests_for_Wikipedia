package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static data.TestData.PLACEHOLDER;
import static data.TestData.SEARCH_QUERY;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;

public class SearchScreenPage {
    private final SelenideElement searchInput = $(accessibilityId("Search Wikipedia")),
            keyInput = $(id("org.wikipedia.alpha:id/search_src_text")),
            searchResultTitle = $(byXpath("(//android.widget.TextView[@text=\"Appium\"])[1]")),
            searchCloseBtn = $(id("org.wikipedia.alpha:id/search_close_btn")),
            searchSrcText = $(id("org.wikipedia.alpha:id/search_src_text"));

    private final ElementsCollection searchResults = $$(id("org.wikipedia.alpha:id/page_list_item_title")),
            firstSearchResult = $$(byClassName("android.view.View"));

    @Step("Скрыть стартовый экран")
    public SearchScreenPage skipStartScreen() {
        back();
        return this;
    }

    @Step("Нажать на строку поиска")
    public SearchScreenPage searchInput() {
        searchInput.click();
        return this;
    }

    @Step("Ввести в строку поиска \"{value}\"")
    public SearchScreenPage setKeyInput(String value) {
        keyInput.sendKeys(value);
        return this;
    }

    @Step("Убедиться, что отображаются результаты поиска")
    public void verifySearchResultsAreDisplayed() {
        searchResults.shouldHave(sizeGreaterThan(0));

    }

    @Step("Нажать на первый результат поиска в списке")
    public SearchScreenPage tapFirstSearchResult() {
        firstSearchResult.first().click();
        return this;
    }

    @Step("Проверить, что заголовок экрана соотвествует поисковому результату")
    public SearchScreenPage verifyTitleSearchResult() {
        searchResultTitle.shouldHave(text(SEARCH_QUERY));
        return this;
    }

    @Step("Нажать на крестик в строке поиска")
    public SearchScreenPage tapSearchCloseBtn() {
        searchCloseBtn.click();
        return this;
    }

    @Step("Проверить, что в строке поиска отображается плейсхолдер")
    public SearchScreenPage verifySearchSrcText() {
        searchSrcText.shouldHave(text(PLACEHOLDER));
        return this;
    }

}

