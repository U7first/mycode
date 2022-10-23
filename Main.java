package calculator;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.io.BufferedWriter;
import java.io.FileWriter;
public class Main 
{	
	public static void main(String[] args)throws Exception
	{
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("输入题数：");
		int total = input.nextInt();
		System.out.println("设置题目中出现的最小值：");
		int min = input.nextInt();
		System.out.println("设置题目中出现的最大值：");
		int max = input.nextInt();
		ArrayList<String> question = new ArrayList<>();
		ArrayList<String> answer = new ArrayList<>();
		int n = 0;
		while(n<total)
		{
			Random random = new Random();
			int degree = random.nextInt(3-1+1)+1;
			int op = random.nextInt(4-1+1)+1;
			int a = random.nextInt(max-min+1)+min;
			int b = random.nextInt(max-min+1)+min;	
			if(degree == 1)
			{
				String f = "?";
				switch(op)
				{
					case 1:
						f = "+";
						break;
					case 2:
						f = "-";
						break;
					case 3:
						f = "*";
						break;
					case 4:
						f = "/";
						break;
				}
					
					EasyQuestion q1 = new EasyQuestion(a, b, f);
					question.add(q1.getItself());
					answer.add(q1.getResult());
			}
				
			else if(degree == 2)
			{
				int c = random.nextInt(max-min+1)+min;
				int op1 = random.nextInt(4-1+1)+1;
				int op2 = random.nextInt(4-1+1)+1;
				String f1 = "?", f2 = "?";
				switch(op1)
				{
					case 1:
						f1 = "+";
						break;
					case 2:
						f1 = "-";
						break;
					case 3:
						f1 = "*";
						break;
					case 4:
						f1 = "/";
						break;
				}
				switch(op2)
				{
					case 1:
						f2 = "+";
						break;
					case 2:
						f2 = "-";
						break;
					case 3:
						f2 = "*";
						break;
					case 4:
						f2 = "/";
						break;
				}
				MiddleQuestion q2 = new MiddleQuestion(a, b, c, f1, f2);
				question.add(q2.getItself());
				answer.add(q2.getResult());
			}
				
			else
			{
				int c = random.nextInt(max-min+1)+min;
				int d = random.nextInt(max-min+1)+min;
				int op1 = random.nextInt(4-1+1)+1;
				int op2 = random.nextInt(4-1+1)+1;
				int op3 = random.nextInt(2-1+1)+1;
				String f1 = "?", f2 = "?", f3 = "?";
				switch(op1)
				{
					case 1:
						f1 = "+";
						break;
					case 2:
						f1 = "-";
						break;
					case 3:
						f1 = "*";
						break;
					case 4:
						f1 = "/";
						break;
				}
				switch(op2)
				{
					case 1:
						f2 = "+";
						break;
					case 2:
						f2 = "-";
						break;
					case 3:
						f2 = "*";
						break;
					case 4:
						f2 = "/";
						break;
				}
				switch(op3)
				{
					case 1:
						f3 = "+";
						break;
					case 2:
						f3 = "-";
						break;
				}
				HardQuestion q3 = new HardQuestion(a, b, c, d, f1, f2, f3);
				question.add(q3.getItself());
				answer.add(q3.getResult());
			}
			n++;
		}
			
		for(int i=0; i<total;i++)
		{
			System.out.println(question.get(i));
			System.out.println(answer.get(i));
		}
		input.close();
		
		FileWriter fw1 = new FileWriter("D:\\c++\\bin\\Homework\\src\\calculator\\Exercises.txt");
        BufferedWriter bw1 = new BufferedWriter(fw1);
        for(int i=0; i<total; i++)
        {
        	bw1.write(String.valueOf(i+1) + "." + question.get(i));
        	bw1.newLine();
        	bw1.flush();
        }
        bw1.close();
        
        FileWriter fw2 = new FileWriter("D:\\c++\\bin\\Homework\\src\\calculator\\Answers.txt");
        BufferedWriter bw2 = new BufferedWriter(fw2);
        for(int i=0; i<total; i++)
        {
        	bw2.write(String.valueOf(i+1) + "." + answer.get(i));
        	bw2.newLine();
        	bw2.flush();
        }
        bw2.close();
        
	}
	
	
}

