package Course_Records;


/** This interface represents a student in a course. A student has a student
  * number, a name and marks in a number of pieces of work. Student marks can be
  * updated and a final mark can be computed according to a marking scheme. 
  *
  * @see Course
  *
  * @author D. Hughes
  *
  * @version 1.0 (Jan. 2014)                                                     */

public interface Student {
    
    
    /** This method returns the student number of the student.
      * 
      * @return  String  the student number                                      */
    
    public String getStNum ( );
    
    
    /** This method returns the student's name.
      *
      * @return  String  the student's name                                      */
    
    public String getName ( );
    
    
    /** This method returns the student's mark in a piece of work. If a mark
      * hasn't been entered for the piece of work, it returns N_A.
      *
      * @param  num  piece of work number (from 0)
      *
      * @return  double  the student's mark                                      */
    
    public double getMark ( int num );
    
    
    /** This method returns the final grade for the student. If the final grade
      * has not yet been calculated it returns N_A.
      *
      * @return  double  the student's final grade                               */
    
    public double getFinalGrade ( );
    
    
    /** This method calculates the final grade for the student by applying the
      * course marking scheme to the student's marks.                            */
    
    
    public void calcFinalGrade( );
    
    
    /** This method updates the student's marks for the pieces of work in the
      * marking scheme for the course.                                           */
    
    public void update ( );
        
    
} // Student