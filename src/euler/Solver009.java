package euler;

public class Solver009 implements Solver
{
  public String solve()
  {
    int amax = (int)Math.floor(500 * (2 - Math.sqrt(2)));
    for(int a=1; a<=amax; a++){
      int a2 = a * a;
      for(int b=a+1; b<=(int)Math.floor((1000. - a) / 2); b++){
        int c = 1000 - a - b;
        if(c*c == a2 + b * b){
          return Integer.toString(a * b * c);
        }
      }
    }
    System.out.println(amax);
    return Integer.toString(2);
  }
}