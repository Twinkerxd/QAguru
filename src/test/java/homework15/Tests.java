package homework15;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import homework12.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class Tests {

    public static final String URL = "https://github.com/Twinkerxd";

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
    @Tag("xxx")
    void first() {
        open("https://youtu.be/dQw4w9WgXcQ");
        $x("//*[contains(text(),'#NeverGonnaGiveYouUp') and @href='/hashtag/nevergonnagiveyouup']").should(exist);
    }

    @AfterEach
    void addAttachments() {
        homework12.Attach.screenshotAs("Last screenshot");
        homework12.Attach.pageSource();
        homework12.Attach.browserConsoleLogs();

        if (envURl == null || envURl.equals("")) {
            // locale
        } else {
            Attach.addVideo();
        }
    }
}
