import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class JUnitRepositoryTest {

    @BeforeEach
    public void before() {
        open("https://github.com/junit-team/junit4");
    }

    @Test
    @DisplayName("Переключение на ветку fixtures в репозитории junit-team/junit4")
    public void shouldOpenFixturesBranchTest() {

        TestPages.repositoriesPage.branchSelectMenu()
                .click();
        TestPages.repositoriesPage.selectMenuItemFixtures()
                .click();
        TestPages.repositoriesPage.menuButtonText()
                .shouldHave(Condition.text("fixtures"));

    }

    @MethodSource("searchValue")
    @ParameterizedTest(name = "{displayName} {0}")
    @DisplayName("Позитивные проверки поиска по релизам в репозитории junit-team/junit4")
    public void shouldSearchReleaseTest(String type, String value, String result) {

        TestPages.repositoriesPage.releasesLink()
                .click();
        TestPages.releasesPage.releasesSearchInput()
                .setValue(value).pressEnter();
        TestPages.releasesPage.releasesBox()
                .shouldHave(Condition.text(result));

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
