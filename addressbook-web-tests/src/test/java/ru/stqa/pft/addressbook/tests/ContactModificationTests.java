package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Alesia on 15.04.17.
 */
public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().homePage();
              "80295789098", "anna@gmail.com", "[none]"), true);
    }
  }

  @Test
  public void testContactModification() {
    int index = before.size() - 1;
    ContactData contact = new ContactData(before.get(index).getId(),"Anna", "Smirnova",
            "80295789098", "Innatest@gmail.com", null);
    Assert.assertEquals(after.size(), before.size());


    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);
  }


}
