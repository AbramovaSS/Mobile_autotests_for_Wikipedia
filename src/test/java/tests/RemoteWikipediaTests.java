package tests;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Test;
import pages.MainScreenPage;
import pages.SearchScreenPage;
import pages.SettingsScreenPage;

import static data.TestData.SEARCH_QUERY;


public class RemoteWikipediaTests extends TestBase {

    SearchScreenPage searchScreenPage = new SearchScreenPage();
    SettingsScreenPage settingsScreenPage = new SettingsScreenPage();
    MainScreenPage mainScreenPage = new MainScreenPage();


    @DisplayName("Поиск по валидному запросу и отображение списка результатов")
    @Test
    void successfulSearch() {
        searchScreenPage.skipStartScreen()
                .searchInput()
                .setKeyInput("Appium")
                .verifySearchResultsAreDisplayed();
    }


    @DisplayName("Удаление запроса в строке поиска")
    @Test
    void deletingQuerySearch() {
        searchScreenPage.skipStartScreen()
                .searchInput()
                .setKeyInput(SEARCH_QUERY)
                .tapSearchCloseBtn()
                .verifySearchSrcText();
    }


    @DisplayName("Переход в настройки Wiki")
    @Test
    void goToSettingsScreen() {
        mainScreenPage.tapOkAlert()
                .tapNavMenuBtn();
        settingsScreenPage.tapSettings()
                .checkScreenSetting();
    }


    @DisplayName("Переход на экран результата")
    @Test
    void successfulGoToResultScreen() {
        searchScreenPage.skipStartScreen()
                .searchInput()
                .setKeyInput("Appium")
                .tapFirstSearchResult();
        mainScreenPage.tapOkAlert();
        searchScreenPage.verifyTitleSearchResult();
    }
}
