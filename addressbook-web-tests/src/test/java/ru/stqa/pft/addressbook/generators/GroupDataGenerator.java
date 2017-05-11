package ru.stqa.pft.addressbook.generators;

import ru.stqa.pft.addressbook.model.GroupDate;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alesya on 05/11/2017.
 */
public class GroupDataGenerator {

  public static void main (String args[]){

   int count = Integer.parseInt(args[0]);
   File file = new File(args[1]);

    List<GroupDate> groups = generateGroups(count);
    save (groups, file);
  }

  private static void save(List<GroupDate> groups, File file) {
  }

  private static List<GroupDate> generateGroups(int count) {
    List<GroupDate> groups = new ArrayList<GroupDate>();
    for (int i = 0; i < count; i++){
      groups.add(new GroupDate().withGroupname(String.format("test %s", i))
              .withHeader(String.format("header %s", i))
              .withFooter(String.format("footer %s", i)));
    }
    return groups;
  }
}
