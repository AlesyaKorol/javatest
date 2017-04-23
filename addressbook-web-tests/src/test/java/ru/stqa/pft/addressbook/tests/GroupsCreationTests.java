package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDate;

public class GroupsCreationTests extends TestBase {

  @Test
  public void testGroupsCreation() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupDate("group1", null, null));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returToGroupPage();
  }

}
