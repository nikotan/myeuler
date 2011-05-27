package euler.solver040;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import euler.Solver;

public class Solver022 implements Solver
{
  public String solve()
  {
    MyName[] names = readData();
    Arrays.sort(names);

    long sum = 0;
    for(int i=0; i<names.length; i++){
      sum += (i + 1) * getScore(names[i].getName());
    }
    
    return Long.toString(sum);
  }
  
  
  public MyName[] readData()
  {
    String line = null;
    BufferedReader br = null;
    try{
      br = new BufferedReader(new FileReader("src/euler/solver040/data022.txt"));
      line = br.readLine();
    }catch(IOException e){
      e.printStackTrace();
    }finally{
      if(br!=null){
        try{
          br.close();
        }catch(IOException e){}
      }
    }
    if(line != null){
      String[] arr = line.split(",");
      MyName[] out = new MyName[arr.length];
      for(int i=0; i<arr.length; i++){
        out[i] = new MyName(arr[i].replaceAll("\"", ""));
      }
      return out;
    }else{
      return null;
    }
  }
  
  public class MyName implements Comparable<MyName>
  {
    private String name;
    
    public MyName(String name)
    {
      this.name = name;
    }
    
    public String getName()
    {
      return name;
    }

    public int compareTo(MyName o)
    {
      char cT, cO;
      int lenT = name.length();
      int lenO = o.getName().length();
      for(int i=0; i<Math.min(lenT, lenO); i++){
        cT = name.charAt(i);
        cO = o.getName().charAt(i);
        if(cT < cO){
          return -1;
        }else if(cT > cO){
          return  1;
        }
      }
      if(lenT < lenO){
        return -1;
      }else if(lenT > lenO){
        return  1;
      }else{
        return  0;
      }
    }
  }
  
  public int getScore(String name)
  {
    int sum = 0;
    for(int i=0; i<name.length(); i++){
      sum += name.charAt(i) - 'A' + 1;
    }
    return sum;
  }
}