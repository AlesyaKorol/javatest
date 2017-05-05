package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by Alesia on 06.05.17.
 */
public class ContactDetailsTest extends TestBase {

  @Test
  public void testConatctDetails(){
  app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoDetails = app.contact().infoContactDetails(contact);

  }
}
