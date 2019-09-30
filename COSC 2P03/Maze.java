import java.util.Scanner;
import java.io.*;


public class Maze{
     File inputFile;
    Scanner scan,input;
    
    
    String fileName;
    String [] puzzle;
    int width, height,depth;
    int [][] matrix;
    boolean[][] matrix1;
    int size;
    
   
  //public static void main(String[] args) throws IOException{
  public Maze()throws IOException{
    
    int count = 0;
    scan = new Scanner(System.in);
    
    for(;;){
      
      System.out.println("1. Solve suboptimally ");
      System.out.println("2. Estimate optimal solution cost ");
      System.out.println("3. Solve optimally  ");
      System.out.println("4. Enter new puzzle  ");
      System.out.println("5. Quit ");
     
      int n = scan.nextInt();
      switch (n){
        case 1:
          System.out.println("Not implemented. Use optimal instead. ");
          break;
        case 2:
          puzzle= enterPuzzle();
          break;
        case 3:
          System.out.println("Finding Solution ...");
          
          System.out.println("Optimal Path: "+ count); 
          System.out.println("Optimal Path:");
          
        
          
          break;
        case 4:
         puzzle= enterPuzzle();
         matrix = ToGraph();

              break;
        case 5:
          System.out.println("Good bye!");
          break;
        default :
          System.out.print("invaid value");
          break;
      }
      if(n==5) break;
    }   
    scan.close();
  }
  private String[] enterPuzzle()throws IOException{
    System.out.print("Enter the puzzle file name: ");
    fileName = scan.next();
    inputFile = new File(fileName);
    input = new Scanner(inputFile);
    width = input.nextInt();
    height = input.nextInt();
    depth = input.nextInt();
    input.nextLine();
    input.nextLine();
    size =height*depth;
    puzzle = new String[size];
    for(int i = 0; i<size;i++){
      if(depth==1){
        String line = input.nextLine();
        puzzle[i]=line;
      }
      else if (depth == 2){
        String line = input.nextLine();
        puzzle[i]=line;
        if(i+1==height){
          line=input.nextLine(); 
        }
      }
      else if(depth==3){
        String line = input.nextLine();
        puzzle[i]=line;
        if(i+1==height||i+1==2*height){
          line=input.nextLine();
        }
      }
    }
    System.out.println("Enter width: " + width);
    System.out.println("Enter height: " + height);
    System.out.println("Enter depth:" + depth); 
    System.out.println("Enter maze below. Only rows of with "+width+" will be accepted");
    for(int i = 0; i<size;i++){
      System.out.println(puzzle[i]);
    }
    return puzzle;
  }
  
  
  private int[][] ToGraph(){
    int puzzleHeight = puzzle.length;
    int puzzleWidth = puzzle[0].length();
    matrix1 = new boolean[puzzleHeight * puzzleWidth][puzzleHeight * puzzleWidth];
    if(depth==1){
      for (int i = 0; i < puzzleHeight; ++i) {
        for (int j = 0; j < puzzleWidth; ++j) {
          if (puzzle[i].charAt(j) == 'X')
            continue;
          if (i + 1 <puzzleHeight && puzzle[i + 1].charAt(j) != 'X'){
            int index0 = i * puzzleWidth + j;
            int index1 = (i+1) * puzzleWidth + j;
            matrix1[index0][index1] = matrix1[index1][index0]= true;
          }
          if (j + 1 <puzzleWidth && puzzle[i].charAt(j + 1) !='X'){
            int index0 = i * puzzleWidth + j;
            int index1 = i * puzzleWidth + j+1;
            matrix1[index0][index1] = matrix1[index1][index0]= true;
          }
        }
      }
    }
    if(depth>1){
      for (int i = 0; i < puzzleHeight; ++i) {
        for (int j = 0; j < puzzleWidth; ++j) {
          if (puzzle[i].charAt(j) == 'X')
            continue;
          if (i + 1 < puzzleHeight && puzzle[i + 1].charAt(j) != 'X'){
            int index0 = i * puzzleWidth + j;
            int index1 =( i+1 )* puzzleWidth + j;
            matrix1[index0][index1] = matrix1[index1][index0]= true;
          }
          if (j + 1 < puzzleWidth && puzzle[i].charAt(j + 1) != 'X'){
            int index0 = i * puzzleWidth + j;
            int index1 = i * puzzleWidth + j+1;
            matrix1[index0][index1] = matrix1[index1][index0]= true;
          }          
          if(i>height&&puzzle[i-height].charAt(j ) != 'X'){
            int index0 = i * puzzleWidth + j;
            int index1 = i * puzzleWidth + j-height*width;
            matrix1[index0][index1] = matrix1[index1][index0]= true;
          }
          if(i>2*height&&puzzle[i-height].charAt(j ) != 'X'){
            int index0 = i * puzzleWidth + j;
            int index1 = i * puzzleWidth + j-height*width;
            matrix1[index0][index1] = matrix1[index1][index0]= true;
          } 
        }
      }
    }
    matrix= new int[puzzleHeight * puzzleWidth][puzzleHeight * puzzleWidth];
    int num=0;
    for(int i =0;i<puzzleHeight * puzzleWidth;i++){
      for(int j =0;j<puzzleHeight * puzzleWidth;j++){
        if(matrix1[i][j]){
          matrix[i][j]=1;
        }
        else{
          matrix[i][j] = 0;   
        }
        num++;
        System.out.print(matrix[i][j]);
      }
      System.out.println(num);
    }
    return matrix;
  }
  /*private void findPaths(){
    enterPuzzle();
    ToGraph();
    int [][] matrix = new int [5][5];
    int [] distance = new int [5];
    int [] visted = new int [5];
    int [] preD = new int [5];
    int min;
    int nextNode = 0;
    
    System.out.println("Enter the matrix");
    
    for (int i = 0; i < 5;i++){
      visted[i]=0;
      preD[i] = 0;
      for (int j = 0;j < 5;j++){
        matrix[i][j] = scan.nextInt();
        if(matrix[i][j]==0)
          matrix[i][j]=999;
      }
    }
    distance = matrix[0];
    distance[0] = 0;
    visted[0]=1;
    //start with algorthm
    
    for(int i = 0;i<5;i++){
      min =999;
      for(int j = 0;j<5;j++){
        if (min>distance[j]&&visted[j]!=1){
          min = distance[j];
          nextNode = j;
        }
      }
      visted[nextNode]=1;
      //actual start of the algorithm
      for(int c = 0;c<5;c++){
        if(visted[c]!=1){
          if(min + matrix[nextNode][c]<distance[c]){
            distance [c] = min + matrix[nextNode][c];
            preD[c] = nextNode;
          }
        }
      }
    }
    for(int i = 0;i<5;i++){
      System.out.print("|"+distance[i]);
    }
    System.out.print("|");
    for(int i = 0;i<5;i++){
      int j ;
      System.out.print("path = "+i);
      j =i;
      do{
        j = preD[j];
        System.out.println("<-"+j);
      }while (j!=0);
      System.out.println();
    }  

        
    
}*/
  public static void main(String[] args)throws IOException{ Maze m = new Maze();}
    
  
}
