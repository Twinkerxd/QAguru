package homework8;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://www.dns-shop.ru/";
        Configuration.browserSize = "1920x1080";
    }
}
