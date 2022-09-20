package homework6;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static homework6.RegistrationFormPage.City.Jaipur;
import static homework6.RegistrationFormPage.Months.June;
import static homework6.RegistrationFormPage.State.Rajasthan;

public class Tests {

    private final String FIRST_NAME = "Homer";
    private final String LAST_NAME = "Simpson";
    private final String EMAIL = "example@gmail.com";
    private final String MOBILE_PHONE = "9994443311";
    private final String ADDRESS = "Mars 1st street";
    private final String FILE_NAME = "ABC.webp";
    private final String MATH_SUBJECT = "Maths";
    private final String ARTS_SUBJECT = "Arts";

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void firstTest() {
        new RegistrationFormPage()
                .openPage()
                .removeAds()
                .setFirstName(FIRST_NAME)
                .setLastName(LAST_NAME)
                .setUserEmail(EMAIL)
                .setRandomGender()
                .setMobileNumber(MOBILE_PHONE)
                .setDateOfBirth(24, June,1992)
                .setSubjects(MATH_SUBJECT)
                .setSubjects(ARTS_SUBJECT)
                .setRandomHobbies()
                .uploadFile("src/test/resources/" + FILE_NAME)
                .setCurrentAddress(ADDRESS)
                .setState(Rajasthan)
                .setCity(Jaipur)
                .clickSubmitButton()

                .checkSubmittedData("Student Name", FIRST_NAME +" "+ LAST_NAME)
                .checkSubmittedData("Student Email", EMAIL)
                .checkSubmittedData("Mobile", MOBILE_PHONE)
                .checkSubmittedData("Date of Birth", "24 June,1992")
                .checkSubmittedData("Subjects", MATH_SUBJECT+", "+ARTS_SUBJECT)
                .checkSubmittedData("Picture", FILE_NAME)
                .checkSubmittedData("Address", ADDRESS)
                .checkSubmittedData("State and City", Rajasthan +" "+ Jaipur);
    }
}
