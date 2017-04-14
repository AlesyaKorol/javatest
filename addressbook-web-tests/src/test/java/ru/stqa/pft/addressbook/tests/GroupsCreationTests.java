package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDate;

public class GroupsCreationTests extends TestBase {

  @Test
  public void testGroupsCreation() {
    app.gotoGroupPage();
    app.initGroupCreation();
    app.fillGroupForm(new GroupDate("group1", "group2", "group3"));
    app.submitGroupCreation();
    app.returToGroupPage();
  }

}
