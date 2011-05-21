package euler;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Solver004Test
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
  public void testIsPalindromic()
  {
    Solver004 solver = new Solver004();
    assertTrue(solver.isPalindromic(33));
    assertFalse(solver.isPalindromic(35));
    assertTrue(solver.isPalindromic(262));
    assertFalse(solver.isPalindromic(253));
    assertTrue(solver.isPalindromic(3663));
    assertFalse(solver.isPalindromic(3643));
  }

}
