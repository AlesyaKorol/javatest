package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDate;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Alesia on 15.04.17.
 */
public class GroupsModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.getNavigationHelper().gotoGroupPage();
    if (!app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createAGroup(new GroupDate("group1", "test", null));
     }
    }

    @Test
    public void testGroupsModification () {
      List<GroupDate> before = app.getGroupHelper().getGroupList();
      int index = before.size() - 1;
      GroupDate group = new GroupDate(before.get(index).getId(), "test100", "group2", "group3");
      app.getGroupHelper().modifyGroup(index, group);
      List<GroupDate> after = app.getGroupHelper().getGroupList();
      Assert.assertEquals(after.size(), before.size());

      before.remove(index);
      before.add(group);
      Comparator<? super GroupDate> ById = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
      before.sort(ById);
      after.sort(ById);
      Assert.assertEquals(before, after);
    }


  }
