package euler.solver020;

import euler.Solver;

public class Solver003 implements Solver
{

  public String solve()
  {
    return Long.toString(getLP(600851475143l));
  }

  public long getLP(long v)
  {
    long sq = (long)Math.floor(Math.sqrt((double)v));
    for(long i = 2; i <= sq; i++){
      if(v % i == 0){
        return getLP(v/i);
      }
    }
    return v;
  }
}