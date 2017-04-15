package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by Alesia on 15.04.17.
 */
public class ContactModificationTests extends TestBase {

  @Test

  public void testContactMidification() {
    app.getNavigationHelper().goToHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Inna", "Ivanova", "80295789098", "Innatest@gmail.com"));
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().goToHomePage();
  }
}
