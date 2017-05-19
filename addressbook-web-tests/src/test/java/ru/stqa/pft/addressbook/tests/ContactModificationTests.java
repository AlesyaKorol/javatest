package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Alesia on 15.04.17.
 */
public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.db().contacts().size() == 0) {
      app.contact().create(new ContactData()
              .withFirstname("Olga02").withLastname("Test").withAddress("Address").withMobilephone("80295789098")
              .withEmai1("anna@gmail.com").withGroup("[none]"), true);
    }
  }

  @Test
  public void testContactModification() {
    Contacts before = app.db().contacts();
    System.out.println("TEST " + before);
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withLastname("Test").withHomephone("111").withMobilephone("222").withWorkphone("333")
            .withEmai1("anna@gmail.com").withEmail2("test");

    app.contact().modify(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    System.out.println("TEST1 " + after);
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }

}
