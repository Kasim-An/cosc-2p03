package Assign_5;

/* StudentName: Jiachao Wu  
 * 
 * Student Number:5726922
 * 
 * Date:2016/4/4  */

import java.io.*;
import java.util.*;
import BasicIO.*;   


public class BookImpl  implements Serializable{
  private String ISBN ;
  private String title ;
  private int NoChapters ;
  private int pages ;
  private double price ;
  private double totPrice;
  private Chapter aChapter;
  
  
  public BookImpl(){
    ISBN = null ;
    title = null ;
    NoChapters = 0 ;
    pages = 0 ;
    price = 0 ;
   
  }
    
  public String getISBN(){
    return ISBN ;
  }
    
    public String getTitle(){
      return title ;
    }

    public int getNoChapters(){
      return NoChapters ;
    }
    
    public int getPages(){
      return pages ;
    }
    
    public double calPrice(){
      for(int i=0 ; i<aChapter.getNumChapter();i++){
        totPrice = totPrice+aChapter.calCost();
      }
      return totPrice;
    }
    
    public Chapter getChapter(int i){
      return aChapter;
    }


} // BookImpl