package calculator;

public class EasyQuestion
{
	private int a;
	private int b;
	private String f;
    private String result;
	private String itself;


	public EasyQuestion(int a, int b, String f)
	{
		this.a = a;
		this.b = b;
		this.f = f;
	}
	public String getResult()
	{
		switch(f)
		{
			case "+":
				result = String.valueOf(a + b);
				break;
			case "-":
				result = String.valueOf(a - b);
				break;
			case "*":
				result = String.valueOf(a * b);
				break;
			case "/":
				result = div(a, b);
				break;
		}
		return result;
	}
	public String getItself()
	{
		itself = String.valueOf(a)+f+String.valueOf(b)+"=";
		return itself;
	}
	
	
	
	public String div(int a, int b)
	{
		if(b > a)
		{
			if(b % a == 0)
			{
				b /= a;
				a = 1;
			}
			else
			{
				int c = 1;
				for(int i=1; i<Math.sqrt(a); i++)
				{
					if(a%i == 0 && b%i == 0)
					{
						c = i;
					}
				}
				a /= c;
				b /= c;
			}
		}
		else
		{
			if(a % b == 0)
			{
				a /= b;
				b = 1;
			}
			else
			{
				int c = 1;
				for(int i=1; i<Math.sqrt(b); i++)
				{
					if(a%i == 0 && b%i == 0)
					{
						c = i;
					}
				}
				a /= c;
				b /= c;
			}
		}
		Fraction result = new Fraction(b, a) ;
		return result.getValue();
	}
}
