package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

import java.sql.Connection;

/**
 * Created by Alesya on 05/18/2017.
 */
public class DbConnectionTest {

  @Test
  public void testDbConnection(){
    Connection conn = null;
...
    try {
      conn =
              DriverManager.getConnection("jdbc:mysql://localhost/test?" +
                      "user=minty&password=greatsqldb");

      // Do something with the Connection

   ...
    } catch (SQLException ex) {
      // handle any errors
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
    }

  }



}


