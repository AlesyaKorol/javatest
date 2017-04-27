package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDate;

import java.util.List;

public class GroupsCreationTests extends TestBase {

  @Test
  public void testGroupsCreation() {
    app.getNavigationHelper().gotoGroupPage();
    List<GroupDate> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().createAGroup(new GroupDate("group1","Group1-h", "Group1-f"));
    List<GroupDate> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() +1 );
  }

}
