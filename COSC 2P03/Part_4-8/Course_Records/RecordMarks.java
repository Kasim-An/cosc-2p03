package Course_Records;


import BasicIO.*;


/** This class is an implementation of a mark recording program for a university
  * course. For each student in the course, the student information including
  * marks in each piece of work in the marking scheme is presented. The user may
  * update the marks for any/all pieces of work and the student information is
  * updated.
  *
  * @see Course
  * @see Student
  * @see MarkingScheme
  *
  * @author D. Hughes
  *
  * @version 1.0 (Jan. 2014)                                                     */

public class RecordMarks {
    
    
    /** The constructor reads the course from the course file and presents the
      * student information for update.                                          */
    
    public RecordMarks ( ) {
        
        BinaryDataFile     courseData;     // input file for course data
        BinaryOutputFile   newCourseData;  // output file for updated course data
        Course             aCourse;        // course being processed
        CourseForm         form;           // form for display
        MarkingScheme      scheme;         // the marking scheme
        MarkingSchemeForm  mform;          // form for MS display
        
        courseData = new BinaryDataFile();
        aCourse = (Course)courseData.readObject();
        courseData.close();
        form = new CourseForm(aCourse);
        scheme = aCourse.getScheme();
        if ( form.confirm() ) {
            mform = new MarkingSchemeForm(scheme);
            mform.display();
            mform.close();
            for ( Student s : aCourse ) {
                s.update();
            };
            newCourseData = new BinaryOutputFile();
            newCourseData.writeObject(aCourse);
            newCourseData.close();
        };
        form.close();
        
    };  // constructor
    
    
    public static void main ( String[] args ) { RecordMarks r = new RecordMarks(); };
    
    
} // RecordMarks
