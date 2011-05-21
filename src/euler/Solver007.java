package euler;

import java.util.ArrayList;
import java.util.Iterator;

public class Solver007 implements Solver
{
  private ArrayList<Integer> primes = new ArrayList<Integer>();

  public String solve()
  {
    primes.add(2);
    int n = 3;
    int cnt = 1;
    while(true){
      if(isPrime(n)){
        primes.add(n);
        if(++cnt == 10001){
          return Integer.toString(n);
        }
      }
      n += 2;
    }
  }
  
  public boolean isPrime(int n)
  {
    int n2 = (int)Math.floor(Math.sqrt(n));
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