package annotation;

import java.lang.reflect.Method;

/**
 * xxx
 * Created by seyMour on 2016/8/24.
 * ☞Keenyoda☜
 */
public class TodoTest {

    @Todo(priority = Todo.Priority.MEDIUM,author = "David",status = Todo.Status.STARTED)
    public void incompleteMethod1(){

    }

    public static void main(String[] args) {
        Class businessLogicClass = TodoTest.class;
        for (Method method: businessLogicClass.getMethods()){
            Todo todoAnnotation = method.getAnnotation(Todo.class);
            if(todoAnnotation != null){
                System.out.println("Method Name : " + method.getName());
                System.out.println("Author : " + todoAnnotation.author());
                System.out.println("Priority :" + todoAnnotation.priority());
                System.out.println("Status : " + todoAnnotation.status());
            }
        }
    }
}
