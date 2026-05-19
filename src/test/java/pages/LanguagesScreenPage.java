package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.androidUIAutomator;

public class LanguagesScreenPage {

    private final SelenideElement addLanguagePlus = $(androidUIAutomator("new UiSelector().text(\"Add language\")")),
            addLanguage = $(androidUIAutomator("new UiSelector().text(\"Русский\")"));

    @Step("Нажать на таб More в таббаре")
    public LanguagesScreenPage tapAddLanguagePlus() {
        addLanguagePlus.click();
        return this;
    }

    @Step("Выбрать язык")
    public LanguagesScreenPage tapAddLanguage() {
        addLanguage.click();
        return this;
    }

    @Step("Проверить, что есть добавленный язык")
    public LanguagesScreenPage verifyAddedLanguage() {
        addLanguage.shouldHave(text("Русский"));
        return this;
    }
}
