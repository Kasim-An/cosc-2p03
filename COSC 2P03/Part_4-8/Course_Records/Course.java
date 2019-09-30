package Course_Records;


/** This interface represents a course offering with the associated students. A
  * course has a marking scheme and a class average.
  * 
  * @see Student
  * @see MarkingScheme
  *
  * @author D. Hughes
  *
  * @version 1.0 (Jan. 2014)                                                     */

public interface Course extends Iterable<Student> {
    
    
    /** This method returns an iterator over the students in the course.
      * 
      * @return  Iterator  an iterator over the students in the course.          */
    
//  public Iterator<Student> iterator ( ) ;  // from Iterable
    
    
    /** This method returns the name of the course.
      *
      * @return  String  the course name.                                        */
    
    public String getCourseName ( );
    
    
    /** This method returns the marking scheme for the course.
      *
      * @return  MarkingScheme  the course marking scheme.                       */
    
    public MarkingScheme getScheme ( );
    
    
    /** This method returns the number of students in the course.
      *
      * @return  int  the number of students.                                    */
    
    public int getNumStd ( );
    
    
    /** This method returns the average final mark in the course if it has been
      * computed, otehrwise it returns -1.
      *
      * @return  double  the course average.                                     */
    
    public double getCourseAve ( );
    
    
    /** This method returns a student in the class by student number.
      * 
      * @param  stNum  the student number to search.
      * 
      * @return  Student  the student or null if not found.                      */
    
    public Student getStudent ( String stNum ) ;
    
    
    /** This method calculates the final mark for the students in the course and
      * computes the course average.                                             */
    
    public void calcFinalGrades ( ) ;
    
    
} // Course
