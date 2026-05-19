package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;

public class SearchScreenPage {
    private final SelenideElement searchInput = $(accessibilityId("Search Wikipedia")),
            keyInput = $(id("org.wikipedia.alpha:id/search_src_text")),
            langSearchInput = $(id("org.wikipedia.alpha:id/search_lang_button")),
            addLanguage = $(byXpath("//android.widget.TextView[@text='Add language']")),
            languageElement = $(byXpath("//android.widget.TextView[@text='Русский']")),
            russianLanguageElement = $(byXpath("//android.widget.TextView[@resource-id='org.wikipedia.alpha:id/wiki_language_title' and @text='Русский']")),
            kebabMenuButton = $(accessibilityId("More options")),
            removeLanguageButton = $(id("org.wikipedia.alpha:id/title")),
            secondLanguageCheckbox = $(byXpath("(//android.widget.CheckBox[@resource-id='org.wikipedia.alpha:id/wiki_language_checkbox'])[2]")),
            deleteSelectedItemsButton = $(id("org.wikipedia.alpha:id/title")),
            deleteOkButton = $(id("android:id/button1"));



    private final ElementsCollection searchResults = $$(id("org.wikipedia.alpha:id/page_list_item_title")),
            langResult = $$(id("org.wikipedia.alpha:id/wikipedia_languages_recycler"));

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

    @Step("Нажать на кнопку добавления языка в строке поиска")
    public SearchScreenPage tapLangSearchButton() {
        langSearchInput.click();
        return this;
    }

    @Step("Нажать на кнопку \"+ Add language\"")
    public SearchScreenPage tapAddLanguage() {
        addLanguage.click();
        return this;
    }

    @Step("Нажать на \"Русский\"")
    public SearchScreenPage tapLanguageElement() {
        languageElement.shouldBe(Condition.visible).click();
        return this;
    }

    @Step("Убедиться, что русский язык добавлен")
    public void verifyLanguageDisplayed() {
        russianLanguageElement.shouldBe(visible);
    }

    @Step("Нажать на кебаб-меню на экране Wikipedia languages")
    public SearchScreenPage tapKebabMenu() {
        kebabMenuButton.click();
        return this;
    }

    @Step("Нажать на кнопку Remove language")
    public SearchScreenPage removeLanguage() {
        removeLanguageButton.click();
        return this;
    }

    @Step("Отметить чек-бокс, например \"Русский\"")
    public SearchScreenPage languageCheckbox() {
        secondLanguageCheckbox.click();
        return this;
    }

    @Step("Нажать на иконку корзины на экране Remove language")
    public SearchScreenPage deleteSelectedItems() {
        deleteSelectedItemsButton.click();
        return this;
    }

    @Step("Нажать на иконку OK в диалоговом окне Remove selected language?")
    public SearchScreenPage deleteOk() {
        deleteOkButton.click();
        return this;
    }

    @Step("Убедиться, что на экране Wikipedia languages отображается только один язык")
    public void verifyOneResult() {
        langResult.shouldHave(size(1));
    }

}

