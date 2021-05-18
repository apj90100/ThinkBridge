package javaPrograms;

public class Test5
{
	public static void main(String[] args) {
		print();
	}
	static void print()
	{
	    for(int i=1;i<=100;i++)
	    {
	        //checks for multiples of three
	        if(i%3==0)
	            System.out.println("MThree");
	        //checks for multiples of five
	        else if(i%5==0)
	            System.out.println("MFive");
            //checks for multiples of both of both three and five
	        else if(i%15==0)
	            System.out.println("Resolver");
	        else
	            System.out.println(i);
	        
	       
	    }
	}
}
