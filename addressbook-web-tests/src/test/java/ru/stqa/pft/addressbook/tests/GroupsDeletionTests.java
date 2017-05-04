package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDate;

import java.util.List;

public class GroupsDeletionTests extends TestBase {


  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().groupPage();
    if (app.group().list().size() == 0) {
      app.group().create(new GroupDate("group1", "test", null));
    }
  }

  @Test
  public void testGroupsDeletion() {
    List<GroupDate> before = app.group().list();
    int index = before.size() - 1;
    app.group().delete(index);
    List<GroupDate> after = app.group().list();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(index);
    Assert.assertEquals(before, after);
    }


}
