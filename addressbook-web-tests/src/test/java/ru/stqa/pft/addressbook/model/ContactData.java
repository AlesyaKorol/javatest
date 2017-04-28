package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String firstname;
  private final String lastname;
  private String group;
  private final String mobilephone;
  private final String email1;

  public ContactData(String firstname, String lastname, String mobilephone, String email1, String group) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.group = group;
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

  public String getGroup() {
    return group;
  }


  @Override
  public String toString() {
    return "ContactData{" +
            "firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
  }

  @Override
  public int hashCode() {
    int result = firstname != null ? firstname.hashCode() : 0;
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
  }
}
