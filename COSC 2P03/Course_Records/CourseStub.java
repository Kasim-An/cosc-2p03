package Course_Records;
import java.util.*;

public class CourseStub implements Course {
    
    private MarkingScheme scheme;
    
    public CourseStub ( MarkingScheme m ) {
        scheme = m;
    };
    
    public Iterator<Student> iterator ( ) {
        return null;
    };
    
    public String getCourseName ( ) {
        System.out.println("Course.getCourseName() returned A Course");
        return "A Course";
    };
    
    public MarkingScheme getScheme ( ) {
        System.out.println("Course.getScheme() returned "+scheme);
        return scheme ;
    };
    
    public int getNumStd ( ) {
        System.out.println("Course.getNumStd() returned 1");
        return 1;
    };
    
    public double getCourseAve ( ) {
        System.out.println("Course.getCourseAve() returned -1");
        return -1;
    }
    
    public Student getStudent ( String stNum ) {
        System.out.println("Course.getStudent("+stNum+") returned null");
        return null;
    };
    
    public void calcFinalGrades ( ) {
        System.out.println("Course.calcFinalGrades() called");
    };
    
} // Course
