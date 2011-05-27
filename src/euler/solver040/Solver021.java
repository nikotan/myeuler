package euler.solver040;

import java.util.HashSet;

import euler.Solver;


public class Solver021 implements Solver
{
  public String solve()
  {
    HashSet<Integer> checked = new HashSet<Integer>();
    int s1, s2, i;
    
    int sum = 0;
    for(i=4; i<10000; i++){
      if(!checked.contains(i)){
        s1 = getSumDivisors(i);
        s2 = getSumDivisors(s1);
        if(s2 == i && s1 != s2){
          sum += i;
          if(s1 < 10000){
            sum += s1;
          }
        }
        checked.add(s1);
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