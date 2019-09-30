//package Assign5;


import BasicIO.*;
import static BasicIO.Formats.*;


public class Catalogue{
    
    
    private ASCIIDataFile    accountFile;
  //  private ASCIIPrompter   prompt;
    private ReportPrinter    out;
    private BasicForm formchapter;
    private BasicForm formserial;
    
    public Catalogue ( ) {
        
        Account  anAcct;
        String isbn;
        double   previous;
        int   pagenumber;
        int  fee;
        int buttonchapter,buttonserial;
        
        accountFile = new ASCIIDataFile();
        prompt = new ASCIIPrompter();
        out = new ReportPrinter();
        formchapter=new BasicForm("Add Chapter","Done");
        formserial=new BasicForm("Add","Skip");
        isbn=prompt.in
        setupForm1();
        setUpReport();
        fee = 0;
        anAcct = new Account(accountFile);
        int totalchapter=anAcct.nextInt();
        for ( int i=1;1<=totalchapter ;i++ ) {
            
            buttonchapter=formchapter.accept();
            buttonserial=formserial.accept();
            for(;;){
            if ( buttonchapter==1) break;{
              setupForm2();
              if (buttonserial==1)break;{
              
              }
            }}
        
        pagenumber=pagenumber+anAcct.getPage();
        fee=fee+anAcct.getPage()*anAcct.getrate()+anAcct.getPage()*0.25;
        
            
            writeDetail(anAcct,previous,bill);
            anAcct.write(newAccountFile);
            
        };
       
        
       
        
        
        writeSummary(totBilled);
        accountFile.close();
        newAccountFile.close();
        out.close();
        
    };  // construtor
    
    
    private void setUpReport ( ) {
        
        out.setTitle("My Book");
        out.addField("isbn","ISBN",15);
        out.addField("price","Price",20);
        out.addField("chapter","Chapter",20);
        out.addField("title","Title",8);
        out.addField("author","Author",8);
        out.addField("page","Page",10);
        
    };  // setUpReport
    
    private void setupForm1(){
    formchapter.addTextField("isbn","ISBN",10,10,10);
    formchapter.addTextField("title","Title",10,20,20);
    formchapter.addTextField("chapter","Chapter",false,10,30,5);
    formchapter.addTextField("page","Page",false,10,40,5);
    formchapter.addTextField("cost","Cost",false,10,50,5);}
    private void setupForm2(){
    formserial.addTextField("serial","Serial#",10,10,10);
    formserial.addTextField("title","Title",false,10,20,20);
    formserial.addTextField("author","Author",false,10,30,20);
    formserial.addTextField("page","Page",false,10,40,5);
    }
    
    private void writeDetail ( Account anAcct, String isbn, int pagenumber ) {
        
        out.writeString("isbn",isbn);
        out.writeInt("chapter",anAcct.getChapter());
        out.writeString("title",anAcct.getTitle());
        out.writeString("author",anAcct.getAuthor());
        out.writeInt("page",pagenumber);
        };  // writeDetailLine
    
    
    private void writeSummary ( String isbnnumber, double fee ) {
        
        out.writeString("isbn",isbnnumber);
        out.writeDouble("price",fee);
        
    };  // writeSummary
    
    
    public static void main ( String[] args ) { Catalogue b = new Catalogue(); };
    
    
}  // Catalogue
