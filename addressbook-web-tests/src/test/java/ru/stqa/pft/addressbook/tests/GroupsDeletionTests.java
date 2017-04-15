package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupsDeletionTests extends TestBase {

  @Test
  public void testGroupsDeletion() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returToGroupPage();
  }

}
