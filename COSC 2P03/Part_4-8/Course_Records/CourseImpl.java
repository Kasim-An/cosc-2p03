package Course_Records;


import java.io.*;
import java.util.*;
import BasicIO.*;


/** This interface represents a course offering with the associated students. A
  * course has a marking scheme and a class average.
  * 
  * @see Student
  * @see MarkingScheme
  *
  * @author D. Hughes
  *
  * @version 1.0 (Jan. 2014)                                                     */

public class CourseImpl implements Course, Serializable {
    
    
    private static final long  serialVersionUID = 99990001L;
    
    private String         courseName;  // name of course
    private MarkingScheme  scheme;      // marking scheme for course
    private Student[]      theClass;    // students in course
    private double         courseAve;   // average mark in course
    
    
    /** The constructor creates a new course, filling in the marking scheme
      * and loading the student list.                                            */
    
    public CourseImpl ( String cn, ASCIIDataFile classList ) {
        
        courseName = cn;
        scheme = new MarkingSchemeImpl();
        loadStudents(classList);
        courseAve = -1;
        
    }; // constructor
    
    
    /** This method returns an iterator over the students in the course. It is
      * required by the Iterable interface.
      * 
      * @return  Iterator  an iterator over the students in the course.         */
    
    public Iterator<Student> iterator ( ) {  // from Iterable
        
        return new CourseIterator(theClass);
        
    };  // iterator
    
    
    /** This method returns the name of the course.
      *
      * @return  String  the course name.                                        */
    
    public String getCourseName ( ) {
        
        return courseName;
        
    }; // getCourseName
    
    
    /** This method returns the marking scheme for the course.
      *
      * @return  MarkingScheme  the course marking scheme.                       */
    
    public MarkingScheme getScheme ( ) {
        
        return scheme;
        
    }; // getScheme
    
    
    /** This method returns the number of students in the course.
      *
      * @return  int  the number of students.                                    */
    
    public int getNumStd ( ) {
        
        return theClass.length;
        
    }; // getNumStd
    
    
    /** This method returns the average final mark in the course if it has been
      * computed, otehrwise it returns -1.
      *
      * @return  double  the course average.                                     */
    
    public double getCourseAve ( ) {
        
        return courseAve;
        
    }; // getCourseAve
    
    
    /** This method returns a student in the class by student number.
      * 
      * @param  stNum  the student number to search.
      * 
      * @return  Student  the student or null if not found.                      */
    
    public Student getStudent ( String stNum ) {
        
        int i;
        
        i = 0;
        while ( i<theClass.length
                && theClass[i].getStNum().compareTo(stNum) != 0 ) {
            i = i + 1;
        };
        if ( i<theClass.length ) {
            return theClass[i];
        }
        else {
            return null;
        }
        
    };  // getStudent
    
    
    /** This method calculates the final mark for the students in the course and
      * computes the course average.                                             */
    
    public void calcFinalGrades ( ) {
        
        double totMark;    // total of students' marks
        
        totMark = 0;
        for ( Student s : theClass ) {
            s.calcFinalGrade();
            totMark = totMark + s.getFinalGrade();
        };
        courseAve = totMark/getNumStd();
        
    };  // calcFinalGrades
    
    
    /** This method loads the student names & numbers from the classlist file and
      * creates the list of students in the course.
      *
      * @param  classList  the class list file of student names and numbers.     */
    
    private void loadStudents ( ASCIIDataFile classList ) {
        
        int  numStd;
        
        numStd = classList.readInt();
        theClass = new Student[numStd];
        for ( int i=0 ; i<numStd ; i++ ) {
            theClass[i]= new StudentImpl(classList,this);
        };
        classList.close();
        
    };  // loadStudents
    
    
} // CourseImpl