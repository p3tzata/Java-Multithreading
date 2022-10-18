package app_cyclicBarrier;

import java.util.concurrent.TimeUnit;

class Computation2 implements Runnable 
{ 
    public static int sum = 0; 
    public void run() 
    { 
        // check if newBarrier is broken or not 
        System.out.println("Is the barrier broken? - " + Tester.newBarrier.isBroken()); 
        sum = 10 + 20; 
        try
        { 
            Tester.newBarrier.await(3000, TimeUnit.MILLISECONDS); 
          
            // number of parties waiting at the barrier 
            System.out.println("Number of parties waiting at the barrier "+ 
            "at this point = " + Tester.newBarrier.getNumberWaiting()); 
        }  
        catch (Exception e)  
        { 
            e.printStackTrace(); 
        }  
        
    } 
} 
