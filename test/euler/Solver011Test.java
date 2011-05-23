package euler;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Solver011Test
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
  public void testReadData()
  {
    Solver011 solver = new Solver011();
    int[][] data = solver.readData(20, 20);
    assertEquals(8, data[0][0]);
    assertEquals(48, data[19][19]);
  }

}
