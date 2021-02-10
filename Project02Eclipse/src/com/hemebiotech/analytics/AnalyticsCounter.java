package com.hemebiotech.analytics; 

import java.util.ArrayList; 
import java.util.List; 
import java.util.TreeMap; 

  /** AnalyticsCounter represents the first version of analytics project for hemebiotech society 
   * @author naziha */ 

public class AnalyticsCounter { 

  /** filepath refers to the file Symptoms.txt */ 

  private static String filepath="Symptoms.txt"; 

/** This method reads the Symtoms file,counts the number of duplications for each symptom and generates results 
 * file that groups symptoms and their numbers of duplications in alphabetic order */ 

  public static void main(String args[]) throws Exception { 

  /** @param symplist is the list of symtoms obtained from Symtoms file 
  * @param symptreemap is the TreeMap with key equals symtom (type string) and values equals the number of 
  * duplications (type integer) */ 

   List<String> symplist = new ArrayList<String>(); 
   TreeMap<String,Integer> symptreemap=new TreeMap<String,Integer>(); 
   
   /** this reads the filepath then creates symplist by GetSymptoms method  
    * @see ReadSymptomDataFromFile */ 

    ReadSymptomDataFromFile sympread = new ReadSymptomDataFromFile(filepath); 
    symplist= sympread.GetSymptoms(); 
     
    /** this creates symptreemap where keys are symptoms obtained from symplist 
     * and values are numbers of duplications counted due to countAndTreeSymptoms method 
     * @see CountSymtomListAndOrder */ 

     CountSymtomListAndOrder sympcountorder=new CountSymtomListAndOrder(symplist); 
     symptreemap=sympcountorder.countAndTreeSymptoms(); 

    /** this created the results output file where symptreemap elements are writted 
    * @see WriteSymptomDataWithCount */ 

    WriteSymptomDataWithCount sympwrite=new WriteSymptomDataWithCount(symptreemap); 
    sympwrite.postSymptoms(); 

  } 
} 

 
