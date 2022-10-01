package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RegistrationFormWithPageObjectsTests {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    String firstName = "Darth";
    String lastName = "Vader";
    String email = "darty@gmail.com";
    String mobile = "0123456789";
    String subjects = "Eng";
    String currentAddress = "Empire, Death Star";

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender("Male")
                .setNumber(mobile)
                .setBirthDate("30", "November", "1986")
                .setSubjects(subjects)
                .setHobbies("Sports")
                .setHobbies("Reading")
                .setHobbies("Music")
                .uploadPicture("img/QA-Tester-meme-03.jpg")
                .setAddress(currentAddress)
                .setStateAndCity("NCR", "Noida")
                .clickSubmit();


        registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name", "Darth Vader")
                .checkResult("Student Email", "darty@gmail.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "0123456789")
                .checkResult("Date of Birth", "30 November,1986")
                .checkResult("Subjects", "English")
                .checkResult("Hobbies", "Sports, Reading, Music")
                .checkResult("Picture", "QA-Tester-meme-03.jpg")
                .checkResult("Address", "Empire, Death Star")
                .checkResult("State and City", "NCR Noida");
    }


    @Test
    void fillFormWithMinimumDataTest() {
        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender("Male")
                .setNumber(mobile)
                .clickSubmit();

        registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name", "Darth Vader")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "0123456789");
    }
}

