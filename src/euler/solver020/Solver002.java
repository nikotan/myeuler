package euler.solver020;

import euler.Solver;

public class Solver002 implements Solver
{

  public String solve()
  {
    int x3, x2, x1, sum;
    x2  = 2;
    x1  = 1;
    sum = 2;
    while(true){
      x3 = x2 + x1;
      if(x3 > 4000000) break;
      if(x3 % 2 == 0) sum += x3;
      x1 = x2;
      x2 = x3;
    }
    return Integer.toString(sum);
  }

}