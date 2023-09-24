package priority;

import java.util.Scanner;

public class priority
{
	public static void main(String args[])
	{
		Scanner scan=new Scanner(System.in);
		
		System.out.println("Enter the number of process: ");
		int n=scan.nextInt(); 
					
		int B[]=new int[n];  //burst time
				
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter the Burst time for P"+(i+1)+": ");
			B[i]=scan.nextInt();
		}		
		
		int P[]=new int[n];   //priority
		
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter the Priority value time for P"+(i+1)+": ");
			P[i]=scan.nextInt();
		}
		
		int P1[]=new int[n];  //another array of priority "Copy"
				
		for(int i=0;i<n;i++)
		{
			P1[i]=P[i];
		}
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n-1;j++)
			{
				if(P[j]>P[j+1])
				{
					int temp=P[j];
					P[j]=P[j+1];
					P[j+1]=temp;
				}
			}
		}
		
		int wait=0;				
		int WT[]=new int[n];		
		float total=0;		
		int k=0;
		
		System.out.println("Process\t Burst time\t\t waiting time");
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(P[i]==P1[j])
				{
					System.out.println("p"+(j+1)+"\t\t"+B[j]+"\t\t\t"+wait);
					WT[k]=wait;
					total+=wait;
					wait+=B[j];
				}
			}
		}
		System.out.println("The average waiting time is: "+(total/n));
	}
}

