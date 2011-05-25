package euler.solver20;

import euler.Solver;


public class Solver016 implements Solver
{
  private static final int TIMES = 1000;

  public String solve()
  {
    int dim = 4 * (int)Math.ceil(TIMES/10.);
    int[] d  = new int[dim];
    int i, j, tmp;
    
    for(i=0; i<dim; i++){
      d[i]  = -1;
    }
    d[0] = 1;

    for(i=0; i<TIMES; i++){
      for(j=0; j<dim; j++){
        if(d[j] >= 0) d[j] = d[j] << 1;
      }
      for(j=0; j<dim-1; j++){
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
    for(i=0; i<dim; i++){
      if(d[i] < 0) break;
      sum += d[i];
    }
    return Integer.toString(sum);
  }
}