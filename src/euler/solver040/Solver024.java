package euler.solver040;

import euler.Solver;

public class Solver024 implements Solver
{
  public String solve()
  {
    int[] d  = new int[10]; // result
    int[] fs = new int[10];  // factorial series (9! = 362880)
    int[] u  = new int[10]; // used bits
    int i, j;

    for(i=1; i<=10; i++){
      fs[i-1] = 1;
      for(j=1; j<=i; j++){
        fs[i-1] *= j;
      }
    }
    for(i=0; i<10; i++){
      u[i] = 0;
    }

    int o;
    int r = 1000000;
    for(i=0; i<9; i++){
      if(r == fs[9-i]){
        for(j=9; j>=0; j--){
          if(u[j] == 0){
            d[i] = j;
            u[j] = 1;
            break;
          }
        }
        r = fs[8-i];
      }else{
        o = (r - 1) / fs[8-i];
        r -= o * fs[8-i];
        for(j=0; j<10; j++){
          if(u[j] == 0){
            if(o == 0){
              d[i] = j;
              u[j] = 1;
            }
            o--;
          }
        }
      }
    }
    for(j=0; j<10; j++){
      if(u[j] == 0){
        d[9] = j;
        break;
      }
    }
    
    StringBuffer sb = new StringBuffer();
    for(i=0; i<10; i++){
      sb.append(d[i]);
    }
    return sb.toString();
  }
}