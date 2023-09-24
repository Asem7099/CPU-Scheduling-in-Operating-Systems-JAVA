package lfg;
import java.util.Scanner;

public class LFG {

    public static void main(String[] args) {
      Scanner s=new Scanner(System.in);  
       int j,k;  
       float m=0;
       int x[]=new int[7];
       String operator="";
       
     System.out.println("Enter value of X0");
     x[0]=s.nextInt();
     
     System.out.println("Enter value of X1");
     x[1]=s.nextInt();
        
     System.out.println("Enter value of M");
     m=s.nextInt();
     
     System.out.println("Enter value of K");
     k=s.nextInt();
     
     System.out.println("Enter value of J");
     j=s.nextInt();
       
     System.out.println("Select binary operator (+, -, *, AND, OR, XOR)"); 
     operator=s.next(); 
     
     
     switch(operator)
     {
         case "+":
                   for(int i=2; i<x.length; i++)
                    {
                     x[i]=x[i-j] + x[i-k];
                     
                     while(x[i]>m){
                     x[i]=(int) (x[i]-m);
                     }
                    }            
         break;
             
         case"-":
             for(int i=2; i<x.length; i++)
                    {
                     x[i]=x[i-j] - x[i-k]; 
                     
                     while(x[i]>m){
                     x[i]=(int) (x[i]-m);
                     }
                    }
         break;
             
         case"*":
             for(int i=2; i<x.length; i++)
                    {
                     x[i]=x[i-j] * x[i-k];
                     
                     while(x[i]>m){
                     x[i]=(int) (x[i]-m);
                     }
                    }
         break;
         
         case"AND":
         case"and":
             for(int i=2; i<x.length; i++)
                    {
                     x[i]=x[i-j] & x[i-k];
                     
                     while(x[i]>m){
                     x[i]=(int) (x[i]-m);
                     }
                    }
                     
         break;
             
         case"OR":
         case"or":    
         for(int i=2; i<x.length; i++)
                    {
                     x[i]=x[i-j] | x[i-k];
                     
                     while(x[i]>m){
                     x[i]=(int) (x[i]-m);
                     }
                    }
                     
         break;
             
         case"XOR":
         case"xor":
             for(int i=2; i<x.length; i++)
                    {
                     x[i]=x[i-j] ^ x[i-k];
                     
                     while(x[i]>m)
                      {
                       x[i]=(int) (x[i]-m);
                      }
                    }            
     }
     
     
     System.out.println("Xn_____________Rn");
     
      for(int y=0;y<x.length;y++){
      System.out.println(x[y]+"           "+x[y]/m);
      }
    }
    
}
