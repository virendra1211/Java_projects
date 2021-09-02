package org.test;
import java.util.ArrayList;
import java.util.Iterator;
public class ArrayListElementdeleteIteration {
   public static void main(String[] args) {
      ArrayList<String> aList = new ArrayList<String>();
      aList.add("Apple");
      aList.add("Mango");
      aList.add("Guava");
      aList.add("Orange");
      aList.add("Peach");
      System.out.println("The ArrayList elements are: ");
      for (String s: aList) {
         System.out.println(s);
      }
      Iterator i = aList.iterator();
      String str = "";
      while (i.hasNext()) {
         str = (String) i.next();
         if (str.equals("Orange")) {
            i.remove();
            System.out.println("\nThe element Orange is removed");
            break;
         }
      }
      System.out.println("\nThe ArrayList elements are: ");
      for (String s: aList) {
         System.out.println(s);
      }
   }
}