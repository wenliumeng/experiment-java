package thread.name;

public class MyThread0 extends Thread{

	public MyThread0(String name) {
		super(name);
	}

	@Override
	public void run() {
		System.out.println("thread name = " + this.getName());
	}
}
