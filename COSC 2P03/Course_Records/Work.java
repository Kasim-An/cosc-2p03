package Course_Records;


/** This interface represents a piece of work in the marking scheme for a course.
  * A piece of work has a name, a base mark and a weight.
  *
  * @author D. Hughes
  *
  * @version 1.0 (Jan. 2014)                                                     */

public interface Work {
    
    
    /** This method returns the name of the piece of work.
      *
      * @return  String  piece of work name                                      */
    
    public String getName ( );
    
    
    /** This method returns the base mark of the piece of work.
      *
      * @return  double  base mark                                               */
    
    public double getBase ( );
    
    
    /** This method returns the weight of the piece of work.
      *
      * @return  double  weight                                                  */
    
    public double getWeight ( );
    
    
    /** This method sets the base mark of the piece of work.
      *
      * @param  b  base mark                                                     */
    
    public void setBase ( double b );
    
    
    /** This method sets the weight of the piece of work.
      *
      * @param  w  weight                                                        */
    
    public void setWeight ( double w );
    
    
} // Work