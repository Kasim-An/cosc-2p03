package Course_Records;


import java.io.*;
import BasicIO.*;


/** This class represents the marking scheme for a course. A marking scheme
  * consists of a number of pieces of work each with a name, base mark and weight.
  * The marking scheme can be applied to the marks for the pieces of work for a
  * student computing a final mark.
  *
  * @see Work
  *
  * @author D. Hughes
  *
  * @version 1.0 (Jan. 2014)                                                     */

public class MarkingSchemeImpl implements MarkingScheme, Serializable {
    
    
    private static final long  serialVersionUID = 99990002L;

    private Work[]  workPieces;  // pieces of work 
    
    
    /** This constructor creates the marking scheme reading the bases and weights
      * from a form.                                                             */
    
    public MarkingSchemeImpl ( ) {
        
        BasicForm          prompt;   // form to prompt for # pieces of work
        MarkingSchemeForm  form;     // form to load marking scheme
        int                numWork;  // number of pieces of work
        
        prompt = new BasicForm();
        prompt.addTextField("nw","# Pieces of Work:",3);
        prompt.accept();
        numWork = prompt.readInt();
        prompt.close();
        workPieces = new Work[numWork];
        form = new MarkingSchemeForm(this);
        load(form);
        form.close();
        
    }; // constructor
    
    
    /** This method returns the number of pieces of work contributing to the final
      * mark.
      *
      * @return  int  number of pieces of work.                                  */
    
    public int getNumWork ( ) {
        
        return workPieces.length;
        
    }; // getNumWork
    
    
    /** This method returns the name for a piece of work.
      *
      * @param  num  piece of work number (from 0)
      * 
      * @return  String  name of piece of work.                                 */
    
    public String getName ( int num ) {
        
        return workPieces[num].getName();
        
    };  // getName
    
    
    /** This method returns the base mark for a piece of work.
      * 
      * @param  num  piece of work number (from 0)
      * 
      * @return  double  base mark.                                              */
    
    public double getBase ( int num ) {
        
        return workPieces[num].getBase();
        
    }; // getBase
    
    
    /** This method returns the weight for a piece of work.
      *
      * @param  i  piece of work number (from 0)
      * 
      * @return  double  weight.                                                 */
    
    public double getWeight ( int num ) {
        
        return workPieces[num].getWeight();
        
    }; // getWeight
    
    
    /** This method applies the marking scheme to marks for the student producing
      * a final mark. The final mark is the sum of the scaled, weighted marks on
      * the pieces of work.
      *
      * @param  theStudent  the student whose marks are to be evaluated
      *
      * @return  double  the final mark                                          */
    
    public double apply ( Student theStudent ) {
        
        double  result;  // computed final mark
        double  mark;    // mark in a piece of work
        
        result = 0;
        for ( int i=0 ; i<workPieces.length ; i++ ) {
            mark = theStudent.getMark(i);
            if ( mark == -1 ) {
                mark = 0;
            };
            result = result + mark / workPieces[i].getBase()
                                                      * workPieces[i].getWeight();
        };
        return result;
        
    }; // apply
    
    
    /** This method loads the marking scheme from the form.
      * 
      * @param  form  form to load from                                          */
    
    private void load ( MarkingSchemeForm form ) {
        
        String  workName;    // name of piece of work
        double  workBase;    // base for piece of work
        double  workWeight;  // weight for piece of work
        
        form.load();
        for ( int i=0 ; i<workPieces.length ; i++ ) {
            workName = form.readName(i);
            workBase = form.readBase(i);
            workWeight = form.readWeight(i);
            workPieces[i] = new WorkImpl(workName,workBase,workWeight);
        };
        
    }; // load
    
    
} // MarkingSchemeImpl
