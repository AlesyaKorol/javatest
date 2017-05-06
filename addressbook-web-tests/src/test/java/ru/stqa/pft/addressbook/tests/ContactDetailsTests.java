package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

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
              withFirstname("Olga02").withLastname("Test").withHomephone("111").withMobilephone("222").withWorkphone("333")
              .withEmai1("anna@gmail.com").withEmail2("test").withEmail3("test2")
              .withGroup("[none]"), true);
    }
  }

  @Test
  public void testContactDetailsSplit() {
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactView = app.contact().infoContactDetailsSplit(contact);
    ContactData contactInfoEditForm = app.contact().infoContactEditForm(contact);

    assertThat(contactView.getFirstname(), equalTo(contactInfoEditForm.getFirstname()));
    assertThat(contactView.getLastname(), equalTo(contactInfoEditForm.getLastname()));
    assertThat(contactView.getAddress(), equalTo(contactInfoEditForm.getAddress()));
    assertThat(cleaned(contactView.getHomephone()), equalTo(cleaned(contactInfoEditForm.getHomephone())));
    assertThat(cleaned(contactView.getMobilephone()), equalTo(cleaned(contactInfoEditForm.getMobilephone())));
    assertThat(cleaned(contactView.getWorkphone()), equalTo(cleaned(contactInfoEditForm.getWorkphone())));
    assertThat(contactView.getEmail(), equalTo(contactInfoEditForm.getEmail()));
    assertThat(contactView.getEmail2(), equalTo(contactInfoEditForm.getEmail2()));
    assertThat(contactView.getEmail3(), equalTo(contactInfoEditForm.getEmail3()));
  }

  public static String cleaned(String phone) {
      return phone.replaceAll("\\s", "")
            .replaceAll("(M:)", "").replaceAll("(H:)", "").replaceAll("(W:)", "");
  }

  private String mergedDetails(ContactData contact) {
    return Arrays.asList(contact.getFirstname(), contact.getLastname(), contact.getAddress(), contact.getHomephone(), contact.getMobilephone(), contact.getWorkphone(), contact.getEmail(), contact.getEmail2(), contact.getEmail3())
            .stream().filter((s) -> !s.equals(""))
            .map(ContactDetailsTests::cleaned)
            .collect(Collectors.joining(""));
  }

  @Test
  public void testContactDetailsMerge() {
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactView = app.contact().infoContactDetailsMerge(contact);
    ContactData contactInfoEditForm = app.contact().infoContactEditForm(contact);

    System.out.println(cleaned(contactView.getFirstname()));
    System.out.println(mergedDetails(contactInfoEditForm));

    assertThat(cleaned(contactView.getFirstname()), equalTo(mergedDetails(contactInfoEditForm)));

  }

}
