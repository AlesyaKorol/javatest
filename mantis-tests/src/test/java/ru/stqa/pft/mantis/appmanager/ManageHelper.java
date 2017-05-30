package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import ru.stqa.pft.mantis.model.UserData;

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

  public void selectUser (int id){
    click(By.xpath("//a[contains(@href,'manage_user_edit_page.php?user_id=" + id + "')]"));
      }

  public void initPasswordChange (){
    click(By.cssSelector("input[value='Reset Password']"));
  }

  public void changePasswordStart(UserData user) {
    openManagePage();
    openManageUsers();
    selectUser(user.getId());
    initPasswordChange();
  }

  public void changePasswordFinish (String confirmationLink, String password){
    wd.get(confirmationLink);
    type(By.name("password"),password);
    type(By.name("password_confirm"),password);
    click(By.cssSelector("input[value='Update User']"));
  }

}
