package homeWork12;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class Tests {

    public static final String URL = "https://github.com/Twinkerxd";
    public static final String PR_NAME = "Resolve me if you can";
    public static final String REPO_NAME = "QAguru";

    public static final String LOGIN = "user1";
    public static final String PASSWORD = "1234";

    public static final String envURl = System.getProperty("env_url");
    public static final String browserName = System.getProperty("browser_name", "chrome");
    public static final String browserVersion = System.getProperty("browser_version");
    public static final String browserSize = System.getProperty("browser_size", "1920x1080");

    @BeforeAll
    static void setUp() {
        // добавляет шаги в отчет + скрин и соурс при падении
        SelenideLogger.addListener("allure", new AllureSelenide());

        Configuration.browser = browserName;
        Configuration.browserSize = browserSize;

        if (envURl == null || envURl.equals("")) {
            // запуск локально
        } else {
            // запуск удалённо
            Configuration.remote = "https://"+LOGIN+":"+PASSWORD+"@" + envURl;
        }

        if (browserVersion != null) {
            Configuration.browserVersion = browserVersion;
        }

        // Добавление видео и т.д.
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;

        System.out.println("-----------------------------");
        System.out.println("-----------------------------");
        System.out.println("-----------------------------");
        System.out.println("Browser: " + browserName);
        System.out.println("Version: " + browserVersion);
        System.out.println("Size: " + browserSize);
        System.out.println("ENV: " + envURl);
        System.out.println("-----------------------------");
        System.out.println("-----------------------------");
        System.out.println("-----------------------------");
    }

    @Test
    @Tag("selenide_test")
    void selenideTest() {
        open(URL);

        $(linkText(REPO_NAME)).click();
        $("#pull-requests-tab").click();
        $(withText(PR_NAME)).should(exist);
    }

    @Test
    @Tag("run_me_if_you_can")
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
    @Tag("annotated_step_test")
    void annotatedStepTest() {
        Steps steps = new Steps();

        steps.openUrl(URL);
        steps.openRepoWithName(REPO_NAME);
        steps.goToPullRequests();
        steps.searchForPullRequestWithName(PR_NAME);
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();

        if (envURl == null || envURl.equals("")) {
            // locale
        } else {
            Attach.addVideo();
        }

    }
}
