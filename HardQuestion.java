package calculator;

public class HardQuestion 
{
	private int a, b, c, d;
	private String f1, f2, f3;
	private String itself;
	
	
	public HardQuestion(int a, int b, int c, int d, String f1, String f2, String f3)
	{
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.f1 = f1;
		this.f2 = f2;
		this.f3 = f3;
	}
	
	public String getItself()
	{
		itself = String.valueOf(a)+f1+String.valueOf(b)+f2+String.valueOf(c)+f3+String.valueOf(d)+"=";
		return itself;
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
	
	public String newPlus(MiddleQuestion q, int a)
	{
		if(q.getResult().contains("/"))
		{
			String str = q.getResult();
			String n = "", d = "";
			int i=0;
			for(i=0; str.charAt(i)!='/'; i++)
			{
				n += str.charAt(i);
			}
			int numer = Integer.parseInt(n);
			while(i<str.length()-1)
			{
				d += str.charAt(i+1);
				i += 1;
			}
			int deno = Integer.parseInt(d);
			Fraction f1 = new Fraction(deno, numer);
			Fraction f2 = new Fraction(1, a);
			return String.valueOf(plus(f1, f2).getValue());
		}
		else
		{
			int m = Integer.parseInt(q.getResult());
			int result = m + a;
			return String.valueOf(result);
		}
	}
	
	public String newMinus(MiddleQuestion q, int a)
	{
		if(q.getResult().contains("/"))
		{
			String str = q.getResult();
			String n = "", d = "";
			int i=0;
			for(i=0; str.charAt(i)!='/'; i++)
			{
				n += str.charAt(i);
			}
			int numer = Integer.parseInt(n);
			while(i<str.length()-1)
			{
				d += str.charAt(i+1);
				i += 1;
			}
			int deno = Integer.parseInt(d);
			Fraction f1 = new Fraction(deno, numer);
			Fraction f2 = new Fraction(1, a);
			return String.valueOf(minus(f1, f2).getValue());
		}
		else
		{
			int m = Integer.parseInt(q.getResult());
			int result = m - a;
			return String.valueOf(result);
		}
	}
	
	
	public String getResult()
	{
		MiddleQuestion q = new MiddleQuestion(a, b, c, f1, f2);
		if(f3 == "+")
		{
			return newPlus(q, d);
		}
		else
		{
			return newMinus(q, d);
		}
	}
	
}
