package euler.solver20;

import java.util.ArrayList;
import java.util.Iterator;

import euler.Solver;

public class Solver010 implements Solver
{
  private ArrayList<Integer> primes = new ArrayList<Integer>();

  public String solve()
  {
    long sum = 0;
    primes.add(2);
    sum += 2;
    int n = 3;
    while(n < 2000000){
      if(isPrime(n)){
        primes.add(n);
        sum += n;
      }
      n += 2;
    }
    return Long.toString(sum);
  }
  
  public boolean isPrime(int n)
  {
    int n2 = (int)Math.sqrt(n);
    Iterator<Integer> it = primes.iterator();
    while(it.hasNext()){
      int p = it.next();
      if(p > n2) break;
      if(n%p == 0){
        return false;
      }
    }
    return true;
  }

}