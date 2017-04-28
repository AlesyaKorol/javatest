package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDate;

import java.util.HashSet;
import java.util.List;

public class GroupsCreationTests extends TestBase {

  @Test
  public void testGroupsCreation() {
    app.getNavigationHelper().gotoGroupPage();
    List<GroupDate> before = app.getGroupHelper().getGroupList();
    GroupDate group = new GroupDate("group1", "Group1-h", "Group1-f");
    app.getGroupHelper().createAGroup(group);
    List<GroupDate> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1);


    int max = 0;
    for (GroupDate g : after) {
      if (g.getId() > max) {
        max = g.getId();
      }
    }
    group.setId(max);
    before.add(group);
    Assert.assertEquals(new HashSet<>(before), new HashSet<>(after));
  }

}
