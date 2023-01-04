import java.util.Comparator;
import java.util.concurrent.Callable;
import java.util.concurrent.PriorityBlockingQueue;

public class MainFun {
    public static void main(String[] args) throws Exception {
        Callable<Integer> call = () -> {
            return 7;
        };

        Task task;

        Comparator<Task> comparator = new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o1.compareTo(o2);
            }
        };

        PriorityBlockingQueue<Task> taskQueue = new PriorityBlockingQueue<>(10, comparator);
        task = new Task(TaskType.COMPUTATIONAL, () -> {return 7;});
        task.setPriority(7);
        taskQueue.add(task);
        task = new Task(TaskType.IO, () -> {return 3;});
        task.setPriority(3);
        taskQueue.add(task);
        task = new Task(TaskType.OTHER, () -> {return 5;});
        task.setPriority(5);
        taskQueue.add(task);
        task = new Task(TaskType.COMPUTATIONAL, () -> {return 9;});
        task.setPriority(9);
        taskQueue.add(task);
        task = new Task(TaskType.IO, () -> {return 1;});
        task.setPriority(1);
        taskQueue.add(task);
        task = new Task(TaskType.OTHER, () -> {return 10;});
        task.setPriority(10);
        taskQueue.add(task);
        task = new Task(TaskType.COMPUTATIONAL, () -> {return 2;});
        task.setPriority(2);
        taskQueue.add(task);


        Task temp = taskQueue.poll();
        temp = taskQueue.poll();
        temp = taskQueue.poll();
        temp = taskQueue.poll();
        temp = taskQueue.poll();
        temp = taskQueue.poll();
        temp = taskQueue.poll();


//        taskQueue.add(Task.createTask(() -> {return 3;}, 3));
//        taskQueue.add(Task.createTask(() -> {return 5;}, 5));
//        taskQueue.add(Task.createTask(() -> {return 4;}, 4));
//        taskQueue.add(Task.createTask(() -> {return 6;}, 6));
//        taskQueue.add(Task.createTask(() -> {return 2;}, 2));

    }
}
