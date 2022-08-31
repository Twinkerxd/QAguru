package homeWork10;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class Tests {

    /**
     * Написать тест на проверку названия Issue в репозитории через Web-интерфейс.
     * Этот тест представить в трех вариантах:
     * 1. Чистый Selenide (с Listener)
     * 2. Лямбда шаги через step (name, () -> {})
     * 3. Шаги с аннотацией @Step
     * В качестве ответа на задание приложите ссылку на свой репозиторий GitHub в поле ответа
     */

    public static final String URL = "https://github.com/Twinkerxd";
    public static final String PR_NAME = "Resolve me if you can";
    public static final String REPO_NAME = "QAguru";

    @BeforeAll
    static void setUp() {
        // добавляет шаги в отчет + скрин и соурс при падении
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @Test
    void selenideTest() {
        open(URL);

        $(linkText(REPO_NAME)).click();
        $("#pull-requests-tab").click();
        $(withText(PR_NAME)).should(exist);
    }

    @Test
    void lambdaTest() {
        step("Открываем URL: " + URL, () -> {
            open(URL);
        });
        step("Переходим в репозиторий \"" + REPO_NAME +"\"", () -> {
            $(linkText(REPO_NAME)).click();
        });
        step("Переходим в пулреквесты", () -> {
            $("#pull-requests-tab").click();
        });
        step("Ищем пулреквест \"" + PR_NAME + "\" на странице", () -> {
            $(withText(PR_NAME)).should(exist);
        });
    }

    @Test
    void annotatedStepTest() {
        Steps steps = new Steps();

        steps.openUrl(URL);
        steps.openRepoWithName(REPO_NAME);
        steps.goToPullRequests();
        steps.searchForPullRequestWithName(PR_NAME);
    }
}
