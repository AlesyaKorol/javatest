package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Alesia on 21.05.17.
 */
public class ContactAddToGroupTests extends TestBase {

  @Test
  public void testContactAddToGroup() {
    Groups groups = app.db().groups();
    Contacts before = app.db().contacts();
    app.goTo().homePage();
    ContactData addedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(addedContact.getId())
            .withFirstname(addedContact.getFirstname()).withLastname(addedContact.getLastname()).withHomephone(addedContact.getHomephone())
            .withMobilephone(addedContact.getMobilephone()).withWorkphone(addedContact.getWorkphone()).withEmai1(addedContact.getEmail())
            .withEmail2(addedContact.getEmail2()).withEmail3(addedContact.getEmail3()).withAddress(addedContact.getAddress())
            .inGroup(groups.iterator().next());
    app.contact().addToGroup(contact);
    app.goTo().homePage();
    Contacts after = app.db().contacts();

    System.out.println("TEST BEFORE " + before);
    System.out.println("TEST AFTER " + after);

    assertThat(after, equalTo(before.without(addedContact).withAdded(contact)));
  }

}
