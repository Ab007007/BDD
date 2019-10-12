package tdd;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class PalindromeTestCheck extends TestCase 
{
	
	PalindromeCheck obj =null;
	@Before
	protected void setUp() throws Exception {
		obj = new PalindromeCheck();
		super.setUp();
	}
	
	@Test
	public void testCreatePalindromeTestObject()
	{
		
		assertNotNull(obj);
	}
	@Test
	public void testIsPalindrome()
	{
		assertTrue(obj.isPalindrome("nitin"));
	}

	@Test
	public void testNotAPalindrome()
	{
		assertTrue(obj.isPalindrome("ABC"));
	}
	
	@Test
	public void testIsNOTLongPalindrome()
	{
		assertTrue(obj.isPalindrome("asafsdfasdfasd"));
	}
}
