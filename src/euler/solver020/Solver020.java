package euler.solver020;

import euler.Solver;


public class Solver020 implements Solver
{
  public String solve()
  {
    int[] d = new int[200];
    int i, j, tmp;
    
    for(i=0; i<d.length; i++){
      d[i] = -1;
    }
    d[0] = 1;
    
    for(i=2; i<=100; i++){
      for(j=0; j<d.length; j++){
        if(d[j] >= 0) d[j] *= i;
      }
      for(j=0; j<d.length; j++){
        if(d[j] >= 0){
          tmp = d[j] / 10;
          d[j] %= 10;
          if(tmp > 0){
            if(d[j+1] < 0) d[j+1] = 0;
            d[j+1] += tmp;
          }
        }
      }
    }
    
    int sum = 0;
    for(i=0; i<d.length; i++){
      if(d[i] < 0) break;
      sum += d[i];
    }
    return Integer.toString(sum);
  }
}