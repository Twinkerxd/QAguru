package homework5;

import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class Main {
    @Test
    void test() {
        open("https://github.com/");

        $("input[name='q']").setValue("Selenide").pressEnter();
        $("a[href='/selenide/selenide']").click();
        $("#wiki-tab").click();
        $x("//li/button").click();
        $("a[href='/selenide/selenide/wiki/SoftAssertions']").exists();
        $("a[href='/selenide/selenide/wiki/SoftAssertions']").click();
        $$("h4").shouldHave(CollectionCondition.
                itemWithText("3. Using JUnit5 extend test class:"));
    }
}
