package edu.brandeis.cosi12b;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Solution to first attempt at Vocabulary Improvement Example
 */
public class Vocab1 {
  
  public void processFiles() throws FileNotFoundException {
    Scanner input1 = new Scanner(new File("test1.txt"));
    Scanner input2 = new Scanner(new File("test2.txt"));
    ArrayList<String> list1 = getWords(input1);
    ArrayList<String> list2 = getWords(input2);
    System.out.println("list1 = " + list1);
    System.out.println("list2 = " + list2);
  }
  
  public ArrayList<String> getWords(Scanner input) {
    ArrayList<String> words = new ArrayList<String>();
    while (input.hasNext()) {
        String next = input.next().toLowerCase();
        if (!words.contains(next)) {
            words.add(next);
        }
    }
    return words;
  }
}
