package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class MobileWikipediaTests extends TestBase {

    @DisplayName("Поиск по валидному запросу и отображение списка результатов")
    @Test
    void successfulSearch() {
        searchScreenPage.skipStartScreen()
                .searchInput()
                .setKeyInput("Appium")
                .verifySearchResultsAreDisplayed();
    }

    @DisplayName("Переход на экран результата")
    @Test
    void successfulGoToResultScreen() {
        searchScreenPage.skipStartScreen()
                .searchInput()
                .setKeyInput("Appium")
                .tapFirstSearchResult()
                .verifyTitleSearchResult();
    }

    @DisplayName("Удаление запроса в строке поиска")
    @Test
    void deletingQuerySearch() {
        searchScreenPage.skipStartScreen()
                .searchInput()
                .setKeyInput("Appium")
                .tapSearchCloseBtn()
                .verifySearchSrcText();
    }

    @DisplayName("Добавление языка")
    @Test
    void successfulAddingLanguage() {
        settingsScreenPage.tapNavTabMore()
                .tapSettings()
                .tapWikiLanguages();
        languagesScreenPage.tapAddLanguagePlus()
                .tapAddLanguage()
                .verifyAddedLanguage();

    }
}
