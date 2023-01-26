package demoqa.tests;

import com.github.javafaker.Faker;

import java.io.File;
import java.time.Month;
import java.util.Objects;

public class TestData {

    Faker faker = new Faker();
    File picture = new File ("src/test/resources/picture.jpg");
    int numberOfMonth = faker.number().numberBetween(1, 11),
            year = faker.number().numberBetween(1900, 2100);
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = faker.options().option("Male", "Female", "Other"),
            number = faker.phoneNumber().subscriberNumber(10),
            stringOfMonth = String.valueOf(numberOfMonth),
            monthOfBirth = Month.of(numberOfMonth+1).name(),
            yearOfBirth = String.valueOf(year),
            dayOfBirth = String.valueOf(setBirhdayDay(monthOfBirth, year)),
            subject = faker.options().option("History", "Arts", "Biology", "Maths", "Commerce", "Social Studies", "Civics", "Hindi", "Physics","English", "Chemistry", "Computer Science", "Accounting", "Economics"),
            hobby = faker.options().option("Sports", "Reading", "Music"),
            address = faker.address().fullAddress(),
            state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            city = setCity(state);


    public String setCity(String state) {
        String city = new String();
        if (Objects.equals(this.state, "NCR")) {
            city = faker.options().option("Delhi", "Gurgaon", "Noida");
        } else if (Objects.equals(this.state, "Uttar Pradesh")) {
            city = faker.options().option("Agra", "Lucknow", "Merrut");
        } else if (Objects.equals(this.state, "Haryana")) {
            city = faker.options().option("Karnal", "Panipat");
        } else if (Objects.equals(this.state, "Rajasthan")) {
            city = faker.options().option("Jaipur", "Jaiselmer");
        }
        return city;
    }


    public String setBirhdayDay(String monthOfBirth, int year){
        String day;
        if (monthOfBirth.equals("JANUARY") || monthOfBirth.equals("MARCH") || monthOfBirth.equals("MAY") || monthOfBirth.equals("JULY")
                || monthOfBirth.equals("AUGUST") || monthOfBirth.equals("OCTOBER") || monthOfBirth.equals("DECEMBER")) {
            day = String.valueOf(faker.number().numberBetween(1, 31));
        } else if (monthOfBirth.equals("APRIL") || monthOfBirth.equals("JUNE") || monthOfBirth.equals("SEPTEMBER")
                    || monthOfBirth.equals("NOVEMBER")) {
            day = String.valueOf(faker.number().numberBetween(1, 30));
            } else if ((year % 400 == 0)
                || ((year % 4 == 0) && (year % 100 != 0))) {
                day = String.valueOf(faker.number().numberBetween(1, 29));
            } else {
                day = String.valueOf(faker.number().numberBetween(1, 28));
            }
                if (Integer.parseInt(day) < 10) {
                    return "0" + day;
                }
                else {
                    return day;
                }

        }
    }
