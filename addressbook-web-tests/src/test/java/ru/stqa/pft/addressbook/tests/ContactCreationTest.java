package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() {
    app.goTo().homePage();
    Set<ContactData> before = app.contact().all();
    app.contact().initContactCreation();
    ContactData contact = new ContactData()
            .withFirstname("Alesya").withLastname("Test").withMobilephone("80295789098").withEmail1("anna@gmail.com").withGroup("[none]");
    app.contact().create(contact, true);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().mapToInt((c) ->c.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before,after);
  }

}

