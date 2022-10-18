package app_cyclicBarrier;

class Computation1 implements Runnable 
{ 
    public static int product = 0; 
    public void run() 
    { 
        product = 2 * 3; 
        try
        { 
            Tester.newBarrier.await(); 
        }  
        catch (Exception e)  
        { 
            e.printStackTrace(); 
        } 
    } 
} 