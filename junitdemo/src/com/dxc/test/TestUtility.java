package com.dxc.test;
import static org.junit.Assert.*;
import com.dxc.demo.Utility;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class TestUtility 
{
	  Utility u = null;

	@Before
	public  void setUp() 
	{
		u = new Utility();
	}

	@After
	public  void tearDown()  
	{
		u = null;
	}
	@Test(timeout=1000)
	public void testTimeMethod() 
	{
		assertEquals("Done",u.timeMethod());
	}
	
	
	
	
    /*@Ignore
	@Test
	public void testSum()
	{
		assertTrue(30==u.sum(10, 20));
	}
	@Test
	public void testSqr()
	{
		assertFalse(!(100==u.sqr(10)));
	}
	@Test
	public void testDivision()
	{
		assertEquals(5,u.division(10, 2));
	}
	@Test(expected=ArithmeticException.class)
	public void testDivisionForException()
	{
		u.division(10, 0);
	}
    */


}
