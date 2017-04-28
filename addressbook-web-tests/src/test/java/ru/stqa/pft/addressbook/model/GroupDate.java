package ru.stqa.pft.addressbook.model;

public class GroupDate {
  private int id;
  private final String groupname;
  private final String header;
  private final String footer;

  public GroupDate(int id, String groupname, String header, String footer) {
    this.id = id;
    this.groupname = groupname;
    this.header = header;
    this.footer = footer;
  }


  public GroupDate(String groupname, String header, String footer) {
    this.groupname = groupname;
    this.header = header;
    this.footer = footer;
    this.id = 0;
  }

  public int getId() {
    return id;
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

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "GroupDate{" +
            "id='" + id + '\'' +
            ", groupname='" + groupname + '\'' +
            '}';
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

}
