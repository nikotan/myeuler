package euler;


public class Solver016 implements Solver
{
  private static final int TIMES = 1000;

  public String solve()
  {
    int dim = 4 * (int)Math.ceil(TIMES/10.);
    byte[] d  = new byte[dim];
    byte[] d2 = new byte[dim];
    int i, j;
    
    for(i=0; i<dim; i++){
      d[i]  = -1;
      d2[i] = -1;
    }
    d[0] = 1;

    for(i=0; i<TIMES; i++){
      for(j=0; j<dim-1; j++){
        if(d[j] >= 0){
          d2[j] = (byte)(d[j] * 2);
        }
      }
      for(j=0; j<dim-1; j++){
        if(d2[j] >= 0){
          d[j]     = (byte)(d2[j] % 10);
          byte tmp = (byte)(d2[j] / 10);
          if(tmp > 0){
            if(d[j+1] < 0) d2[j+1] = 0;
            d2[j+1] += tmp;
          }
        }
        d2[j] = -1;
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