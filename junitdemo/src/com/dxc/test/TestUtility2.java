package com.dxc.test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import com.dxc.demo.Utility2;
@RunWith(Parameterized.class)
public class TestUtility2 {
	
	Utility2 u= null;

	@Before
	public void setUp() 
	{
		u = new Utility2();
	}
	@Parameter(0)
	public int x;
	@Parameter(1)
	public int n;
	@Parameter(2)
	public int expectedValue;
	@Parameters
	public static Collection<Object[]> list()
	{
		Object[][] arr = { { -5,3,-125},{5,3,125},{5,0,1},{5,1,5}};
		return Arrays.asList(arr);
		}
	
	
	

	@Test
	public void testPower() 
	{
		//assertEquals(-125,u.power(-5,3));
		assertEquals(expectedValue,u.power(x, n));
	}

}
