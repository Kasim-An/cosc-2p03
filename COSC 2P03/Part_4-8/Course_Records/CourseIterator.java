package Course_Records;


import java.util.*;


/** This class defines an iterator over the students in a course as required by
  * the Iterator interface.
  * 
  * @see Course
  * @see Student
  *
  * @author D. Hughes
  *
  * @version 1.0 (Jan. 2014)                                                     */

class CourseIterator implements Iterator<Student> {
    
    
    private Student[]  theClass;  // the students of the ccourse
    private int        index;     // next student to access
    
    
    /** This constructor creates an iterator over the specified array of students
      * being the students in the course. Iteration begins at the first student in
      * the list.
      * 
      * @param  c  the array of students in the course.                          */
    
    CourseIterator ( Student[] c ) {
        
        theClass = c;
        index = 0;
        
    };  // constructor
    
    
    /** This method returns true if there is at least one more student in the
      * course.
      * 
      * @return  boolean  true if at least one more student in coruse.          */
    
    public boolean hasNext ( ) {  // from Iterator
        
        return index < theClass.length;
        
    };  // hasNext
    
    
    /** This method returns the next student in the course.
      * 
      * @return  Student  the next student in the course
      * 
      * @throws  NoSuchElementException  no students left in the course.        */
    
    public Student next ( ) {     // from Iterator
        
        if ( ! hasNext() ) {
            throw new NoSuchElementException();
        };
        index = index + 1;
        return theClass[index-1];
        
    };  // next
    
    
    /** This method is unsupported.
      * 
      * @throws  UnsupportedOpreationException  always                          */
    
    public void remove ( ) {      // from Iterator
        
        throw new UnsupportedOperationException();
        
    };  // remove
    
    
}  // CourseIterator