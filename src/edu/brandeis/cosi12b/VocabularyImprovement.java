package edu.brandeis.cosi12b;

import java.io.FileNotFoundException;

/*
 * Main program showing invocation of each improved version
 */
public class VocabularyImprovement {

  public static void main(String[] args) throws FileNotFoundException {
    System.out.println("First algorithm:");
    Vocab1 voc1 = new Vocab1();
    voc1.processFiles();
    
    System.out.println("\nSecond algorithm:");
    Vocab2 voc2 = new Vocab2();
    voc2.processFiles();
    voc2.printoutLists();
   
  }

}
