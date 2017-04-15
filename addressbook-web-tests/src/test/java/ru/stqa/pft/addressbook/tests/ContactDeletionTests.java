package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by Alesia on 15.04.17.
 */
public class ContactDeletionTests extends TestBase {

  @Test

  public void testContactDeletion() {
    app.getNavigationHelper().goToHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().closeAlertWindow();
    app.getNavigationHelper().goToHomePage();


  }
}
