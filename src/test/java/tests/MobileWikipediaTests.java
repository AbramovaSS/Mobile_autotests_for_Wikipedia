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

    @DisplayName("Вызов голосового поиска")
    @Test
    void successfulVoiceSearchTest() {
        searchScreenPage.skipStartScreen()
                .voiceSearchInput()
                .displayPopAp();
    }
}
