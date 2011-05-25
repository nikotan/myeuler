package euler.solver20;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Solver012Test
{

  @Before
  public void setUp() throws Exception
  {
  }

  @After
  public void tearDown() throws Exception
  {
  }

  @Test
  public void testFactorize()
  {
    Solver012 solver = new Solver012();
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    solver.factorize(18, map);
    assertEquals(2, map.size());
    assertEquals(1, map.get(new Integer(2)).intValue());
    assertEquals(2, map.get(new Integer(3)).intValue());
  }

}
