package ru.stqa.pft.addressbook.model;

public class GroupDate {
  private int id = Integer.MAX_VALUE;
  private String groupname;
  private  String header;
  private  String footer;

  public int getId() {
    return id;
  }

  public String getName() {
    return groupname;
  }

  public String getHeader() {
    return header;
  }

  public String getFooter() {
    return footer;
  }

  public GroupDate withId(int id) {
    this.id = id;
    return this;
  }

  public GroupDate withName(String groupname) {
    this.groupname = groupname;
    return this;
  }

  public GroupDate withHeader(String header) {
    this.header = header;
    return this;
  }

  public GroupDate withFooter(String footer) {
    this.footer = footer;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    GroupDate groupDate = (GroupDate) o;

    if (id != groupDate.id) return false;
    return groupname != null ? groupname.equals(groupDate.groupname) : groupDate.groupname == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (groupname != null ? groupname.hashCode() : 0);
    return result;
  }
  @Override
  public String toString() {
    return "GroupDate{" +
            "id='" + id + '\'' +
            ", groupname='" + groupname + '\'' +
            '}';
  }

}
