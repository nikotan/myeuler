package euler;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solver005 implements Solver
{

  public String solve()
  {
    int max = 20;
    Map<Integer, Integer> res = new HashMap<Integer, Integer>();
    for(int i=2; i<=max; i++){
      Map<Integer, Integer> map = new HashMap<Integer, Integer>();
      factorize(i, map);
      Iterator<Integer> it = map.keySet().iterator();
      while(it.hasNext()){
        int f = it.next().intValue();
        int c = map.get(f).intValue();
        Integer t = res.get(f);
        if(t == null){
          res.put(f, c);
        }else{
          res.put(f, Math.max(c, t.intValue()));
        }
      }
    }
    int out = 1;
    Iterator<Integer> it2 = res.keySet().iterator();
    while(it2.hasNext()){
      int f = it2.next();
      int c = res.get(f).intValue();
      out *= Math.round(Math.pow(f, c));
    }
    return Integer.toString(out);
  }

  public void factorize(int n, Map<Integer, Integer> map)
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