package euler.solver040;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import euler.solver040.Solver022.MyName;

public class Solver022Test
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
    Solver022 solver = new Solver022();
    MyName[] data = solver.readData();
    assertTrue(data.length > 5000);
  }
  
  @Test
  public void testMyName()
  {
    Solver022 solver = new Solver022();
    MyName n1 = solver.new MyName("TEST");
    assertEquals(-1, n1.compareTo(solver.new MyName("UE")));
    assertEquals( 1, n1.compareTo(solver.new MyName("SE")));
    assertEquals(-1, n1.compareTo(solver.new MyName("TEST0")));
    assertEquals( 1, n1.compareTo(solver.new MyName("TES")));
    assertEquals( 0, n1.compareTo(solver.new MyName("TEST")));
  }

  @Test
  public void testGetScore()
  {
    Solver022 solver = new Solver022();
    assertEquals(3, solver.getScore("AB"));
  }
}