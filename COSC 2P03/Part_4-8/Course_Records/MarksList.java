package Course_Records;


import BasicIO.*;


/** This class is an implementation of a mark report generator for a university
  * course.
  *
  * @see Course
  * @see Student
  * @see MarkReport
  *
  * @author D. Hughes
  *
  * @version 1.0 (Jan. 2014)                                                     */

public class MarksList {
    
    
    /** The constructor opens a course file and generates the course mark report.*/
    
    public MarksList ( ) {
        
        BinaryDataFile   courseData;  // input file for course data
        Course           aCourse;     // course being processed
        CourseForm       form;        // form for display
        MarkReport       markReport;  // the mark report
        int              button;      // button for response
        
        courseData = new BinaryDataFile();
        aCourse = (Course)courseData.readObject();
        courseData.close();
        form = new CourseForm(aCourse);
        if ( form.confirm() ) {
            markReport = new MarkReport(aCourse);
            for ( Student s : aCourse ) {
                markReport.writeDetailLine(s);
            };
            markReport.writeSummary();
            markReport.close();
        };
        form.close();
        
    }; // constructor
    
    
    public static void main ( String[] args ) { MarksList m = new MarksList(); };
    
    
} // MarksList
