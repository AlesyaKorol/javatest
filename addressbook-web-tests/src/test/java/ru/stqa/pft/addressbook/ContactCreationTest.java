package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() {
    initContactCreation();
    fillContactForm(new ContactData("Olga", "Ivanova", "80295789098", "anna@gmail.com"));
    submitContactCreation();
    goToHomePage();
  }

}

