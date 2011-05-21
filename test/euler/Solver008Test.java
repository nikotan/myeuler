package euler;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Solver008Test
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
  public void testReadData() throws Exception
  {
    Solver008 solver = new Solver008();
    String[] data = solver.readData();
    assertTrue(data.length > 0);
  }
  
  @Test
  public void testGetMaxProduct()
  {
    Solver008 solver = new Solver008();
    String data = "1122332";
    int max = solver.getMaxProduct(data);
    assertEquals(72, max);
  }
}