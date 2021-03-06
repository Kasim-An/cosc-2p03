package Assign_5;


/* StudentName: Jiachao Wu  
 * 
 * Student Number:5726922
 * 
 * Date:2016/4/4  */

import java.util.*;
import BasicIO.*;
import static BasicIO.Formats.*;      

class Catalogue {
    
    
    private ReportPrinter  report;     // printer file for the report
    private Book           theBook;  //book report is about
    private Chapter aChapter;
    
    public Catalogue ( Book aBook ) {
    report = new ReportPrinter(false);
      theBook = aBook;
      initReport();
        
    }; // constructor
    

    public void writeDetailLine ( Chapter aChapter ) {
        
       
        for ( int i=0 ; i<aChapter.getNumChapter(); i++ ) {
          
          report.writeString(aChapter.getChapTitle());
          report.writeString(aChapter.getChapAuthor()); 
          report.writeInt(oddPage(aChapter.getPages()));
        }
    }; // writeDetailLine
   
    
    public int oddPage( int p ){
     
      p = aChapter.getPages();
      if (p%2==0){
        p= p+1;}
      else{ p = p+2;
      }
      return p;
    }
       
    public void close ( ) {
        
        report.close();
        
    };  // close
    
    
 
    private void initReport ( ) {
      
      report.setTitle("My Book");
   //   report.setTitle(theBook.getISBN(),"ISBN",theBook.callprice(),"Price",
   //                                  getDateInstance(),theBook.calPrice());
      report.addField("Title","Title",20);
      report.addField("author","author",20);
      report.addField("Page","Page",10);
    };  // initReport
    
    
} // Catalogue
