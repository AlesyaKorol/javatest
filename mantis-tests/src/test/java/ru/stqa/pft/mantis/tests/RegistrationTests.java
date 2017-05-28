package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Alesia on 27.05.17.
 */
public class RegistrationTests extends TestBase {
  @BeforeMethod
  public void startMailServer(){
    app.mail().start();
  }

  @Test
  public void testRegistration(){
    app.registration().start ("user1", "user1@localhost.localhostdomain");

  }

  @AfterMethod (alwaysRun = true)
  public void stopMailServer(){
    app.mail().stop();
  }

}
