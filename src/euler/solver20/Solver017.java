package euler.solver20;

import euler.Solver;


public class Solver017 implements Solver
{
  private static final int[] NUM_1 = {3, 3, 5, 4, 4, 3, 5, 5, 4, 3}; // one,two,...,ten
  private static final int[] NUM_2 = {6, 6, 8, 8, 7, 7, 9, 8, 8}; // eleven,twelve,...,nineteen
  private static final int[] NUM_3 = {6, 6, 5, 5, 5, 7, 6, 6}; // twenty,...,ninety

  public String solve()
  {
    int sum = 0;
    int i;
    for(i=1; i<=99; i++){
      sum += getLen2(i);
    }
    for(i=100; i<=999; i++){
      sum += getLen3(i);
    }
    sum += 11;

    return Integer.toString(sum);
  }

  // 1 <= i <= 99
  public int getLen2(int i)
  {
    if(i <= 10){
      return NUM_1[i-1];
    }else if(i < 20){
      return NUM_2[i-11];
    }else{
      if(i % 10 == 0){
        return NUM_3[i / 10 - 2];
      }else{
        return NUM_3[i / 10 - 2] + NUM_1[i % 10 -1];
      }
    }
  }
  
  // 100 <= i <= 999
  public int getLen3(int i)
  {
    if(i % 100 == 0){
      return NUM_1[i / 100 - 1] + 7;
    }else{
      return NUM_1[i / 100 - 1] + 10 + getLen2(i % 100);
    }
  }

}