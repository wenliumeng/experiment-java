package javathread;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * 任务返回值
 * Created by seyMour on 2017/1/17.
 */
public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            results.add(exec.submit(new TaskWithResult(i)));
        for (Future<String> future : results)
            try {
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            } finally {
                exec.shutdown();
            }
    }
}

class TaskWithResult implements Callable<String> {

    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }


    @Override
    public String call() throws Exception {
        return "result of TaskWithResult " + id;
    }
}
