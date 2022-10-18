package app_cyclicBarrier;

public class App_cyclicBarrier {
	
	  public static void main(String[] args) 
	    { 
	        // parent thread 
	        Tester test = new Tester(); 
	          
	        Thread t1 = new Thread(test); 
	        t1.start(); 
	    } 

}
