package Course_Records;


import java.util.*;
import BasicIO.*;
import static BasicIO.Formats.*;


/** This class represents the final mark report for a course. The report consists
  * of a header with the course name and date followed by a number of student
  * detail lines giving the final mark and then summary statistics consisting
  * of the average final mark.
  *
  * @see Course
  * @see Student
  *
  * @author D. Hughes
  *
  * @version 1.0 (Jan. 2014)                                                     */

class FinalGradeReport {
    
    
    private ReportPrinter  report;     // printer file for the report
    private Course         theCourse;  // course report is about
    
    
    /** This constructor initializes the report for a course to be sent to a
      * printer.
      *
      * @param  aCourse  course report is about                                  */
    
    public FinalGradeReport ( Course aCourse ) {
        
        report = new ReportPrinter();
        theCourse = aCourse;
        initReport();
        
    }; // constructor
    
    
    /** This method writes a report detail line for the student consisting of the
      * student number, name and final mark.
      *
      * @param  std  the student.                                                */
    
    public void writeDetailLine ( Student std ) {
        
        report.writeString(std.getStNum());
        report.writeString(std.getName());
        if ( std.getFinalGrade() == -1 ) {
            report.writeString("  N/A ");
        }
        else {
            report.writeDouble(std.getFinalGrade());
        };
        
    }; // writeDetailLine
    
    
    /** This method ends the report by displaying the summary information
      * consisting of the average final mark for the course.                     */
    
    public void writeSummary ( ) {
        
        report.writeString("stdName","Average:");
        report.writeDouble("final",theCourse.getCourseAve());
        
    }; // writeSummary
    
    
    /** This method closes the report so it will be printed.                     */
    
    public void close ( ) {
        
        report.close();
        
    };  // close
    
    
    /** This method initializes the report setting the title lines and
      * establishing fields for the student number, name and final mark.         */
    
    private void initReport ( ) {
        
        report.setTitle(theCourse.getCourseName(),"Final Marks List","Calculated: "
                                            +getDateInstance().format(new Date()));
        report.addField("stdNum","Student #");
        report.addField("stdName","Name",20);
        report.addField("final","Final",getDecimalInstance(1),6);
        
    };  // initReport
    
    
} // FinalGradeReport
