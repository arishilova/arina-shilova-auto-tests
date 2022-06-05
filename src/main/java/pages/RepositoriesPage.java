package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class RepositoriesPage {

    public SelenideElement branchSelectMenu() {
        return $("#branch-select-menu").as("меню выбора ветки");
    }

    public SelenideElement selectMenuItemFixtures() {
        return $("[href='https://github.com/junit-team/junit4/tree/fixtures']").as("элемент выпадающего списка Fixtures");
    }

    public SelenideElement menuButtonText() {
        return $("summary span.css-truncate-target").as("надпись на кнопке меню выбора ветки");
    }

    public SelenideElement releasesLink() {
        return $(".BorderGrid-row:nth-child(2) h2 a").as("ссылка на релизы");
    }

}
