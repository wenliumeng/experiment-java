package thread.name;

public class Run2 {

	public static void main(String[] args) {
		Mythread2 myThread2 = new Mythread2();
		System.out.println("begin = "+System.currentTimeMillis());
		myThread2.start();
		System.out.println("end = " + System.currentTimeMillis());
	}
}
