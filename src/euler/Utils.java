package euler;

import java.util.Map;

public class Utils
{

  public static void factorize(int n, Map<Integer, Integer> map)
  {
    for(int i=2; i<=n; i++){
      if(n%i == 0){
        Integer cnt = map.get(i);
        if(cnt == null){
          map.put(i, 1);
        }else{
          map.put(i, cnt.intValue()+1);
        }
        if(n == i) break;
        factorize(n/i, map);
        break;
      }
    }
  }

}