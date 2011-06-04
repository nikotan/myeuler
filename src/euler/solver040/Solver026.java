package euler.solver040;

import euler.Solver;

public class Solver026 implements Solver
{
  public String solve()
  {
    int d, m, n, i;
    int max  = 0;
    int maxd = 0;
    for(d=2; d<1000; d++){
      m = d;
      while((m % 2) == 0){
        m /= 2;
      }
      while((m % 5) == 0){
        m /= 5;
      }
      if(m > 1){
        n = 9;
        for(i=1; i<d; i++){
          if(n % m == 0){
            if(i > max){
              max  = i;
              maxd = d;
            }
            break;
          }else{
            n = (n % m) * 10 + 9;
          }
        }
      }
    }
    return Integer.toString(maxd);
  }
}