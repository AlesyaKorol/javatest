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
}
