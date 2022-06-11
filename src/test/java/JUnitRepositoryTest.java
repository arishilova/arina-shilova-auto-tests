import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@Owner("a_sh")
@Feature("Репозитории")
public class JUnitRepositoryTest {

    @BeforeEach
    public void before() {
        open("https://github.com/junit-team/junit4");
    }

    @Test
    @Story("Переключение веток")
    @DisplayName("Переключение на ветку fixtures в репозитории junit-team/junit4")
    public void shouldOpenFixturesBranchTest() {

        step("Нажать на меню переключения веток и выбрать ветку fixtures в выпадающем списке", () -> {
            TestPages.repositoriesPage.branchSelectMenu()
                    .click();
            TestPages.repositoriesPage.selectMenuItemFixtures()
                    .click();
        });

        step("Проверить, что произошел переход на ветку fixtures", () -> {
            TestPages.repositoriesPage.menuButtonText()
                    .shouldHave(Condition.text("fixtures"));
        });
    }

    @MethodSource("searchValue")
    @ParameterizedTest(name = "{displayName} {0}")
    @Story("Поиск по релизам")
    @DisplayName("Позитивные проверки поиска по релизам в репозитории junit-team/junit4")

    public void shouldSearchReleaseTest(String type, String value, String result) {

        step("Кликнуть по ссылке на страницу с релизами", () -> {
            TestPages.repositoriesPage.releasesLink()
                    .click();
        });

        step("Ввести необходимое значение в инпут поиска по релизам и нажать ENTER", () -> {
            TestPages.releasesPage.releasesSearchInput()
                .setValue(value).pressEnter();
        });

        step("Проверить, что в поисковой выдаче отображается введенное в инпут поиска значение", () -> {
            TestPages.releasesPage.releasesBox()
                    .shouldHave(Condition.text(result));
        });
    }

    static Stream<Arguments> searchValue() {
        return Stream.of(
                arguments(
                        "по номеру",
                        "4.13.2",
                        "4.13.2"
                ),
                arguments(
                        "по буквам в названии",
                        "RC 2",
                        "RC 2"
                ),
                arguments(
                        "по полному названию",
                        "JUnit 4.13 RC 2",
                        "JUnit 4.13 RC 2"
                )
        );
    }

}
