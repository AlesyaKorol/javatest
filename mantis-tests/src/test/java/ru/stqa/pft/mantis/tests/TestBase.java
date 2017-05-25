package ru.stqa.pft.mantis.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.mantis.appmanager.ApplicationManager;


/**
 * Created by Alesia on 15.04.17.
 */
public class TestBase {
  protected static final ApplicationManager app
          = new ApplicationManager(System.getProperty("browser",BrowserType.CHROME));


  @BeforeSuite
  public void setUp()throws Exception{
    app.init();
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown(){
    app.stop();
  }
}



