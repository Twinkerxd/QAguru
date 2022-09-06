package homeWork12;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * Сделать параметризированную сборку в дженкинс:
 * 1. Настроить выбор параметров для запуска из jenkins - браузер, версия, размер экрана, удаленный браузер
 * 2. Соответственно доработать код на прием значений извне (из терминала).
 * 3. Добавить условие в TestBase - если адрес удаленного браузера не передан, то тесты должны запускаться локально
 */

@Tag("all")
public class delete {

    @Test
    @Tag("AAA")
    void firstTest() {
        String browserName = System.getProperty("browser_name", "chrome");
        String browserVersion = System.getProperty("browser_version", "99");
        String browserSize = System.getProperty("browser_size", "1920x1080");

        System.out.println("--- firstTest starts ---");
        System.out.println(browserName);
        System.out.println(browserVersion);
        System.out.println(browserSize);
        System.out.println("--- firstTest ends---");

        //gradle clean one -Dbrowser_name="firefox" -Dbrowser_version="100" -Dbrowser_size="mobile"
    }

    @Test
    @Tag("BBB")
    void secondTest() {
        System.out.println("--- secondTest ---");
        System.out.println("--- secondTest ---");
        System.out.println("--- secondTest ---");
    }
}
