package euler.solver020;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Solver005Test
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
    Solver005 solver = new Solver005();
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    solver.factorize(8, map);
    assertEquals(1, map.size());
    assertEquals(3, map.get(2).intValue());
  }

}
