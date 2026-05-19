package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.androidUIAutomator;
import static io.appium.java_client.AppiumBy.id;

public class SettingsScreenPage {

        private final SelenideElement navTabMore = $(id("org.wikipedia.alpha:id/nav_tab_more")),
                settings = $(id("org.wikipedia.alpha:id/main_drawer_settings_container")),
                wikiLanguages = $(androidUIAutomator("new UiSelector().text(\"Wikipedia languages\")"));


    @Step("Нажать на таб More в таббаре")
    public SettingsScreenPage tapNavTabMore() {
        navTabMore.click();
        return this;
    }

    @Step("Нажать на Settings в открывшемся боттомшите")
    public SettingsScreenPage tapSettings() {
        settings.click();
        return this;
    }

    @Step("Нажать на Wikipedia languages на экране настроек")
    public SettingsScreenPage tapWikiLanguages() {
        wikiLanguages.click();
        return this;
    }
}
