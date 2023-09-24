package sjf;

import java.util.Scanner;

public class SJF {
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        System.out.println ("Enter number of process:");
        int n = scan.nextInt();
        int pid[] = new int[n];  //Process id
        int at[] = new int[n];   //Arrival time
        int bt[] = new int[n];   //Burst time
        int ct[] = new int[n];   //Completion times
        int ta[] = new int[n];   //Turn around time
        int wt[] = new int[n];   //wating time
        int f[] = new int[n];    

        int st=0, tot=0;
        float avgwt=0, avgta=0;

        for(int i=0;i<n;i++)
        {
            System.out.println ("enter process " + (i+1) + " arrival time:");
            at[i] = scan.nextInt();
            System.out.println ("enter process " + (i+1) + " brust time:");
            bt[i] = scan.nextInt();
            pid[i] = i+1;
            f[i] = 0;
        }


        while(true)
        {
            int c=n, min = 9999;

            if (tot == n)
                break;

            for (int i=0; i<n; i++)
            {

                if ((at[i] <= st) && (f[i] == 0) && (bt[i]<min))
                {
                    min=bt[i];
                    c=i;
                }
            }
            if (c==n)
                st++;
            else
            {
                ct[c]=st+bt[c];
                st+=bt[c];
                ta[c]=ct[c]-at[c];
                wt[c]=ta[c]-bt[c];
                f[c]=1;
                pid[tot] = c + 1;
                tot++;
            }
        }

        System.out.println("\npid   arrival  brust  complete turn  waiting");
        for(int i=0;i<n;i++)
        {
            avgwt+= wt[i];
            avgta+= ta[i];
            System.out.println(pid[i]+"\t"+at[i]+"\t"+bt[i]+"\t"+ct[i]+"\t"+ta[i]+"\t"+wt[i]);
        }
        System.out.println ("\naverage tat is "+ (float)(avgta/n));
        System.out.println ("average wt is "+ (float)(avgwt/n));
        scan.close();
        for(int i=0;i<n;i++)
        {
            System.out.print(pid[i] + " ");
        }
    }
}