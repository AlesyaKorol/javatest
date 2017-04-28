package ru.stqa.pft.addressbook.model;

public class GroupDate {
  private final String groupname;
  private final String header;
  private final String footer;

  public GroupDate(String groupname, String header, String footer) {
    this.groupname = groupname;
    this.header = header;
    this.footer = footer;
  }


  public String getGroupname() {
    return groupname;
  }

  public String getHeader() {
    return header;
  }

  public String getFooter() {
    return footer;
  }

  @Override
  public String toString() {
    return "GroupDate{" +
            "groupname='" + groupname + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    GroupDate groupDate = (GroupDate) o;

    return groupname != null ? groupname.equals(groupDate.groupname) : groupDate.groupname == null;
  }

  @Override
  public int hashCode() {
    return groupname != null ? groupname.hashCode() : 0;
  }
}
