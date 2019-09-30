//Xinan Wang
//5535802
package assignment4;

import java.util.*;
public class maze
{ 
  static int num1,num2,num3,num4;
  static int width,height,depth,reach;
  static char[][] a,b,c;
  static int path;
  static int minFoundLen=Integer.MAX_VALUE;
  static String record;
  static boolean find;
  static int[][] way;
  static Scanner sc = new Scanner(System.in);
  
  public static void main(String[] ar)
    { 
    System.out.println("Enter width: ");
    width = sc.nextInt();
    System.out.println("Enter height: ");
    height = sc.nextInt();
    System.out.println("Enter depth: ");
    depth = sc.nextInt();
        input(depth);
        for(;;){
          
          System.out.println("1. Solve suboptimally ");
          System.out.println("2. Estimate optimal solution cost ");
          System.out.println("3. Solve optimally  ");
          System.out.println("4. Enter new puzzle  ");
          System.out.println("5. Quit ");
          walk(a,num1,num2,num3,num4,path);
          
          int k = sc.nextInt();
          switch (k){
            case 1:
              System.out.println("Not implemented. Use optimal instead. ");
              break;
            case 2:
              if(find)
            {System.out.println("Optimal Path Cost:"+minFoundLen);
              minFoundLen=0;}
              else
                System.out.println("Optimal Path Cost: 0");
              break;
            case 3:
              System.out.println("Finding Solution ...");
              if(find)
              {System.out.println(find);
                System.out.println("Optimal Path: "+ record); }
              else
              {System.out.println(find);
                System.out.println("Exit not reachable.");}
              switch(depth){
                case 1:
                {for(int j = 0; j < height; j++)
                  {
                  for(int i = 0; i < width; i++)
                  {
                    System.out.printf(a[i][j]+" ");
                  }System.out.println();
                }break;}
                case 2:
                {for(int j = 0; j < height; j++)
                  {
                  for(int i = 0; i < width; i++)
                  {
                    System.out.printf(a[i][j]+" ");
                  }System.out.println();
                }
                for(int j = 0; j < height; j++)
                {
                  for(int i = 0; i < width; i++)
                  {
                    System.out.printf(b[i][j]+" ");
                  }System.out.println();
                }break;}
                case 3:
                {for(int j = 0; j < height; j++)
                  {
                  for(int i = 0; i < width; i++)
                  {
                    System.out.printf(a[i][j]+" ");
                  }System.out.println();
                }
                for(int j = 0; j < height; j++)
                {
                  for(int i = 0; i < width; i++)
                  {
                    System.out.printf(b[i][j]+" ");
                  }System.out.println();
                }for(int j = 0; j < height; j++)
                {
                  for(int i = 0; i < width; i++)
                  {
                    System.out.printf(c[i][j]+" ");
                  }System.out.println();
                }break;}}     
              break;
            case 4:
              System.out.println("Enter width: ");
              width = sc.nextInt();
              System.out.println("Enter height: ");
              height = sc.nextInt();
              System.out.println("Enter depth: ");
              depth = sc.nextInt();
              input(depth);
              break;
            case 5:
              System.out.println("Good bye!");
              break;
            default :
              System.out.print("invaid value");
              break;
          }
          if(k==5) break;
    } 
    }
  public static void walk(char[][] a,int i, int j,int s,int t,int steps)
  {
    if(!exist(i,j) || a[i][j] == 'X')
      return;
    if(i==s&&j==t)
    {minFoundLen=Math.min(minFoundLen,steps);
      return;}
    if((Math.abs(i-s)+Math.abs(j-t))>steps)
    {find=false;
    }
    else
      find=true;
    a[i][j] = 'X';
    // help.east(a,i+1,j,s,t,steps,record);
    walk(a,i+1,j,s,t,steps+1);
    walk(a,i-1,j,s,t,steps+1);
    walk(a,i,j+1,s,t,steps+1);
    walk(a,i,j-1,s,t,steps+1);
    /*if(((a[i+1][j]=='X')&&(a[i-1][j]=='X')&&(a[i][j+1]=='X')&&(a[i][j-1]=='X'))&&!exist(i,j))
    {
      if(b[i][j]!='X')
      {
        walk(b,i,j,s,t,steps+1);
      }}*/
    // a[i][j] = 'O';
  }
  public static void input(int depth){
    switch(depth){
      case 1:
      {System.out.println("Enter maze below. Only rows of width 8 will be accepted.");
        a = new char[width][height];
        for(int j = 0; j < height; j++)
        {
          for(int i = 0; i < width; i++)
          {
            a[i][j] = sc.next().charAt(0);
          }
        }
        for(int m=0;m<a.length;m++){
          for(int n=0;n<a[m].length;n++){
            if(a[m][n]=='S')
            {
              num1=m;
              num2=n;
              //System.out.println(num1);
              //System.out.println(num2);
              break;}
          }
        }
        for(int m=0;m<a.length;m++){
          for(int n=0;n<a[m].length;n++){
            if(a[m][n]=='E')
            {num3=m;
              num4=n;
              //System.out.println(num3);
              //System.out.println(num4);
              break;}
          }}break;}
      case 2:{
        for(int dep=0;dep<depth;dep++){
          //deeeeeeeeepth(dep);
          if(dep==1){
            b=a;
          }
          if(dep==2){
            c=b;
            b=a;
          }
          System.out.println("Enter maze below. Only rows of width 8 will be accepted.");
          a = new char[width][height];
          for(int j = 0; j < height; j++)
          {
            for(int i = 0; i < width; i++)
            {
              a[i][j] = sc.next().charAt(0);
            }
          }
         /* num1=findS1(a);
          num2=findS2(a);
          num1=findS1(b);
          num2=findS2(b);
          num3=findE1(a);
          num4=findE2(a);
          num3=findE1(b);
          num4=findE2(b);*/}break;
      }
      case 3:
      {for(int dep=0;dep<depth;dep++){
        //deeeeeeeeepth(dep);          
        if(dep==1){
          b=a;
        }
          if(dep==2){
            c=b;
            b=a;
          }
          System.out.println("Enter maze below. Only rows of width 8 will be accepted.");
          a = new char[width][height];   
          
          for(int j = 0; j < height; j++)
          {
            for(int i = 0; i < width; i++)
            {
              a[i][j] = sc.next().charAt(0);
            }
          }
         /* num1=findS1(a);
          num2=findS2(a);
          num1=findS1(b);
          num2=findS2(b);
          num1=findS1(c);
          num2=findS2(c);
          num3=findE1(a);
          num4=findE2(a);
          num3=findE1(b);
          num4=findE2(b);
          num3=findE1(c);
          num4=findE2(c);*/
      }break;
      }}}
  public static int tograph(char[][]a,int i,int j){
    if((a[i+1][j]!='X')&(a[i-1][j]!='X')&(a[i][j+1]!='X')&(a[i][j-1]!='X'))
      reach=1;
    return reach;
  }    
  public static void calculate(char[][]a,int i,int j){
    for(int reachy=0;reachy<width*height;reachy++){
      for(int reachx=0;reachx<width*height;reachx++){
        way[reachx][reachy]=tograph(a,i,j);
      }
    }
  }
  public static boolean exist(int i, int j)
  {
    return i>=0 && j >=0 && i < width && j < height;
    }
 /* public static int findS1(char[][] a){
    for(int m=0;m<a.length;m++){
            for(int n=0;n<a[m].length;n++){
              if(a[m][n]=='S')
              {
                num1=m;
                num2=n;
                //System.out.println(num1);
                //System.out.println(num2);                
                break;}
            }
          }return num1;
  }
  public static int findS2(char[][] a){
    for(int m=0;m<a.length;m++){
            for(int n=0;n<a[m].length;n++){
              if(a[m][n]=='S')
              {
                num1=m;
                num2=n;
                //System.out.println(num1);
                //System.out.println(num2);                
                break;}
            }
          }return num2;
  }
  public static int findE1(char[][] a){
    for(int m=0;m<a.length;m++){
            for(int n=0;n<a[m].length;n++){
              if(a[m][n]=='E')
              {
                num3=m;
                num4=n;
                //System.out.println(num1);
                //System.out.println(num2);                
                break;}
            }
          }return num3;
  }
  public static int findE2(char[][] a){
    for(int m=0;m<a.length;m++){
            for(int n=0;n<a[m].length;n++){
              if(a[m][n]=='E')
              {
                num3=m;
                num4=n;
                //System.out.println(num1);
                //System.out.println(num2);                
                break;}
            }
          }return num4;*/
  }
