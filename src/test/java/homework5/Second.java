package homework5;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Second {
    @Test
    void checkComparePlansPageTitle() {
        open("https://github.com/");

        $$("summary").last().hover();
        $(".HeaderMenu").$(byText("Compare plans")).click();
        $("h1").shouldHave(text("Choose the plan that’s right for you."));
    }

    @Test
    void dragAndDropElement() {
        open("https://the-internet.herokuapp.com/drag_and_drop");

        $("header").shouldHave(text("A"));
        $("#column-a").dragAndDropTo($("#column-b"));
        $("header").shouldHave(text("B"));
    }
}
