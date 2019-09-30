package Course_Records;


import java.io.*;


/** This class represents a piece of work in the marking scheme for a course.
  * A piece of work has a name, a base mark and a weight.
  *
  * @author D. Hughes
  *
  * @version 1.0 (Jan. 2014)                                                     */

public class WorkImpl implements Work, Serializable {
    
    
    private static final long  serialVersionUID = 99990004L;
    
    private String  name;    // name of piece of work
    private double  base;    // base of piece of work
    private double  weight;  // weight of piece of work
    
    
    /** This constructor creates a new piece of work with specified name, base mark
      * and weight.
      *
      * @param  n  piece of work name
      * @param  b  base mark
      * @param  w  weight                                                        */
    
    public WorkImpl ( String n, double b, double w ) {
        
        name = n;
        base = b;
        weight = w;
        
    }; // constructor
    
    
    /** This method returns the name of the piece of work.
      *
      * @return  String  piece of work name                                      */
    
    public String getName ( ) {
        
        return name;
        
    }; // getName
    
    
    /** This method returns the base mark of the piece of work.
      *
      * @return  double  base mark                                               */
    
    public double getBase ( ) {
        
        return base;
        
    }; // getBase
    
    
    /** This method returns the weight of the piece of work.
      *
      * @return  double  weight                                                  */
    
    public double getWeight ( ) {
        
        return weight;
        
    }; // getWeight
    
    
    /** This method sets the base mark of the piece of work.
      *
      * @param  b  base mark                                                     */
    
    public void setBase ( double b ) {
        
        base = b;
        
    }; // setBase
    
    
    /** This method sets the weight of the piece of work.
      *
      * @param  w  weight                                                        */
    
    public void setWeight ( double w ) {
        
        weight = w;
        
    }; // setWeight
    
    
} // Work