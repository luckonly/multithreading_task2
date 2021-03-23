package multithreading_task2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println("------invokeAll-----------");
        getTasksWithInvokeAll();
        System.out.println("------invokeAny-----------");
        getTasksWithInvokeAny();

    }

    private static void getTasksWithInvokeAny() throws ExecutionException, InterruptedException {

        ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        List<Callable<String>> taskList = new ArrayList<>();

        for (int i = 1; i < 5; i++) {
            Callable<String> myCallable = new MyCallable("Thread" + Integer.toString(i));
            taskList.add(myCallable);
        }

        String taskResult = threadPool.invokeAny(taskList);
        System.out.println(taskResult);
        threadPool.shutdown();

    }

    private static void getTasksWithInvokeAll() throws InterruptedException, ExecutionException {

        ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        List<Callable<String>> taskList = new ArrayList<>();

        for (int i = 1; i < 5; i++) {
            Callable<String> myCallable = new MyCallable("Thread" + Integer.toString(i));
            taskList.add(myCallable);
        }

        List<Future<String>> newList = threadPool.invokeAll(taskList);

        for (Future<String> task : newList) {
            System.out.println(task.get());
        }

        threadPool.shutdown();

    }


}
