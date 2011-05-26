package euler.solver020;

import euler.Solver;

public class Solver001 implements Solver
{

  public String solve()
  {
    int sum = sum(3, 1000) + sum(5, 1000) - sum(15, 1000);
    return Integer.toString(sum);
  }

  public int sum(int base, int max)
  {
    int n = (max - 1) / base;
    return base * n * (n+1) / 2;
  }

}