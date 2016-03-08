package edu.brandeis.cosi12b;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Vocab3 {
  ArrayList<String> list1;
  ArrayList<String> list2;
  ArrayList<String> dups;
  
  // Read the two files and load up list1 and list2 with the words found there
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

  public void reportResults() {
    System.out.println("file #1 words = " + list1.size());
    System.out.println("file #2 words = " + list2.size());
    System.out.println("common words  = " + dups.size());
    System.out.println();
    double percent1 = 100.0 * dups.size() / list1.size();
    double percent2 = 100.0 * dups.size() / list2.size();
    System.out.printf("%% of file 1 in overlap = %.2f%%%n", percent1);
    System.out.printf("%% of file 2 in overlap = %.2f%%", percent2);
  }

  /*
   * Read the words, put them in a list and sort them. Skip non alpha
   * characters as delimiters. Sort the resultant list.
   */
  public ArrayList<String> getWords(Scanner input) {
    input.useDelimiter("[^a-zA-Z’]+");
    ArrayList<String> words = new ArrayList<String>();
    while (input.hasNext()) {
      String next = input.next().toLowerCase();
      words.add(next);
    }
    Collections.sort(words);
    return words;
  }

  /*
   * Return new list which is input list without duplicates.
   * Assumes that the list is sorted.
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
  
  /*
   * Given two lists, create a new list which is only the words found in both lists.
   */
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

