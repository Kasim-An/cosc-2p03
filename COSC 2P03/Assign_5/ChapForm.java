package Assign_5;

/* StudentName: Jiachao Wu  
 * 
 * Student Number:5726922
 * 
 * Date:2016/4/4  */


import BasicIO.*;



class ChapForm {
    
    
    private BasicForm  display;     // form for display
    private Book    theBook;   // student being displayed
    private Chapter aChapter;
    public ChapForm ( Chapter aChapter ) {
      
      display = new BasicForm("Add","Skip");

      
      display.addTextField("serial","serial #",5,10,40);
      display.addTextField("ChapTitle","Title",6,140,40);
      display.setEditable("chap",false);
      display.addTextField("author","author",6,160,40);
      display.setEditable("chap",false);
      display.addTextField("Pages","Pages",6,180,40);
      display.setEditable("Pages",false);
    };  // constructor
    
    public int accept(){
      int a;
    a=display.accept();
    return a;
    }
  
    public String readSerialNum( ) {
        
        String a;
        a=display.readString("serial");
        return a;
        
    };  // readMark
    
    
   
    
    public boolean add ( ) {
        
        int  button;  // button pressed
        
        fillForm();
        button = display.accept("Add","Skip");
        display.hide();
        return button == 0;
        
    };  // update
    
    
    /** This method closes the form. The form should no longer be used.          */
    
    public void close ( ) {
        
        display.close();
        
    };  // close
    
    
    /** This method fills the form to display the Chapter information.
      * 
      * @param  chapter being displayed                                 */
    
    private void fillForm ( ) {
        String serial;
        String ChapTitle;
        String author;
        int NumPages;
        
        serial = aChapter.getSerialNum();
        ChapTitle = aChapter.getChapTitle();
        author = aChapter.getChapAuthor();
        NumPages = aChapter.getPages();
    

    }; // fillForm
    
    
}  // ChapForm