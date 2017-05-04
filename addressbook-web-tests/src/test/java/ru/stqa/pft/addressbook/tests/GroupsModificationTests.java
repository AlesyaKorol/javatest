package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDate;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Alesia on 15.04.17.
 */
public class GroupsModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().list().size() == 0) {
      app.group().create(new GroupDate("group1", "test", null));
     }
    }

    @Test
    public void testGroupsModification () {
      List<GroupDate> before = app.group().list();
      int index = before.size() - 1;
      GroupDate group = new GroupDate(before.get(index).getId(), "test100", "group2", "group3");
      app.group().modify(index, group);
      List<GroupDate> after = app.group().list();
      Assert.assertEquals(after.size(), before.size());

      before.remove(index);
      before.add(group);
      Comparator<? super GroupDate> ById = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
      before.sort(ById);
      after.sort(ById);
      Assert.assertEquals(before, after);
    }

  }
