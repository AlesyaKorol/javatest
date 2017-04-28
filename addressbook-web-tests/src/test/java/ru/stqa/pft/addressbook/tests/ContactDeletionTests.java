package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

/**
 * Created by Alesia on 15.04.17.
 */
public class ContactDeletionTests extends TestBase {

  @Test

  public void testContactDeletion() {
    app.getNavigationHelper().goToHomePage();
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Pasha", "Ivanov",
              "80295789098", "anna@gmail.com", "group1"), true);
      }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().closeAlertWindow();
    app.getNavigationHelper().goToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);
    }
  }

