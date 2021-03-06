package euler;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UtilsTest
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
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    Utils.factorize(18, map);
    assertEquals(2, map.size());
    assertEquals(1, map.get(new Integer(2)).intValue());
    assertEquals(2, map.get(new Integer(3)).intValue());
  }

}
