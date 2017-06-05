package ru.stqa.pft.rest;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

/**
 * Created by Alesya on 06/05/2017.
 */
public class RestTests {
  @Test
  public void testCreateIssue() throws IOException {
    Set<Issue> oldIssues = getIssues();
    Issue newIssue = new Issue();
    int ussueId = createIssue(newIssue);
    Set<Issue> newIssues = getIssues();
    oldIssues.add(newIssue.withId(ussueId));
    assertEquals(newIssues, oldIssues);
  }


  private Set<Issue> getIssues() throws IOException {
    String json = getExecutor().execute(Request.Get("http://demo.bugify.com/api/issues.json"))
            .returnContent().asString();
    JsonElement parsed = new JsonParser().parse(json);
    JsonElement issues = parsed.getAsJsonObject().get("issues");

    return new Gson().fromJson(issues, new TypeToken<Set<Issue>>() {
    }.getType());
  }


  private Executor getExecutor() {
    return Executor.newInstance().auth("LSGjeU4yP1X493ud1hNniA==", "");
  }

  private int createIssue(Issue newIssue) throws IOException {
    String json = getExecutor().execute(Request.Post("http://demo.bugify.com/api/issues.json"))
            .returnContent().asString();
    return 0;
  }
}



