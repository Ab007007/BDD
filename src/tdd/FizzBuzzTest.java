package tdd;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class FizzBuzzTest {

	
	FizzBuzz fb = null;
	
	@Before
	public void setup()
	{
		fb = new FizzBuzz();
	}
	
	
	@Test
	public void testNumber()
	{
		int number =1;
		String str = fb.play(number);
		Assert.assertEquals("1", str);
	}
	
	@Test
	public void testFizz()
	{
		int number = 3;
		String str = fb.play(number);
		Assert.assertEquals("Fizz", str);
	}
	
	
	@Test
	public void testFizzDivisibleByThree()
	{
		int number = 6;
		String str = fb.play(number);
		Assert.assertEquals("Fizz", str);
	}
	
	
	
	@Test
	public void testBuzz()
	{
		int number = 5;
		String str = fb.play(number);
		Assert.assertEquals("Buzz", str);
	}
	
	@Test
	public void testBuzzWithDivi()
	{
		int number = 10;
		String str = fb.play(number);
		Assert.assertEquals("Buzz", str);
	}
}
