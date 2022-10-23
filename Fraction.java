package calculator;

public class Fraction
{
	int denominator;
	int numerator;
	String value;
	
	public Fraction(int denominator, int numerator)
	{
		this.denominator = denominator;
		this.numerator = numerator;
	}
	public String getValue()
	{
		if(denominator == 1)
		{
			value = String.valueOf(numerator);
			return value;
		}
		else
		{
			value = String.valueOf(numerator) + "/" + String.valueOf(denominator);
			return value;
		}
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
}
