package com.hemebiotech.analytics; 

import java.util.List; 
import java.util.ArrayList; 
import java.util.TreeMap; 
import java.util.Set; 
import java.util.Iterator; 
import java.util.Map; 

/** this class calculates the number of duplications for each symptoms and grouped symtoms and their number of duplications in a TreeMap 
* where symtoms are ordered automatically   
* @author naziha */ 

  public class CountSymtomListAndOrder { 

    private List<String> symplist = new ArrayList<String>(); 

     /** @param symplist represents a list of symptoms */ 

    public CountSymtomListAndOrder ( List<String> symplist) { 

       this.symplist = symplist; 
    } 

   /** this methods counts the number of duplications for each symptom listed in symplist.symtoms and number of duplications are
    * putted in symptreemap where keys are symtoms (type string) and values are number of duplications (type integer) */ 

   public TreeMap<String,Integer> countAndTreeSymptoms() { 

      TreeMap<String,Integer> symptreemap=new TreeMap<String,Integer>(); 

      int i,j,count=0; 
      Boolean done=false; 

      if(symplist!=null) 
      { 

       for(i=0;i<symplist.size();i++) 

       { 

      /** actions inside the if condition aims to check if a symtom in symplist existed in symptreemap. So in this case, 
       * the number of duplications was calculated before (done=true). No needs to recalculate again! */ 

         if(i!=0) 
         { 
           done=false; 

           Set set = symptreemap.entrySet(); 
           Iterator iterator = set.iterator(); 
           while(iterator.hasNext()) 
           { 

             Map.Entry elemsymptreemap = (Map.Entry)iterator.next(); 
             if(((String)elemsymptreemap.getKey()).equalsIgnoreCase(symplist.get(i))) 
             { 
                 done=true; 
                 break; 
             } 
           } 
         } 

       /** if number of duplications of a symtom was not calculated before (done=false), duplications are counted. the counted number is 
        * putted as a value and the corresponding symtom as a key in symptreemap */  

        if(done==false) 
        { 
          j=i; 
          count=0; 
          while(j<symplist.size()) 
          { 
            if(symplist.get(j).equalsIgnoreCase(symplist.get(i))) 
            { 
              count++; 
            } 
            j++; 
          } 
          symptreemap.put(symplist.get(i), count); 
 
        } 
       }
     } 
     return symptreemap; 
    } 

  } 

 