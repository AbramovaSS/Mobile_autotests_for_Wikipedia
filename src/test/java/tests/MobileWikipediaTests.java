package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class MobileWikipediaTests extends TestBase {

    @DisplayName("Поиск по валидному запросу и отображение списка результатов")
    @Test
    void successfulSearchTest() {
        searchScreenPage.skipStartScreen()
                .searchInput()
                .setKeyInput("Appium")
                .verifySearchResultsAreDisplayed();
    }

    @DisplayName("Добавление языка поиска")
    @Test
    void successfulAddLanguageTest() {
        searchScreenPage.skipStartScreen()
                .searchInput()
                .tapLangSearchButton()
                .tapAddLanguage()
                .tapLanguageElement()
                .verifyLanguageDisplayed();
    }

    @DisplayName("Удаление языка")
    @Test
    void successfulDeletionLanguageTest() {
        searchScreenPage.skipStartScreen()
                .searchInput()
                .tapLangSearchButton()
                .tapAddLanguage()
                .tapLanguageElement()
                .tapKebabMenu()
                .removeLanguage()
                .languageCheckbox()
                .deleteSelectedItems()
                .deleteOk()
                .verifyOneResult();
    }
}
