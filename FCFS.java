package fcfs;
 
import java.util.Scanner;

public class FCFS {
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number of process: ");
		int n = scan.nextInt();
		int[] pID = new int[n];         // IDs
		int arT[] = new int[n];         // arrival time
		int bT[] = new int[n];          // burst time
		int cT[] = new int[n];          // completion time
		int taT[] = new int[n];         // turn around time
		int wT[] = new int[n];          // waiting time 
		int temp;
		float avgWT=0,avgtaT=0;
 
		for(int i = 0; i < n; i++)
		{
			System.out.println("Enter process " + (i+1) + " arrival time: ");
			arT[i] = scan.nextInt();
			System.out.println("Enter process " + (i+1) + " brust time: ");
			bT[i] = scan.nextInt();
			pID[i] = i+1;
		}
 

		for(int i = 0 ; i <n; i++)
		{
			for(int  j=0;  j < n-(i+1) ; j++)
			{
				if( arT[j] > arT[j+1] )
				{
					temp = arT[j];
					arT[j] = arT[j+1];
					arT[j+1] = temp;
                                        
					temp = bT[j];
					bT[j] = bT[j+1];
					bT[j+1] = temp;
                                        
					temp = pID[j];
					pID[j] = pID[j+1];
					pID[j+1] = temp;
				}
			}
		}
		
                
		for(int  i = 0 ; i < n; i++)
		{
			if( i == 0)
			{	
				cT[i] = arT[i] + bT[i];
			}
			else
			{
				if( arT[i] > cT[i-1])
				{
					cT[i] = arT[i] + bT[i];
				}
				else
					cT[i] = cT[i-1] + bT[i];
			}
			taT[i] = cT[i] - arT[i] ;       // turn around time= completion time- arrival time
			wT[i] = taT[i] - bT[i] ;        // waiting time= turn around time- burst time
			avgWT += wT[i] ;                // total waiting time
			avgtaT += taT[i] ;              // total turn around time
		}
		
		System.out.println("pID  arrival  brust  complete turn waiting");
		for(int  i = 0 ; i< n;  i++)
		{
			System.out.println(pID[i] + "  \t " + arT[i] + "\t" + bT[i] + "\t" + cT[i] + "\t" + taT[i] + "\t"  + wT[i] ) ;
		}
		System.out.println("Average waiting time: "+ (avgWT/n));       
		System.out.println("Average turnaround time:"+(avgtaT/n));      
	}
}