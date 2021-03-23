package multithreading_task2;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyCallable implements Callable {

    String name;
    int callCount;

    public MyCallable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {

        Random random = new Random();

        for (int i = 0; i < random.nextInt(100); i++) {
            callCount += 1;
        }

        return "Привет. Я поток " + getName() + ".  Количество вызовов " + callCount;
    }

}

