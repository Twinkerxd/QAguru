package homework7;

import com.github.javafaker.Faker;

import java.util.Random;

public class RandomDataGenerator {
    static Faker faker = new Faker();

    static String randomFirstName() {
        return String.valueOf(faker.name().firstName());
    }

    static String randomLastName() {
        return String.valueOf(faker.name().lastName());
    }

    static String randomEmail() {
        return String.valueOf(faker.internet().emailAddress());
    }

    static String randomAddress() {
        return String.valueOf(faker.address().fullAddress());
    }

    static String randomMobilePhone(int phoneLength) {
        String SALTCHARS = "1234567890";
        StringBuilder result = new StringBuilder();
        Random random = new Random();
        while (result.length() < phoneLength) {
            int index = (int) (random.nextFloat() * SALTCHARS.length());
            result.append(SALTCHARS.charAt(index));
        }
        return "9" + result;
    }
}
