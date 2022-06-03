package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ProfilePage {
    public SelenideElement calendarGraphImg() {
        return $(".js-calendar-graph-svg").as("график участия в проектах");
    }

}
