package thread.name;

public class MyThread extends Thread{

	@Override
	public void run() {
		System.out.println("thread name = " + this.getName());
	}
}
