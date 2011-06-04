package euler.solver020;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import euler.Solver;
import euler.Utils;

public class Solver012 implements Solver
{

  public String solve()
  {
    int num = 1;
    while(true){
      int tnum = num * (num + 1) / 2;
      Map<Integer, Integer> map = new HashMap<Integer, Integer>();
      Utils.factorize(tnum, map);
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
}