package euler.solver20;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import euler.Solver;

public class Solver012 implements Solver
{

  public String solve()
  {
    int num = 1;
    while(true){
      int tnum = num * (num + 1) / 2;
      Map<Integer, Integer> map = new HashMap<Integer, Integer>();
      factorize(tnum, map);
      int divs = 1;
      Iterator<Integer> it = map.keySet().iterator();
      while(it.hasNext()){
        divs *= (map.get(it.next()).intValue() + 1);
      }
      if(divs > 500){
        return Integer.toString(tnum);
      }
      num++;
    }
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