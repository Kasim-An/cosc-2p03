package Course_Records;


import BasicIO.*;


/** This class is an implementation of a final grade reporting program for a
  * university course. It is assumed that the course already exists, students are
  * registered in the course and marks for the pieces of work have been recorded.
  * It calculates the final marks for the students and generates a final mark
  * report.
  *
  * @see Course
  * @see Student
  *
  * @author D. Hughes
  *
  * @version 1.0 (Jan. 2014)                                                     */

public class FinalGrades {
    
    
    /** The constructor opens a course file, claculates the final grades and
      * produces a final grsade report.                                          */
    
    public FinalGrades ( ) {
        
        BinaryDataFile     oldCourseFile;  // old course data file
        Course             aCourse;        // course being processed
        BinaryOutputFile   newCourseFile;  // new course data file
        CourseForm         form;           // form for display
        FinalGradeReport   gradeReport;    // the final grade report
        
        oldCourseFile = new BinaryDataFile();
        aCourse = (Course)oldCourseFile.readObject();
        oldCourseFile.close();
        form = new CourseForm(aCourse);
        if ( form.confirm() ) {
            aCourse.calcFinalGrades();
            form.display();
            gradeReport = new FinalGradeReport(aCourse);
            for ( Student s : aCourse ) {
                gradeReport.writeDetailLine(s);
            };
            gradeReport.writeSummary();
            gradeReport.close();
            newCourseFile = new BinaryOutputFile();
            newCourseFile.writeObject(aCourse);
            newCourseFile.close();
        };
        form.close();
        
    };  // constructor
    
    
    public static void main ( String[] args ) { FinalGrades f = new FinalGrades(); };
    
    
} // FinalGrades
