package euler;

import java.util.HashMap;
import java.util.Map;

public class Solver014 implements Solver
{
  public String solve()
  {
    long max = 0;
    long num = 0;
    Map<Long, Long> map = new HashMap<Long, Long>();

    for(long i=2; i<1000000; i++){
      long v = i;
      long c = 0;
      while(v > 1){
        if(map.containsKey(v)){
          c += map.get(v).intValue();
          break;
        }else{
          c++;
          if(v % 2 == 0){
            v = v / 2;
          }else{
            v = 3 * v + 1;
          }
        }
      }
      map.put(i, c);
      if(c > max){
        max = c;
        num = i;
      }
    }
    return Long.toString(num);
  }
}