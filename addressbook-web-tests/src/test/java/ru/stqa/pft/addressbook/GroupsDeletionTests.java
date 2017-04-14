package ru.stqa.pft.addressbook;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GroupsDeletionTests extends TestBase {

  @Test
  public void testGroupsDeletion() {
    gotoGroupPage();
    selectGroup();
    deleteSelectedGroups();
    returToGroupPage();
  }

}
