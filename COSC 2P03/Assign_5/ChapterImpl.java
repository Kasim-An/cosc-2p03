package Assign_5;

/* StudentName: Jiachao Wu  
 * 
 * Student Number:5726922
 * 
 * Date:2016/4/4  */

import java.io.Serializable;

public class ChapterImpl{

   private String serialNum ;
   private String author ;
   private String title ;
   private int pages ;
   private double royalty ;
   private int  NumChap;  //number of chapters
   private double price;
   private Chapter aChapter;
   
   public ChapterImpl(){
       serialNum = null ;
       author = null ;
       title = null ;
       pages = 0 ;
       price = 0 ;
   }
   
   public String getSerialNum(){
       return serialNum ;
   }

   public int getNumChapter(){
     
     return NumChap;
   }

   public String getChapAuthor(){
       return author ;
   }
   
   public String getChapTitle(){
       return title ;
   }

   public int getPages(){
       return pages ;
   }
   public double getRoyalty(){
     return royalty;
   }

   public double calCost(){
      double price;
      int p;   // for the pages of chapter
      price = 0.25*p+aChapter.getRoyalty()*p;
      return price ;
   }


}