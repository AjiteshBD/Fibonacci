import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class Fibonacci {
	
	private static ArrayList<Integer> listFibonacci;//Arraylist of Fibonacci series to hold the number in index
	static Scanner sc = new Scanner(System.in);	//Scanner to get user input
	
	public static void main(String[] args) 
	{
		listFibonacci = new ArrayList<Integer>();
		generateFibonacci(20,true);//private method to generate few fibonacci and populate in list
		while(true) //Menu loop
		{
			//Console menu display to choose method
	        System.out.printf("Welcome to Fibonacci Magic!\nChoose one Option to start:\n");  
	        System.out.println("1.Get Fibonacci series of Number\n2.Get Fibonacci of number in reverse Index\n3.exit");
	        if(sc.hasNextInt())//check if user had input integer
	        {
	        	int num,rev;
	        	int input = sc.nextInt();
	        	switch(input) 
	        	{
		        	case 1:        		
		        		System.out.println("Get Fibonacci Series of number\nPlease a number");
		        		num = sc.nextInt();
		        		System.out.println(getFibonacci(num));
		        		System.out.println("List of Fibonacci series :" +listFibonacci);
		        		break;
		        	case 2:
		        		System.out.println("Get Fibonacci Series in reverse index\nPlease reverse index and a number");
		        		num = sc.nextInt();
		        		rev = sc.nextInt();        		
		        		System.out.println(getFibonacci(num,rev));   
		        		System.out.println("List of Fibonacci series :" +listFibonacci);
		        		break;
		        	case 3:
		        		System.exit(0);
	        	}        	
	        	
	        }else//throw error to user if correct input is not provided
	        {
	        	System.out.println("Error: Wrong Input! Please Restart program");
	        	break;
	        }
		}
       
       
    }
	
	//Function to get fibonacci series of number 
	private static int getFibonacci(int number) 
	{
		if(number >= listFibonacci.size()) 
		{
			generateFibonacci(number+1, false);
		}
		return listFibonacci.get(number);		
	}
	
	

	//function to get fibonacci series of a number in reverse index
	private static int getFibonacci(int revIndex,int generateFibonaci)
	{ 
		int i=0;
		if(generateFibonaci>=listFibonacci.size())
		{
			generateFibonacci(generateFibonaci,false);
			i=getFibonacci(listFibonacci.size()-revIndex);
		}else if(revIndex >= listFibonacci.size())
		{
			generateFibonacci(revIndex+generateFibonaci, false);
			i=getFibonacci(listFibonacci.size()-revIndex);
		}else
		{
			i=getFibonacci(listFibonacci.size()-revIndex);
		}
		
		return i;
	}
	 
	//Fibonacci generation and list populating list with number method 
	private static void generateFibonacci(int num,boolean isFirst)
	{
		int  t1 = 0, t2 = 1;
		if(isFirst) //boolean flag to populate list for the first time with few numbers
		{
			 while (t1 <= num)
		        {
		        	listFibonacci.add(t1);            
		            int sum = t1 + t2;//0+1=1/1+1=2
		            t1 = t2;//t1=1
		            t2 = sum;//t2=1
		        }
		}else //logic to add more number in list as per user input
		{
			int size=listFibonacci.size()-1;
			if(num >= listFibonacci.size()) 
			{
				t2=listFibonacci.get(size);
				t1=(listFibonacci.get(size)+listFibonacci.get(size-1));
				for(int i=listFibonacci.size();i<num;i++)
				{
					listFibonacci.add(i,t1);
					int sum = t1 + t2;
		            t1 = sum;
		            t2 = t1;
					
				}
			}
		}
       
	}
	
	
	
}
