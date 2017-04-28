package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDate;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Alesia on 15.04.17.
 */
public class GroupsModificationTests extends TestBase {

  @Test

  public void testGroupsModification() {
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createAGroup(new GroupDate("group1", "test", null));
    }
    List<GroupDate> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size() - 1);
    app.getGroupHelper().initGroupModification();
    GroupDate group = new GroupDate(before.get(before.size() - 1).getId(),"test19", "group2", "group3");
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupModificatio();
    app.getGroupHelper().returToGroupPage();
    List<GroupDate> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(group);
    Comparator<? super GroupDate> ById = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(ById);
    after.sort(ById);
    Assert.assertEquals(before, after);
  }
}
