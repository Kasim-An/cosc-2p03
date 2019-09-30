package Course_Records;


/** This interface represents the marking scheme for a course. A marking scheme
  * consists of a number of pieces of work each with a name, base mark and weight.
  * The marking scheme can be applied to the marks for the pieces of work for a
  * student computing a final mark.
  * 
  * @see Work
  *
  * @author D. Hughes
  *
  * @version 1.0 (Jan. 2014)                                                     */

public interface MarkingScheme {
    
    
    /** This method returns the number of pieces of work contributing to the final
      * mark.
      *
      * @return  int  number of pieces of work.                                  */
    
    public int getNumWork ( );
    
    
    /** This method returns the name for a piece of work.
      *
      * @param  num  piece of work number (from 0)
      * 
      * @return  String  name of piece of work.                                  */
    
    public String getName ( int num );
    
    
    /** This method returns the base mark for a piece of work.
      * 
      * @param  num  piece of work number (from 0)
      * 
      * @return  double  base mark.                                              */
    
    public double getBase ( int num );
    
    
    /** This method returns the weight for a piece of work.
      *
      * @param  num  piece of work number (from 0)
      * 
      * @return  double  weight.                                                 */
    
    public double getWeight ( int num );
    
    
    /** This method applies the marking scheme to marks for the student producing
      * a final mark.
      *
      * @param  theStudent  the student whose marks are to be evaluated
      *
      * @return  double  the final mark                                          */
    
    public double apply ( Student theStudent );
    
    
} // MarkingScheme
