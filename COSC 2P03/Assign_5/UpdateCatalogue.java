package Assign_5;

/* StudentName: Jiachao Wu  
 * 
 * Student Number:5726922
 * 
 * Date:2016/4/4  */

import BasicIO.*;


public class UpdateCatalogue {
  
  private Chapter    aChapter;
    
  public UpdateCatalogue ( ) {
    
    BinaryDataFile     bookData;     
    BinaryOutputFile   newBookData;  
    Book               aBook;       
    BookForm           form;           
    int                button1,button2;         // button pressed    
    Chapter            aChapter;      
    ChapForm           cForm;
    
    
    bookData = new BinaryDataFile();
    aBook = (Book)bookData.readObject();
    bookData.close();
    cForm = new ChapForm(aChapter);
    form = new BookForm(aBook);
   
      
      for ( ; ; ) {
        button1=form.accept();
        if ( button1==1 )break; {
        
        button2 = cForm.accept();
        if ( button2 == 1 ) break;
        
        if ( cForm.add()) {
         //aBook.readString
        };}
      
      };
      
      newBookData = new BinaryOutputFile();
      newBookData.writeObject(aBook);
      newBookData.close();
    ;
    form.close();
        
    }; // constructor
    
    
    public static void main ( String[] args ) { UpdateCatalogue u = new UpdateCatalogue(); };
    
    
} // UpdateCatalogue