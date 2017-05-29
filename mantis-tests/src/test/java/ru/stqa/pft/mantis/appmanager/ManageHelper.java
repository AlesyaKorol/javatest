package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

/**
 * Created by Alesya on 05/29/2017.
 */
public class ManageHelper extends HelperBase {


  public ManageHelper  (ApplicationManager app) {
    super(app);
  }
   public void openManagePage (){
     wd.get(app.getProperty("web.baseUrl") + "/manage_overview_page.php");
   }

  public void openManageUsers (){
    wd.get(app.getProperty("web.baseUrl") + "/manage_user_page.php");
  }

  public void selectUser (){
    click(By.xpath("//a[contains(@href,'vimanage_user_edit_page.php?user_id=2')]"));
  }

  public void initPasswordChange (){
    click(By.cssSelector("input[value='Reset Password']"));
  }

  public void changePasswordStart() {
    openManagePage();
    openManageUsers();
    selectUser();
    initPasswordChange();
  }

  public void changePasswordFinish (String confirmationLink, String password){
    wd.get(confirmationLink);
    type(By.name("password"),password);
    type(By.name("password_confirm"),password);
    click(By.cssSelector("input[value='Update User']"));
  }

}
