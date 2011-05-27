package euler.solver040;

import euler.Solver;

public class Solver025 implements Solver
{
  public String solve()
  {
    int[] f1 = new int[1000];
    int[] f2 = new int[1000];
    int[] f3 = new int[1000];
    int i, term, tmp;

    for(i=0; i<1000; i++){
      f1[i] = f2[i] = f3[i] = 0;
    }
    f1[0] = 1;
    f2[0] = 1;
    
    term = 2;
    while(f3[999] == 0){
      f3[0] = 0;
      for(i=0; i<999; i++){
        tmp = f1[i] + f2[i] + f3[i];
        f3[i] = tmp % 10;
        f3[i + 1] = tmp / 10;
      }
      for(i=0; i<1000; i++){
        f1[i] = f2[i];
        f2[i] = f3[i];
      }
      term++;
    }
    return Integer.toString(term);
  }
}