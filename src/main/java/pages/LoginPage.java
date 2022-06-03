package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public SelenideElement loginField() {
        return $("#login_field").as("поле ввода логина");
    }

    public SelenideElement passwordField() {
        return $("#password").as("поле ввода пароля");
    }

    public SelenideElement signInButton() {
        return $(".js-sign-in-button").as("кнопка логина");
    }

}
