package com.dxc.jenkinsdemo.bussiness;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
public class CalculatorTest 
{
	Calculator calc = null;
    @Before
    public void setUp() throws Exception
    {
    	calc = new Calculator(); 
    }
    @After
    public void tearDown() throws Exception
    {
    	calc = null;
    }
    @Test
    public void testsum()
    {
    	assertEquals(30,calc.sum(10, 20));
    }
    @Test
    public void testSqr()
    {
    	assertEquals(121,calc.square(11));
    }
    @Test
    public void testPowers()
    {
    	assertEquals(125,calc.power(5, 3));
    }
    @Test
    public void testDivide()
    {
    	assertEquals(2,calc.divide(10,5));
    }
}