package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;

/**
 * Created by Alesia on 27.05.17.
 */
public class RegistrationTests extends TestBase {

  @Test
  public void testRegistration(){
    app.registration().start ("user1", "user1@localhost.localhostdomain");

  }

}
