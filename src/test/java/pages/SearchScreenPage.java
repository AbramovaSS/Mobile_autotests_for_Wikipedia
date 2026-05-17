package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;

public class SearchScreenPage {
    private final SelenideElement searchInput = $(accessibilityId("Search Wikipedia")),
            keyInput = $(id("org.wikipedia.alpha:id/search_src_text")),
            voiceSearchInput = $(id("org.wikipedia.alpha:id/voice_search_button")),
            popAp = $(id("com.google.android.googlequicksearchbox:id/intent_api_text"));
    private final ElementsCollection searchResults = $$(id("org.wikipedia.alpha:id/page_list_item_title"));


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

    @Step("Нажать на микрофон (голосовой поиск) в строке поиска")
    public SearchScreenPage voiceSearchInput() {
        voiceSearchInput.click();
        return this;
    }

    @Step("Убедиться, что открывается диалоговое окно с голосовым поиском")
    public SearchScreenPage displayPopAp() {
        popAp.shouldBe(visible);
        return this;
    }
}

