package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() {
    app.getNavigationHelper().goToHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().initContactCreation();
    app.getContactHelper().createContact(new ContactData("Olga2", "Ivanova2",
        "80295789098", "anna@gmail.com", "group1"), true);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);
  }

}

