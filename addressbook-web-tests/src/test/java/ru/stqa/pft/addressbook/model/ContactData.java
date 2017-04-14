package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String firstname;
  private final String lastname;
  private final String mobilephone;
  private final String email1;

  public ContactData(String firstname, String lastname, String mobilephone, String email1) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.mobilephone = mobilephone;
    this.email1 = email1;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getMobilephone() {
    return mobilephone;
  }

  public String getEmail1() {
    return email1;
  }
}
