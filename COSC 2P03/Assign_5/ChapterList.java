package Assign_5;

/* StudentName: Jiachao Wu  
 * 
 * Student Number:5726922
 * 
 * Date:2016/4/4  */

import BasicIO.*;



public class ChapterList {
    
    private Catalogue theCatalogue;
    private Chapter aChapter;
    public ChapterList ( ) {
        
        BinaryDataFile   chapterData;  // input file for chapter data
        Book             aBook;     // chapter being processed
        BookForm         form;        // form for display
        PrintBook        PrintBook;   
        int              button;      // button for response
        
        chapterData = new BinaryDataFile();
        aBook = (Book)chapterData.readObject();
        chapterData.close();
        form = new BookForm(aBook);
        if ( form.confirm() ) {
            theCatalogue = new Catalogue(aBook);
            for ( Chapter c : aBook ) {
                theCatalogue.writeDetailLine(aChapter);
            };
            theCatalogue.close();
        };
        form.close();
        
    }; // constructor
    
    
    public static void main ( String[] args ) { ChapterList m = new ChapterList(); };
    
    
} // ChapterList
