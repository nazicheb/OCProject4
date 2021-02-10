package com.hemebiotech.analytics; 

import java.io.FileWriter; 
import java.io.IOException; 
import java.util.TreeMap; 
import java.util.Set; 
import java.util.Iterator; 
import java.util.Map; 


  /** this class generates the results file output 
  * @author naziha */ 

  public class WriteSymptomDataWithCount { 

     private TreeMap<String,Integer> symptreemap; 

     /**  
      * @param symptreemap represents a TreeMap where symptoms are keys and the number of duplication are values */ 

     public WriteSymptomDataWithCount ( TreeMap<String,Integer> symptreemap) { 

         this.symptreemap = symptreemap; 

     } 

     /** this methods creates results file then puts each element of symptreemap in a line */ 

     public void postSymptoms() { 

      if (symptreemap != null) { 

        try { 

             FileWriter writer = new FileWriter ("Results.out"); 
             Set set = symptreemap.entrySet(); 
             Iterator iterator = set.iterator(); 

             while(iterator.hasNext()) { 

             /** @param elemsymptreemap represents an element of symptreemap (example: cough=6) */ 

                 Map.Entry elemsymptreemap = (Map.Entry)iterator.next(); 
                 
                 writer.write(elemsymptreemap+"\n"); 
             } 

             writer.close(); 

         } catch (IOException e) { 
               
        	 e.printStackTrace();
        	 
           } 
       } 
     } 

  } 

 
