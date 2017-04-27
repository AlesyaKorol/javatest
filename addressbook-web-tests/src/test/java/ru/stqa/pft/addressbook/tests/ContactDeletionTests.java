package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by Alesia on 15.04.17.
 */
public class ContactDeletionTests extends TestBase {

  @Test

  public void testContactDeletion() {
    app.getNavigationHelper().goToHomePage();
    int before = app.getContactHelper().getContactCount();

    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Pasha", "Ivanov",
              "80295789098", "anna@gmail.com", "group1"), true);
      }

    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().closeAlertWindow();
    app.getNavigationHelper().goToHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before - 1);
  }
}
