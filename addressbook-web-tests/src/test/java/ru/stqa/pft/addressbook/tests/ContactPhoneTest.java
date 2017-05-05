package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Alesya on 05/05/2017.
 */
public class ContactPhoneTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().
              withFirstname("Olga02").withLastname("Test").withHomephone("111").withMobilephone("222").
              withWorkphone("333").withEmai1("anna@gmail.com").withGroup("[none]"), true);
    }
  }


  @Test
  public void testContactPhone() {
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoEditForm = app.contact().infoContactEditForm(contact);

    assertThat(contact.getHomephone(), equalTo(contactInfoEditForm.getHomephone()));
    assertThat(contact.getMobilephone(), equalTo(contactInfoEditForm.getMobilephone()));
    assertThat(contact.getWorkphone(), equalTo(contactInfoEditForm.getWorkphone()));
  }

}
