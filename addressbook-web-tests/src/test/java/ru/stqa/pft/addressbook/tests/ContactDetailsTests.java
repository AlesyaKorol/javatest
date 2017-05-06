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
public class ContactDetailsTests extends TestBase {
  @BeforeMethod()
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().
              withFirstname("Olga02").withLastname("Test").withHomephone("111").withMobilephone("222").
              withWorkphone("333").withEmai1("anna@gmail.com").withGroup("[none]"), true);
    }
  }

  @Test
  public void testContactDetails() {
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactView = app.contact().infoContactDetails(contact);
    ContactData contactInfoEditForm = app.contact().infoContactEditForm(contact);

    System.out.println("details " + contactView.getAddress());
    System.out.println("details ph " + contactView.getHomephone());
    System.out.println("edit form  " + contactInfoEditForm.getAddress());
    System.out.println("edit form ph " + contactInfoEditForm.getHomephone());

    assertThat(contactView.getAddress(), equalTo(contactInfoEditForm.getAddress()));
    // assertThat(contactView.getHomephone(), equalTo(contactInfoEditForm.getHomephone()));


  }
}
