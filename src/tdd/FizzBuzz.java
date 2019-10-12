package tdd;

public class FizzBuzz {
	
	
	public String play(int number)
	{
		String str = null;
		
		if (number % 3 ==0)
			str="Fizz";
		else if(number % 5 ==0)
			str="Buzz";
		else
			str = String.valueOf(number);
		
		return str;
	}

}
