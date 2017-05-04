package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDate;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

/**
 * Created by Alesia on 15.04.17.
 */
public class GroupsModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().list().size() == 0) {
      app.group().create(new GroupDate().withGroupname("test1"));
     }
    }

    @Test
    public void testGroupsModification () {
      Set<GroupDate> before = app.group().all();
      GroupDate modifiedGroup = before.iterator().next();
      GroupDate group = new GroupDate().withId(modifiedGroup.getId()).withGroupname("test100").withHeader("Header").withFooter("Footer");
      app.group().modify(group);
      Set<GroupDate> after = app.group().all();
      Assert.assertEquals(after.size(), before.size());

      before.remove(modifiedGroup);
      before.add(group);
      Assert.assertEquals(before, after);
    }

  }
