package Vtiger.Practice;

public class GenericMethodPractice {

	public static void main(String[] args)  //calling
	{
		int result=add(26,10);
		System.out.println(result);
		

	}
	public static int add(int a ,int b)   //called
	{
		int c=a+b;
		return c;
	}

}
