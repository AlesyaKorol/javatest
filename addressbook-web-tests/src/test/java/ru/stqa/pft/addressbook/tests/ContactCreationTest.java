package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() {
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("Olga", "Ivanova", "80295789098", "anna@gmail.com"));
    app.getContactHelper().submitContactCreation();
    app.goToHomePage();
  }

}

