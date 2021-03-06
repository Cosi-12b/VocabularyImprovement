package edu.brandeis.cosi12b;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Vocab2 {
  ArrayList<String> list1;
  ArrayList<String> list2;
  ArrayList<String> dups;
  
  public void readFiles() throws FileNotFoundException {
    Scanner input1 = new Scanner(new File("test1.txt"));
    Scanner input2 = new Scanner(new File("test2.txt"));
    list1 = getWords(input1);
    list2 = getWords(input2);
  }


  public void processFiles() throws FileNotFoundException {
    list1 = removeDups(list1);
    list2 = removeDups(list2);
    dups = getOverlap(list1, list2);
  }

  public void printoutLists() {
    System.out.println("list1 = " + list1);
    System.out.println("list2 = " + list2);
    System.out.println("Dups = " + dups);
  }

  /*
   * Read the words, put them in a list and sort them
   */
  public ArrayList<String> getWords(Scanner input) {
    ArrayList<String> words = new ArrayList<String>();
    while (input.hasNext()) {
      String next = input.next().toLowerCase();
      words.add(next);
    }
    Collections.sort(words);
    return words;
  }

  /*
   * Remove list which is copy of old list minus dups
   */
  public ArrayList<String> removeDups(ArrayList<String> words) {
    ArrayList<String> result = new ArrayList<String>();
    if (words.size() == 0)
      return result; // Avoid error if file was empty

    result.add(words.get(0));
    for (int i = 1; i < words.size(); i++) {
      if (!words.get(i).equals(words.get(i - 1))) {
        result.add(words.get(i));
      }
    }
    return result;
  }
  

  public ArrayList<String> getOverlap(ArrayList<String> list1, ArrayList<String> list2) {
    ArrayList<String> result = new ArrayList<String>();
    int index1 = 0;
    int index2 = 0;
    while (index1 < list1.size() && index2 < list2.size()) {
      int comparison = list1.get(index1).compareTo(list2.get(index2));
      if (comparison == 0) {
        result.add(list1.get(index1));
        index1++;
        index2++;
      } else if (comparison < 0) {
        index1++;
      } else { // comparison > 0
        index2++;
      }
    }
    return result;
  }
  
  
  

}
