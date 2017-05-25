package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Alesia on 23.05.17.
 */
public class GroupRemoveContactTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    Groups groups = app.db().groups();
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("GROUP1"));
    }

//    if (app.db().contacts().size() == 0) {
//      app.goTo().homePage();
//      app.contact().create(new ContactData().
//              withFirstname("Anna").withLastname("Ivanova").withAddress("Address")
//              .inGroup(groups.iterator().next()), true);
//    }

    app.goTo().homePage();
  }

  @Test
  public void testGroupRemoveContact() {
    Contacts contacts = app.db().contacts();
    Groups before = app.db().groups();
    GroupData groupInTopList = before.iterator().next();
    GroupData group = new GroupData().withName(groupInTopList.getName());

    if (groupInTopList.getContacts().size() == 0) {
      app.goTo().homePage();
      app.contact().create(new ContactData().
              withFirstname("Kate").withLastname("Smirnova").withAddress("Minsk")
              .inGroup(group), true);
    }

    app.group().deleteFromGroup(group);


    Groups after = app.db().groups();

  }
}


