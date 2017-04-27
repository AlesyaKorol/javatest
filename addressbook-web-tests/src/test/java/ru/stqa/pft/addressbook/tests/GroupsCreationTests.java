package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDate;

public class GroupsCreationTests extends TestBase {

  @Test
  public void testGroupsCreation() {
    app.getNavigationHelper().gotoGroupPage();
    int before = app.getGroupHelper().getGroupCount();
    app.getGroupHelper().createAGroup(new GroupDate("group1","Group1-h", "Group1-f"));
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before +1 );
  }

}
