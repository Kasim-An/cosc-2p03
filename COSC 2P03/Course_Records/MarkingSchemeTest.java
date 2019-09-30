package Course_Records;


import BasicIO.*;


/** This class is a test harness for the MarkingScheme implementation. It creates
  * a MarkingScheme object and a StudentStub object and then tests all methods of
  * MarkingScheme.
  *
  * @see MarkingScheme
  * @see Student
  *
  * @author D. Hughes
  *
  * @version 1.0 (Jan. 2009)                                                     */

public class MarkingSchemeTest {
    
    
    private MarkingScheme  scheme;    // object to test
    private Course         course;    // course stub for test
    private ASCIIDataFile  from;      // student data for test
    private Student        aStudent;  // student stub object for tests
    
    
    /** The constructor creates the MatkingScheme and Student stub objects.      */
    
    public MarkingSchemeTest ( ) {
        
        MarkingSchemeForm  form;  // form to display marking scheme
        double             mark;  // computed mark
        
        scheme = new MarkingSchemeImpl();
        course = new CourseStub(scheme);
        from = new ASCIIDataFile();
        aStudent = new StudentImpl(from,course);
        from.close();
        form = new MarkingSchemeForm(scheme);
        form.display();
        System.out.println("Number of pieces of work: "+scheme.getNumWork());
        for ( int i=0 ; i<scheme.getNumWork() ; i++ ) {
            System.out.println("Work["+i+"]: "+scheme.getName(i)+", "
                                     +scheme.getBase(i)+", "+scheme.getWeight(i));
        };
        aStudent.update();
        mark = scheme.apply(aStudent);
        System.out.println("Calculated mark: "+mark);
        
    }; // runTest
    
    
    public static void main ( String[] args ) { MarkingSchemeTest t = new MarkingSchemeTest(); };
    
    
} // MarkingSchemeTest
