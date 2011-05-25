package euler.solver20;

import euler.Solver;

public class Solver004 implements Solver
{

  public String solve()
  {
    int[][] d1 = {{1,9}, {3,3}};
    int max = 0;
    for(int d2a=0; d2a<10; d2a++){
      for(int i=0; i<d1.length; i++){
        int v1 = 900 + d2a*10 + d1[i][0];
        for(int d2b=0; d2b<10; d2b++){
          int v2 = 900 + d2b*10 + d1[i][1];
          int v = v1 * v2;
          if(isPalindromic(v) && v > max){
            max = v;
          }
        }
      }
    }
    return Integer.toString(max);
  }

  public boolean isPalindromic(int num)
  {
    String s = Integer.toString(num);
    for(int i=0; i<s.length()/2; i++){
      if(s.charAt(i) != s.charAt(s.length()-i-1)) return false;
    }
    return true;
  }
}