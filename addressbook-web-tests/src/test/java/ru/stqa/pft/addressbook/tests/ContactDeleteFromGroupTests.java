package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Alesia on 23.05.17.
 */
public class ContactDeleteFromGroupTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
     Groups groups = app.db().groups();
      if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1"));
    }

    if (app.db().contacts().size() == 0) {
      app.goTo().homePage();
      app.contact().create(new ContactData().
              withFirstname("Olga02").withLastname("Test").withAddress("test")
              .inGroup(groups.iterator().next()), true);
    }
    app.goTo().homePage();
  }


  @Test
  public void testContactDeleteFromGroup (){
    Groups groups = app.db().groups();
    //Contacts before = app.db().contacts();
    Groups before = app.db().groups();
    GroupData groupInTopList = before.iterator().next();

//    ContactData contact = new ContactData().withId(contactToDelete.getId())
//            .withFirstname(contactToDelete.getFirstname()).withLastname(contactToDelete.getLastname()).withHomephone(contactToDelete.getHomephone())
//            .withMobilephone(contactToDelete.getMobilephone()).withWorkphone(contactToDelete.getWorkphone()).withEmai1(contactToDelete.getEmail())
//            .withEmail2(contactToDelete.getEmail2()).withEmail3(contactToDelete.getEmail3()).withAddress(contactToDelete.getAddress())
//            .inGroup(groups.iterator().next());

    GroupData group = new GroupData().withName("213");

    app.group().deleteFromGroup(group);
    app.group().removeTopGroup();
    //Contacts after = app.db().contacts();
    Groups after = app.db().groups();

    //assertThat(after, equalTo(before.without(contact.withGroups(groups)).withAdded(contactToDelete)));
  }

  }


