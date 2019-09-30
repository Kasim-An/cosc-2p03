//assigment 4
//This program is to count a word and display in some rule
//write by: Yiwei Mao
//Student number: 5717517
import java.util.Scanner;
import java.io.*;
public class question
{
  public static void main(String[] args) throws IOException
  {
    //String in="a it's it's";
    File input=new File("inputfile.txt");
    Scanner sc=new Scanner(input);
    String out=sc.nextLine();
    System.out.println(out);
  }
}