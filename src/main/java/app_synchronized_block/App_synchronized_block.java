package app_synchronized_block;

import app_run.Runner;

public class App_synchronized_block {


	public static void main(String[] args) throws InterruptedException {
		Worker_UltimatewWrong worker_UltimatewWrong = new Worker_UltimatewWrong();
		Worker_NotGood worker_NotGood = new Worker_NotGood();
		Worker_Good worker_Good = new Worker_Good();
		
		worker_Good.main();
		
		//worker_NotGood.main();
		//worker_UltimatewWrong.main();
		
		
		
	}

	

}
