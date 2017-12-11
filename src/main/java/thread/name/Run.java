package thread.name;

public class Run {

	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		Thread thread = new Thread(myThread,"new name");
		thread.start();

		Thread thread1 = new MyThread0("new name");
		thread1.start();
	}
}
