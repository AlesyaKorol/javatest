package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Alesya on 05/06/2017.
 */
public class ContactViewTest extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData()
              .withFirstname("Olga02").withLastname("Test").withMobilephone("80295789098")
              .withEmai1("anna@gmail.com").withGroup("[none]"), true);
    }
  }


  @Test
  public void testContactView() {
   Contacts before = app.contact().all();
   ContactData viewedContact = before.iterator().next();
   app.contact().view(viewedContact);
   app.goTo().homePage();

   assertThat(app.contact().count(), equalTo(before.size()));
   Contacts after = app.contact().all();
   assertThat(after, equalTo(before));
  }
}
