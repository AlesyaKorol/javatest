package ru.stqa.pft.addressbook.model;

public class GroupDate {
  private final String id;
  private final String groupname;
  private final String header;
  private final String footer;

  public GroupDate(String id, String groupname, String header, String footer) {
    this.id = id;
    this.groupname = groupname;
    this.header = header;
    this.footer = footer;
  }


  public GroupDate( String groupname, String header, String footer) {
    this.groupname = groupname;
    this.header = header;
    this.footer = footer;
    this.id = null;
  }

  public String getId() {
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


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    GroupDate groupDate = (GroupDate) o;

    if (id != null ? !id.equals(groupDate.id) : groupDate.id != null) return false;
    return groupname != null ? groupname.equals(groupDate.groupname) : groupDate.groupname == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
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
