package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    public SelenideElement mainSignInButton() {
        return $("[href='/login']").as("кнопка логина на главной странице");
    }

    public SelenideElement dropdownMenuButton() {
        return $("[aria-label='View profile and more']").as("кнопка открытия меню профиля");
    }

    public SelenideElement profileDropdownItem() {
        return $("[data-ga-click='Header, go to profile, text:your profile']").as("ссылка на профиль пользователя");
    }

}
