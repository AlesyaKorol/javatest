package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupsDeletionTests extends TestBase {

  @Test
  public void testGroupsDeletion() {
    app.gotoGroupPage();
    app.selectGroup();
    app.deleteSelectedGroups();
    app.returToGroupPage();
  }

}
