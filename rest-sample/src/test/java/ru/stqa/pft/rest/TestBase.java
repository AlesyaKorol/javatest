package ru.stqa.pft.rest;

import biz.futureware.mantis.rpc.soap.client.IssueData;
import biz.futureware.mantis.rpc.soap.client.MantisConnectLocator;
import biz.futureware.mantis.rpc.soap.client.MantisConnectPortType;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.openqa.selenium.remote.BrowserType;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.mantis.appmanager.ApplicationManager;

import javax.xml.rpc.ServiceException;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;


/**
 * Created by Alesia on 15.04.17.
 */
public class TestBase {


 public boolean isIssueOpen(int issueId) throws IOException {

   String json = getExecutor().execute(Request.Get("http://demo.bugify.com/api/issue/issue_id.json"))
           .returnContent().asString();

   JsonElement parsed = new JsonParser().parse(json);
   JsonElement issue = parsed.getAsJsonObject().get("issue");

   if(  issue.getStatus().equals("Open")){
     return true;
   }
   if( ! issue.getStatus().getName().equals("Open")){
     return false;
   }
   return false;
 }

  private Executor getExecutor() {
    return Executor.newInstance().auth("LSGjeU4yP1X493ud1hNniA==", "");
  }


  public void skipIfNotFixed(int issueId) throws IOException {
    if (isIssueOpen(issueId)) {
      throw new SkipException("Ignored because of issue " + issueId);
    }
  }

}



