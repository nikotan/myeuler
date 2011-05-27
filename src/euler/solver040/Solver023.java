package euler.solver040;

import java.util.ArrayList;
import java.util.HashSet;

import euler.Solver;


public class Solver023 implements Solver
{
  public String solve()
  {
    ArrayList<Integer> abs = new ArrayList<Integer>();
    HashSet<Integer> sumAbs = new HashSet<Integer>();
    int i, j, s;

    for(i=12; i<=28123; i++){
      s = getSumDivisors(i);
      if(s > i){
        abs.add(i);
      }
    }
    for(i=0; i<abs.size(); i++){
      for(j=0; j<abs.size(); j++){
        s = abs.get(i).intValue() + abs.get(j).intValue();
        if(s > 28123){
          break;
        }else{
          sumAbs.add(s);
        }
      }
    }
    
    int sum = 0;
    for(i=1; i<=28123; i++){
      if(!sumAbs.contains(i)){
        sum += i;
      }
    }
    return Integer.toString(sum);
  }
  
  public int getSumDivisors(int n)
  {
    int sum = 0;
    for(int i=1; i<n; i++){
      if(n % i == 0){
        sum += i;
      }
    }
    return sum;
  }
}