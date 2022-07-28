package exam2;

public class App {

	public static void main(String[] args) {
		Thread runner1 =  new Thread(new Runner());
		runner1.start();
		
		Thread runner2 =  new Thread(new Runner());
		runner2.start();
	}

}
