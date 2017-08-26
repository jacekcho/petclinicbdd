package local.petclinic.utils;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Locale;

public class Generators {

    public static Faker faker = new Faker(new Locale("en"));

    public static String randomTelephoneNumber() {
        return RandomStringUtils.randomNumeric(10);
    }

    public static String randomFirstName() {
        return faker.name().firstName();
    }

    public static String randomLastName() {
        return faker.name().lastName();
    }

    public static String randomAddress() {
        return faker.address().streetAddress();
    }

    public static String randomCity() {
        return faker.address().city();
    }
}