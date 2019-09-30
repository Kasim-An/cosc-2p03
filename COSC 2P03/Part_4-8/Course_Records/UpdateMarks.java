package Course_Records;


import BasicIO.*;


/** This class is an implementation of a mark updating program for a university
  * course. It allows the user to enter student numbers and selectively update
  * the marks for the selected students.
  *
  * @see Course
  * @see Student
  * @see MarkingScheme
  *
  * @author D. Hughes
  *
  * @version 1.0 (Jan. 2014)                                                     */

public class UpdateMarks {
    
    
    /** The constructor reads the course from the course file and allows the user
      * to select students to update marks.                                      */
    
    public UpdateMarks ( ) {
        
        BinaryDataFile     courseData;     // input file for course data
        BinaryOutputFile   newCourseData;  // output file for updated course data
        Course             aCourse;        // course being processed
        CourseForm         form;           // form for display
        MarkingScheme      scheme;         // the marking scheme
        MarkingSchemeForm  mform;          // form for MS display
        BasicForm          prompt;         // form top prompt for student number
        int                button;         // button pressed
        Student            aStudent;       // student being updated
        
        courseData = new BinaryDataFile();
        aCourse = (Course)courseData.readObject();
        courseData.close();
        form = new CourseForm(aCourse);
        if ( form.confirm() ) {
            scheme = aCourse.getScheme();
            mform = new MarkingSchemeForm(scheme);
            mform.display();
            mform.close();
            prompt = new BasicForm();
            prompt.addTextField("sn","Student #",6);
            for ( ; ; ) {
                prompt.clearAll();
                button = prompt.accept("OK","Quit");
                prompt.hide();
            if ( button == 1 ) break;
                aStudent = aCourse.getStudent(prompt.readString("sn"));
                if ( aStudent != null ) {
                    aStudent.update();
                };
            };
            newCourseData = new BinaryOutputFile();
            newCourseData.writeObject(aCourse);
            newCourseData.close();
        };
        form.close();
        
    }; // constructor
    
    
    public static void main ( String[] args ) { UpdateMarks u = new UpdateMarks(); };
    
    
} // UpdateMarks
