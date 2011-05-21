package euler;

public class Solver006 implements Solver
{

  public String solve()
  {
    int max = 100;
    int sum = 0;
    for(int i=1; i<max; i++){
      for(int j=i+1; j<=max; j++){
        sum += 2*i*j;
      }
    }
    return Integer.toString(sum);
  }

}