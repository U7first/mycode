package calculator;

import java.io.*;
import java.util.ArrayList;
import java.io.BufferedReader;

public class Check 
{
	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		BufferedReader buf1 = new BufferedReader(new FileReader(new File("D:\\c++\\bin\\Homework\\src\\calculator\\Exercises.txt")));
		BufferedReader buf2 = new BufferedReader(new FileReader(new File("D:\\c++\\bin\\Homework\\src\\calculator\\Answers.txt")));
		ArrayList<String> exercises = new ArrayList<>();
		ArrayList<String> exercises2 = new ArrayList<>();
		ArrayList<String> answers = new ArrayList<>();
		ArrayList<String> answers2 = new ArrayList<>();
		ArrayList<String> repeatNum = new ArrayList<>();
		ArrayList<String> repeatBody = new ArrayList<>();
		
		while(buf1.readLine()!=null)
		{
			String str = buf1.readLine();
			exercises.add(str);
			exercises2.add(str);
		}
		while(buf2.readLine()!=null)
		{
			String str = buf2.readLine();
			answers.add(str);
			answers2.add(str);
		}
		buf1.close();
		buf2.close();
		
		for(int i=0; i<exercises.size(); i++)
		{
			for(int j=i+1; j<exercises2.size(); j++)
			{
				if(i!=j&&exercises.get(i)==exercises2.get(j))
				{
					repeatNum.add(String.valueOf(j));
					exercises2.remove(j);
					repeatNum.add(String.valueOf(i));
					repeatNum.add("\\");
					repeatBody.add(exercises.get(i));
				}
				
			}
		}
		
		int j = 0, i = 0;
		while(j<repeatBody.size()) 
		{
			while(repeatNum.get(i)!="\\") 
			{
				System.out.print(repeatNum.get(i)+" ");
				i++;
			}
			System.out.print(":");
			System.out.println(repeatBody.get(j));
			j++;
		}
		
	}

}

