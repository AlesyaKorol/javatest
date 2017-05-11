package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDate;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupsCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validGroups() {
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[]{new GroupDate().withName("test 1").withHeader("header 1").withFooter("footer 1")});
    list.add(new Object[]{new GroupDate().withName("test 2").withHeader("header 2").withFooter("footer 2")});
    list.add(new Object[]{new GroupDate().withName("test 3").withHeader("header 3").withFooter("footer 3")});
    list.add(new Object[]{new GroupDate().withName("test 4")});
    return list.iterator();
  }

  @Test(dataProvider = "validGroups")
  public void testGroupsCreation(GroupDate group) {
    app.goTo().groupPage();
    Groups before = app.group().all();
    app.group().create(group);
    assertThat(app.group().count(), equalTo(before.size() + 1));
    Groups after = app.group().all();
    assertThat(after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

  }

//  @Test
//  public void testBadGroupsCreation() {
//    app.goTo().groupPage();
//    Groups before = app.group().all();
//    GroupDate group = new GroupDate().withName("test2'");
//    app.group().create(group);
//    assertThat(app.group().count(), equalTo(before.size()));
//    Groups after = app.group().all();
//    assertThat(after, equalTo(before));
//  }

}
