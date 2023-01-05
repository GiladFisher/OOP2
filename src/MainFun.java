import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

public class MainFun {
    public static void main(String[] args) throws Exception {
        Callable<Integer> call = () -> {
            return 7;
        };

        Task task;
        // ----------------- PriorityBlockingQueue Tests -----------------
//        Comparator<Task> comparator = new Comparator<Task>() {
//            @Override
//            public int compare(Task o1, Task o2) {
//                return o1.compareTo(o2);
//            }
//        };
//
//        PriorityBlockingQueue<Task> taskQueue = new PriorityBlockingQueue<>();//10, comparator
//        task = new Task(TaskType.COMPUTATIONAL, () -> {return 7;});
//        task.setPriority(7);
//        taskQueue.add(task);
//        task = new Task(TaskType.IO, () -> {return 3;});
//        task.setPriority(3);
//        taskQueue.add(task);
//        task = new Task(TaskType.OTHER, () -> {return 5;});
//        task.setPriority(5);
//        taskQueue.add(task);
//        task = new Task(TaskType.OTHER2, () -> {return 9;});
//        task.setPriority(9);
//        taskQueue.add(task);
//        task = new Task(TaskType.OTHER3, () -> {return 1;});
//        task.setPriority(1);
//        taskQueue.add(task);
//        task = new Task(TaskType.OTHER4, () -> {return 10;});
//        task.setPriority(10);
//        taskQueue.add(task);
//        task = new Task(TaskType.OTHER5, () -> {return 2;});
//        task.setPriority(2);
//        taskQueue.add(task);
//
//
//        Task temp = taskQueue.poll();
//        temp = taskQueue.poll();
//        temp = taskQueue.poll();
//        temp = taskQueue.poll();
//        temp = taskQueue.poll();
//        temp = taskQueue.poll();
//        temp = taskQueue.poll();

        // ----------------- ThreadPoolExecutor Tests -----------------
//        CustomExecutor executor = new CustomExecutor();
//        executor.addTask(call, TaskType.COMPUTATIONAL);
//        short i = 0;
//        executor.executor.shutdown();
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        q.add(1);
        q.add(2);
        q.add(67);
        q.add(3);
        q.add(20);
        q.add(4);
        q.add(5);
        q.add(22);
        q.remove(4);
        while (!q.isEmpty()) {
            System.out.println(q.poll());
        }

    }
}
