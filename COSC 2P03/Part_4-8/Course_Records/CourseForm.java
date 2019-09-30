package Course_Records;


import BasicIO.*;
import static BasicIO.Formats.*;


/** This class represents the user interface (a form) for display course
  * information.
  * 
  * @see Course
  * 
  * @author  Dave Hughes
  * 
  * @version 1.0 (Jan. 2014)                                                     */

public class CourseForm {
    
    
    private BasicForm  display;    // form for display
    private Course     theCourse;  // course being displayed
    
    
    /** This constructor builds the form to display the course information.
      * 
      * @param  aCourse  course being displayed                                  */
    
    public CourseForm ( Course aCourse ) {
        
        display = new BasicForm();
        theCourse = aCourse;
        display.addLabel("cn",theCourse.getCourseName(),100,10);
        display.addTextField("ns","# Students",5,10,40);
        display.setEditable("ns",false);
        display.addTextField("ca","Average",getDecimalInstance(1),6,140,40);
        display.setEditable("ca",false);
        
    };  // constructor
    
    
    /** This method displays the course information to verify that the correct
      * course is being accessed.
      * 
      * @return  boolean  if user has confirmed the access to the course         */
    
    public boolean confirm ( ) {
        
        int  button;
        
        fillForm();
        button = display.accept("OK","Quit");
        display.hide();
        return button == 0;
        
    };  // confirm
    
    
    /** This method is used to display the course information for information
      * purposes.                                                                */
    
    public void display ( ) {
        
        fillForm();
        display.accept("OK");
        display.hide();
        
    };  // display
    
    
    /** This method closes the form. It should no longer be used.               */
    
    public void close ( ) {
        
        display.close();
        
    };  // close
    
    
    /** This method fills the form with the current course information.          */
    
    private void fillForm ( ) {
        
        double ave;
        
        display.writeInt("ns",theCourse.getNumStd());
        ave = theCourse.getCourseAve();
        if ( ave == -1 ) {
            display.writeString("ca","N/A");
        }
        else {
            display.writeDouble("ca",ave);
        };
        
    };  // fillForm
    
    
}  // CourseForm