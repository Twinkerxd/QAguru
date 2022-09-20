package homework4;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Main {

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.browserSize = "1920x1080";
        //Configuration.holdBrowserOpen = true;
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

        $(".modal-body").shouldHave(
                text("Homer Simpson"),
                text("example@gmail.com"),
                text("Male"),
                text("9998887766"),
                text("09 August,2022"),
                text("Kappa 123"),
                text("Sports"),
                text("ABC.webp"),
                text("NCR Delhi"));
    }
}
