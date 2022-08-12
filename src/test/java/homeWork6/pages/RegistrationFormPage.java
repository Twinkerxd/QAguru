package homeWork6.pages;

import com.codeborne.selenide.SelenideElement;

import java.io.File;
import java.util.Random;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            mobileNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            monthSelect = $(".react-datepicker__month-select"),
            yearSelect = $(".react-datepicker__year-select"),
            subjectsInput = $("#subjectsInput"),
            uploadPictureButton = $("#uploadPicture"),
            currentAddressTextarea = $("#currentAddress"),
            stateSelector = $("#state"),
            citySelector = $("#city"),
            submitButton = $("#submit");


    public RegistrationFormPage openPage() {
        open("automation-practice-form");
        return this;
    }

    public RegistrationFormPage removeAds() {
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setMobileNumber(String value) {
        mobileNumberInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setCurrentAddress(String value) {
        currentAddressTextarea.setValue(value);
        return this;
    }

    public RegistrationFormPage setRandomGender() {
        Random random = new Random();
        int randomValue = random.nextInt(Gender.values().length) + 1;
        genderWrapper.$("label[for='gender-radio-"+randomValue+"']").click();
        return this;
    }

    public RegistrationFormPage setRandomHobbies() {
        Random random = new Random();
        int randomValue = random.nextInt(Hobbies.values().length) + 1;
        $("label[for='hobbies-checkbox-"+randomValue+"']").click();
        return this;
    }

    public RegistrationFormPage setDateOfBirth(int day, Months month, int year) {
        dateOfBirthInput.click();
        monthSelect.selectOption(String.valueOf(month));
        yearSelect.selectOption(String.valueOf(year));
        $(".react-datepicker__day--0"+day+":not(.react-datepicker__day--outside-month)").click();
        return this;
    }

    public RegistrationFormPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationFormPage uploadFile(String path) {
        uploadPictureButton.scrollTo().uploadFile(new File(path));
        return this;
    }

    public RegistrationFormPage setState(State state) {
        stateSelector.click();
        $(byText(String.valueOf(state))).click();
        return this;
    }

    public RegistrationFormPage setCity(City city) {
        citySelector.click();
        $(byText(String.valueOf(city))).click();
        return this;
    }

    public RegistrationFormPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    public RegistrationFormPage checkSubmittedData(String fieldName, String expectedValue) {
        $(".table-responsive table").$(byText(fieldName))
                .parent().shouldHave(text(expectedValue));
        return this;
    }

    public enum Gender {
        MALE, FEMALE, OTHER
    }

    public enum Months {
        January, February, March, April, May, June, July, August, September, October, November, December
    }

    public enum Hobbies {
        SPORTS, READING, MUSIC
    }

    public enum State {
        NCR, Haryana, Rajasthan
    }

    public enum City {
        Jaipur, Jaiselmer
    }
}
