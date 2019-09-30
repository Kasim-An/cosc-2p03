//Xinan Wang
//5535802
package assignment4;
public class help{
  public void east(char[][] a,int num1,int num2,int num3,int num4,int steps,String record){
    if(a[num1][num2]!='X'){
      record=record+"E";
    }
  }
  public void west(char[][] a,int num1,int num2,int num3,int num4,int steps,String record){
    if(a[num1][num2]!='X'){
      record=record+"W";
    }
  }
  public void south(char[][] a,int num1,int num2,int num3,int num4,int steps,String record){
    if(a[num1][num2]!='X'){
      record=record+"S";
    }
  }
  public void north(char[][] a,int num1,int num2,int num3,int num4,int steps,String record){
    if(a[num1][num2]!='X'){
      record=record+"N";
    }
  }
}
