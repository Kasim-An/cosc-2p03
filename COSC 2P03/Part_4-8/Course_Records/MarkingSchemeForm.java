package Course_Records;


import BasicIO.*;


/** This class represents the user interface (form) for entry and display of
  * marking scheme information.
  * 
  * @see MarkingScheme
  * 
  * @author  Dave Hughes
  * 
  * @version 1.0 (Jan. 2014)                                                     */

class MarkingSchemeForm {
    
    
    private BasicForm      display;    // form for display
    private MarkingScheme  theScheme;  // marking scheme to display
    
    
    /** This constructor builds the form to display the marking scheme.
      * 
      * @param  aScheme  scheme being displayed.                                 */
    
    public MarkingSchemeForm ( MarkingScheme aScheme ) {
        
        int  row;  // pixel row position
        
        theScheme = aScheme;
        display = new BasicForm();
        display.addLabel("ms","Marking Scheme",95,10);
        row = 40;
        for ( int i=0 ; i<theScheme.getNumWork() ; i++ ) {
            display.addTextField("n"+i,10,10,row);
            display.addTextField("b"+i,"Base",5,100,row);
            display.addTextField("w"+i,"Weight",5,190,row);
            row = row + 30;
        };
        
    }; // constructor
    
    
    /** This method reads the specified workpiece name.
      * 
      * @param  i  workpiece number                                              */
    
    public String readName ( int i ) {
        
        return display.readString("n"+i);
        
    };  // readName
    
    
    /** This method reads the specified workpiece base.
      * 
      * @param  i  workpiece number                                              */
    
    public double readBase ( int i ) {
        
        return display.readDouble("b"+i);
        
    };  // readBase
    
    
    /** This method reads the specified workpiece weight.
      * 
      * @param  i  workpiece number                                              */
    
    public double readWeight ( int i ) {
        
        return display.readDouble("w"+i);
        
    };  // readWeight
    
    
    /** This method presents a form to allow entry of marking scheme information.
      * The fields can be read after this method is complete.                    */
    
    public void load ( ) {
        
        display.clearAll();
        display.accept("OK");
        display.hide();
        
    };  // display
    
    
    /** This method presents the marking scheme information for information
      * purposes.                                                                */
    
    public void display ( ) {
        
        fillForm();
        display.accept("OK");
        display.hide();
        
    };  // display
    
    
    /** This method closes the form. The form should no longer be used.          */
    
    public void close ( ) {
        
        display.close();
        
    };  // close
    
    
    /** This method fills the form to display the marking scheme.
      * 
      * @param  display  form to fill                                            */
    
    private void fillForm ( ) {
        
        for ( int i=0 ; i<theScheme.getNumWork() ; i++ ) {
            display.writeString("n"+i,theScheme.getName(i));
            display.setEditable("n"+i,false);
            display.writeDouble("b"+i,theScheme.getBase(i));
            display.setEditable("b"+i,false);
            display.writeDouble("w"+i,theScheme.getWeight(i));
            display.setEditable("w"+i,false);
        };
        
    }; // fillForm
    
    
};  // MarkingSchemeForm