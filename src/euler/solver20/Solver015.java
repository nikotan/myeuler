package euler.solver20;

import euler.Solver;


public class Solver015 implements Solver
{
  private static final int SIZE = 20;

  public String solve()
  {
    long[][] cnt = new long[SIZE + 1][SIZE + 1];
    int i, j;

    for(i=0; i<=SIZE; i++){
      cnt[0][i] = 1;
      cnt[i][0] = 1;
    }
    for(i=1; i<=SIZE; i++){
      for(j=1; j<=SIZE; j++){
        cnt[i][j] = cnt[i-1][j] + cnt[i][j-1];
      }
    }
    return Long.toString(cnt[SIZE][SIZE]);
  }
}