package homeWork4;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Main {

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.browserSize = "1920x1080";
    }

    static void removeAds() {
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
    }

    @Test
    void firstTest() {
        open("automation-practice-form");

        removeAds();

        $("#firstName").setValue("Homer");
        $("#lastName").setValue("Simpson");
        $("#userEmail").setValue("example@gmail.com");
        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue("9998887766");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__day--009").click();
        $("#subjectsInput").setValue("maths").pressEnter();
        $("[for='hobbies-checkbox-1']").click();
        $("#uploadPicture").scrollTo().uploadFile(new File("src/test/resources/ABC.webp"));
        $("#currentAddress").scrollTo().setValue("Kappa 123");
        $("#state").scrollTo().click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-body").shouldHave(text("Homer Simpson"));
        $(".modal-body").shouldHave(text("example@gmail.com"));
        $(".modal-body").shouldHave(text("Male"));
        $(".modal-body").shouldHave(text("9998887766"));
        $(".modal-body").shouldHave(text("09 August,2022"));
        $(".modal-body").shouldHave(text("Kappa 123"));
        $(".modal-body").shouldHave(text("Math"));
        $(".modal-body").shouldHave(text("Sports"));
        $(".modal-body").shouldHave(text("ABC.webp"));
        $(".modal-body").shouldHave(text("NCR Delhi"));
    }
}
