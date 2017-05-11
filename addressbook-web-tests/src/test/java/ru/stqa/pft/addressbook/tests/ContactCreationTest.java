package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContacts(){
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[] {new ContactData().withFirstname("firstname1").withLastname("lastname1")
            .withAddress("address1").withHomephone("111").withMobilephone("222").withWorkphone("333")
            .withEmai1("email1").withEmail2("email2").withEmail3("email3").withGroup("[none]")});
    list.add(new Object[] {new ContactData().withFirstname("firstname2").withLastname("lastname2")
            .withAddress("address2").withHomephone("111-2").withMobilephone("222-2").withWorkphone("333-2")
            .withEmai1("email1-2").withEmail2("email2-2").withEmail3("email3-2").withGroup("[none]")});
    return list.iterator();
  }


  @Test (dataProvider = "validContacts")
  public void testContactCreation(ContactData contact) {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    app.contact().initContactCreation();
    app.contact().create(contact, true);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

  @Test
  public void testContactCreationPhoto() {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    app.contact().initContactCreation();
    File photo = new File("src/test/resources/photo1.jpg");
    ContactData contact = new ContactData()
            .withFirstname("Kate").withLastname("Test").withPhoto(photo).withAddress("Tests").withHomephone("111")
            .withMobilephone("222").withWorkphone("333").withEmai1("anna@gmail.com")
            .withGroup("[none]");
    app.contact().create(contact, true);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

}

