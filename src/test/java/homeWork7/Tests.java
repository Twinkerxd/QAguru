package homeWork7;

import org.junit.jupiter.api.Test;

import static homeWork7.RandomDataGenerator.*;
import static homeWork7.RegistrationFormPage.City.Jaipur;
import static homeWork7.RegistrationFormPage.Months.June;
import static homeWork7.RegistrationFormPage.State.Rajasthan;
import static homeWork7.RegistrationFormPage.Subject.*;

public class Tests extends BaseTest {

    private final String FIRST_NAME = randomFirstName();
    private final String LAST_NAME = randomLastName();
    private final String EMAIL = randomEmail();
    private final String MOBILE_PHONE = randomMobilePhone(9);
    private final String ADDRESS = randomAddress();
    private final String FILE_NAME = "ABC.webp";

    @Test
    void RegistrationForm() {
        new RegistrationFormPage()
                .openPage()
                .removeAds()
                .setFirstName(FIRST_NAME)
                .setLastName(LAST_NAME)
                .setUserEmail(EMAIL)
                .setRandomGender()
                .setMobileNumber(MOBILE_PHONE)
                .setDateOfBirth(24, June, 1992)
                .setSubjects(Maths)
                .setSubjects(Arts)
                .setRandomHobbies()
                .uploadFile("src/test/resources/" + FILE_NAME)
                .setCurrentAddress(ADDRESS)
                .setState(Rajasthan)
                .setCity(Jaipur)
                .clickSubmitButton()

                .checkSubmittedData("Student Name", FIRST_NAME + " " + LAST_NAME)
                .checkSubmittedData("Student Email", EMAIL)
                .checkSubmittedData("Mobile", MOBILE_PHONE)
                .checkSubmittedData("Date of Birth", "24 June,1992")
                .checkSubmittedData("Subjects", Maths + ", " + Arts)
                .checkSubmittedData("Picture", FILE_NAME)
                .checkSubmittedData("Address", ADDRESS)
                .checkSubmittedData("State and City", Rajasthan + " " + Jaipur);
    }
}
