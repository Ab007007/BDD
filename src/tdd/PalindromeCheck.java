package tdd;

public class PalindromeCheck {

	public boolean isPalindrome(String str)
	{
		
		StringBuffer sb = new StringBuffer(str);
		if(sb.equals(sb.reverse()))
			return true;
		else
			return false;
	}
}
