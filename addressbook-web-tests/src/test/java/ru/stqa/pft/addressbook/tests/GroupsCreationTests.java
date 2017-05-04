package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDate;

import java.util.Comparator;
import java.util.List;

public class GroupsCreationTests extends TestBase {

  @Test
  public void testGroupsCreation() {
    app.goTo().groupPage();
    List<GroupDate> before = app.group().list();
    GroupDate group = new GroupDate("group5", "Group1-h", "Group1-f");
    app.group().create(group);
    List<GroupDate> after = app.group().list();
    Assert.assertEquals(after.size(), before.size() + 1);

    group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(group);
    Comparator<? super GroupDate> ById = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(ById);
    after.sort(ById);
    Assert.assertEquals(before, after);
  }

}
