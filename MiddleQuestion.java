package calculator;

public class MiddleQuestion
{
	private int a, b, c;
	private String f1, f2;
	private String result;
	private String itself;
	
	public Fraction plus(Fraction a, Fraction b)
	{
		Fraction result1 = new Fraction(1, 1);
		result1.denominator = a.denominator * b.denominator;
		result1.numerator = a.numerator * b.denominator + a.denominator * b.numerator;
	    int m = result1.denominator;
	    int n = result1.numerator;
	    reduct(m, n);
	    Fraction result = new Fraction(m, n);
	    return result;
	}
	
	public Fraction minus(Fraction a, Fraction b)
	{
		Fraction result1 = new Fraction(1, 1);
		result1.denominator = a.denominator * b.denominator;
		result1.numerator = a.numerator * b.denominator - a.denominator * b.numerator;
	    int m = result1.denominator;
	    int n = result1.numerator;
	    reduct(m, n);
	    Fraction result = new Fraction(m, n);
	    return result;
	}
	
	public Fraction mul(Fraction a, Fraction b)
	{
		Fraction result1 = new Fraction(1, 1);
		result1.denominator = a.denominator * b.denominator;
		result1.numerator = a.numerator * b.numerator;
		int m = result1.denominator;
	    int n = result1.numerator;
	    reduct(m, n);
	    Fraction result = new Fraction(m, n);
	    return result;
	}
	
	public Fraction div(Fraction a, Fraction b)
	{
		Fraction b1 = new Fraction(b.denominator, b.numerator);
		Fraction result = mul(a, b1);
		return result;
	}
	
	public void reduct(int a, int b)
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
	}
	
	public MiddleQuestion(int a, int b, int c, String f1, String f2)
	{
		this.a = a;
		this.b = b;
		this.c = c;
		this.f1 = f1;
		this.f2 = f2;
	}
	
	public String getItself()
	{
		itself = String.valueOf(a)+f1+String.valueOf(b)+f2+String.valueOf(c)+"=";
		return itself;
	}
	
	
	
	public String getResult()
	{
		if(f1 == "+")
		{
			if(f2 == "+")
			{
				result = String.valueOf(a + b + c);
				return result;
			}
			else if(f2 == "-")
			{
				result = String.valueOf(a + b - c);
				return result;
			}
			else if(f2 == "*")
			{
				result = String.valueOf(a + b * c);
				return result;
			}
			else
			{
				Fraction m = new Fraction(1, a);
				Fraction n = new Fraction(c, b);
				Fraction result = plus(m, n);
				return result.getValue();
			}
		}
		else if(f1 == "-")
		{
			if(f2 == "+")
			{
				result = String.valueOf(a - b + c);
				return result;
			}
			else if(f2 == "-")
			{
				result = String.valueOf(a - b - c);
				return result;
			}
			else if(f2 == "*")
			{
				result = String.valueOf(a - b * c);
				return result;
			}
			else
			{
				Fraction m = new Fraction(1, a);
				Fraction n = new Fraction(c, b);
				Fraction result = minus(m, n);
				return result.getValue();
			}
		}
		else if(f1 == "*")
		{
			if(f2 == "+")
			{
				result = String.valueOf(a * b + c);
				return result;
			}
			else if(f2 == "-")
			{
				result = String.valueOf(a * b - c);
				return result;
			}
			else if(f2 == "*")
			{
				result = String.valueOf(a * b * c);
				return result;
			}
			else
			{
				Fraction m = new Fraction(1, a);
				Fraction n = new Fraction(c, b);
				Fraction result = mul(m, n);
				return result.getValue();
			}
		}
		else
		{
			if(f2 == "+")
			{
				Fraction m = new Fraction(1, c);
				Fraction n = new Fraction(b, a);
				Fraction result = plus(m, n);
				return result.getValue();
			}
			else if(f2 == "-")
			{
				Fraction m = new Fraction(1, c);
				Fraction n = new Fraction(b, a);
				Fraction result = minus(n, m);
				return result.getValue();
			}
			else if(f2 == "*")
			{
				Fraction m = new Fraction(b, a);
				Fraction n = new Fraction(1, c);
				Fraction result = mul(m, n);
				return result.getValue();
			}
			else
			{
				Fraction m = new Fraction(b, a);
				Fraction n = new Fraction(c, 1);
				Fraction result = mul(m, n);
				return result.getValue();
			}
		}
	}
	
	
}
