package euler.solver20;

import euler.Solver;

public class Solver014 implements Solver
{
  private static final int LEN = 1000000;

  public String solve()
  {
    long max = 0;
    int  num = 0;
    long[] memo = new long[LEN];

    for(int i=1; i<LEN; i++){
      long v = i;
      long c = 0;
      while(true){
        if(v < (long)i){
          c += memo[(int)v];
          break;
        }else{
          c++;
          if(v % 2l == 0){
            v = v / 2l;
            if(v == 1l){
              c++;
              break;
            }
          }else{
            v = 3 * v + 1;
          }
        }
      }
      memo[i] = c;
      if(c > max){
        max = c;
        num = i;
      }
    }
    return Long.toString(num);
  }
}