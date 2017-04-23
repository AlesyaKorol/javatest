package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDate;

public class GroupsCreationTests extends TestBase {

  @Test
  public void testGroupsCreation() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().createAGroup(new GroupDate("group1","Group1-h", "Group1-f"));
  }

}
