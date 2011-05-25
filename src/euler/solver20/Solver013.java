package euler.solver20;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import euler.Solver;

public class Solver013 implements Solver
{
  public String solve()
  {
    long sum = 0;

    BufferedReader br = null;
    try{
      br = new BufferedReader(new FileReader("src/euler/solver20/data013.txt"));
      String line;
      while((line=br.readLine())!=null){
        sum += Long.parseLong(line.substring(0, 14));
      }
    }catch(IOException e){
      e.printStackTrace();
    }finally{
      if(br!=null){
        try{
          br.close();
        }catch(IOException e){}
      }
    }

    return Long.toString(sum).substring(0, 10);
  }
  
}