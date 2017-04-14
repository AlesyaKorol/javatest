package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class GroupsCreationTests extends TestBase {

  @Test
  public void testGroupsCreation() {
    gotoGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupDate("group1", "group2", "group3"));
    submitGroupCreation();
    returToGroupPage();
  }

}
