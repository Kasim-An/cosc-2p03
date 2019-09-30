package Assign_5;


/* StudentName: Jiachao Wu  
 * 
 * Student Number:5726922
 * 
 * Date:2016/4/4  */

import java.util.*;


class BookIterator implements Iterator<Chapter> {
    
    
    private Chapter[]  theChapter;  
    private int        index;   
     
    BookIterator ( Chapter[] c ) {
        
        theChapter = c;
        index = 0;
        
    };  // constructor
    

    
    public boolean hasNext ( ) {  // from Iterator
        
        return index < theChapter.length;
        
    };  // hasNext
    

    public Chapter next ( ) {     // from Iterator
        
        if ( ! hasNext() ) {
            throw new NoSuchElementException();
        };
        index = index + 1;
        return theChapter[index-1];
        
    };  // next
    

    
    public void remove ( ) {      // from Iterator
        
        throw new UnsupportedOperationException();
        
    };  // remove
    
    
}  // BookIterator