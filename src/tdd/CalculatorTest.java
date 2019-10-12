package tdd;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CalculatorTest {
	
	Caluclator cal = null;
	@Before
	public void setup()
	{
		cal = new Caluclator();
	}
	@Test
	public void add()
	{
		Assert.assertEquals(5, cal.add(2,3));
	}

	@Test
	public void addnegatives()
	{
		Assert.assertEquals(-5, cal.add(-2,-3));
	}
	
	@Test
	public void addpositiveAndnegatives()
	{
		Assert.assertEquals(-1, cal.add(2,-3));
	}
	

}
