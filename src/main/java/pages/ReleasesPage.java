package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ReleasesPage {

    public SelenideElement releasesSearchInput() {
        return $(".subnav-search-input").as("инпут поиска по релизам");
    }
/*    public SelenideElement releaseLink4132() {
        return $("[href='/junit-team/junit4/releases/tag/r4.13.2']").as("релиз JUnit 4.13.2");
    }

    public SelenideElement releaseLinkRC2() {
        return $("[href='/junit-team/junit4/releases/tag/r4.13-rc-2']").as("релиз JUnit 4.13 RC 2");
    }

    public SelenideElement dateBox() {
        return $("[title='1 дек. 2019 г., 14:08 GMT+3']").as("блок с датой");
    }*/

    public SelenideElement releasesBox() {
        return $(".Box-body").as("блок карточки релиза");
    }


}
