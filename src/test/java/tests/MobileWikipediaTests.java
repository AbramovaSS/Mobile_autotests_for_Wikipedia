package tests;

import org.junit.jupiter.api.Test;

public class MobileWikipediaTests extends TestBase {
    @Test
    void successfulSearchTest() {
        searchScreenPage.setSearchInput()
                .setKeyInput("Appium")
                .verifySearchResultsAreDisplayed();
    }
}
