package homeWork5;

import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class Main {
    @Test
    void test() {
        open("https://github.com/");
        $("input[name='q']").setValue("Selenide").pressEnter();
        $("a[href='/search?q=Selenide&type=wikis']").click();
        $("a[title='SoftAssertions']").exists();
        $("a[title='SoftAssertions']").click();
        $$("ol li").shouldHave(CollectionCondition.itemWithText("Using JUnit5 extend test class:"));
    }
}
