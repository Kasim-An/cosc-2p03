package Assign_5;

/* StudentName: Jiachao Wu  
 * 
 * Student Number:5726922
 * 
 * Date:2016/4/4  */


public interface Book extends Iterable<Chapter>{
    
    
    public String getISBN();
    
    public String getBookTitle ( );
   
                    
    public int getNumChap ( );
    
    
    public Chapter getChapter();
    
    
    public int getPageS();
   
    
    public Double calPrice();
    
    
} // Book
