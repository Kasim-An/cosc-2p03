package Course_Records;


import java.util.*;
import BasicIO.*;
import static BasicIO.Formats.*;


/** This class represents a mark report for a course. The report consists of a
  * header followed by a number of student detail lines followed by summary
  * information. The header gives the course name and report date. The detail
  * lines give student number, name, marks for each piece of work and final grade.
  * The summary gives the average mark in each piece of work and average final
  * grade.
  *
  * @see Student
  * @see Course
  * @see MarkingScheme
  *
  * @author D. Hughes
  *
  * @version 1.0 (Jan. 2014)                                                     */


class MarkReport {
    
    
    private ReportPrinter  report;     // printer file for the report
    private Course         theCourse;  // course report is about
    private int            numMarks;   // number of mark fields
    private double[]       total;      // mark totals for each piece of work
    private int[]          num;        // number of marks for piece of work
    private double         totFinal;   // total of final marks
    private int            numFinal;   // number of final marks
    
    
    /** This constructor initializes the report, setting the title, initializing
      * the counts and setting the fields.
      *
      * @param  aCourse  course report is for                                    */
    
    public MarkReport ( Course aCourse ) {
        
        report = new ReportPrinter(false);
        theCourse = aCourse;
        numMarks = aCourse.getScheme().getNumWork();
        total = new double[numMarks];
        num = new int[numMarks];
        for ( int i=0 ; i<numMarks ; i++ ) {
            total[i] = 0;
            num[i] = 0;
        };
        totFinal = 0;
        numFinal = 0;
        initReport();
        
    }; // constructor
    
    
    /** This method writes a report detail line for the student including the
      * student number, name, mark for each piece of work and final grade. It
      * also accumulates the mark totals and counts for each piece of work and
      * final grades.
      *
      * @param  std  the student.                                                */
    
    public void writeDetailLine ( Student std ) {
        
        report.writeString(std.getStNum());
        report.writeString(std.getName());
        for ( int i=0 ; i<numMarks ; i++ ) {
            if ( std.getMark(i) == -1 ) {
                report.writeString("  N/A ");
            }
            else {
                report.writeDouble(std.getMark(i));
                total[i] = total[i] + std.getMark(i);
                num[i] = num[i] + 1;
            };
        };
        if ( std.getFinalGrade() == -1 ) {
            report.writeString("  N/A ");
        }
        else {
            report.writeDouble(std.getFinalGrade());
            totFinal = totFinal + std.getFinalGrade();
            numFinal = numFinal + 1;
        };
        
    }; // writeDetailLine
    
    
    /** This method ends the report by displaying the summary information
      * including the averages for each piece of work and the average final
      * grade for the students listed.                                           */
    
    public void writeSummary ( ) {
        
        report.writeString("stdName","Average:");
        for ( int i=0 ; i<numMarks ; i++ ) {
            if ( num[i] == 0 ) {
                report.writeString("  N/A ");
            }
            else {
                report.writeDouble(total[i]/num[i]);
            };
        };
        if ( numFinal == 0 ) {
            report.writeString("  N/A ");
        }
        else {
            report.writeDouble(totFinal/numFinal);
        };
        
    }; // writeSummary
    
    
    /** This method closes the report so it can be printed. There should be no
      * further use of the report.                                               */
    
    public void close ( ) {
        
        report.close();
        
    };  // close
    
    
    /** This method initializes the report, setting the title to include the course
      * name and report date and the detail lines to include the marks for each
      * piece of work and the final mark.                                        */
    
    private void initReport ( ) {
        
        MarkingScheme  scheme;  // the marking scheme for the course
        
        scheme = theCourse.getScheme();
        report.setTitle(theCourse.getCourseName(),"Marks List",
                                                 getDateInstance().format(new Date()));
        report.addField("stdNum","Student #");
        report.addField("stdName","Name",18);
        for ( int i=0 ; i<numMarks ; i++ ) {
            report.addField("w"+i,scheme.getName(i),getDecimalInstance(1),8);
        };
        report.addField("final","Final",getDecimalInstance(1),6);
        
    };  // initReport
    
    
} // MarkReport
