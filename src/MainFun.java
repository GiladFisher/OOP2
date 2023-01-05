import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

public class MainFun {
    public static void main(String[] args) throws Exception {
        Callable<Integer> call = () -> {
            System.out.println("Hello");
            return 1;
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
        CustomExecutor executor = new CustomExecutor();
//        executor.addTask(call, TaskType.COMPUTATIONAL);
        executor.addTask((Callable) () -> {System.out.println("1"); return 1;});
        executor.addTask(() -> {System.out.println("2"); return 1;});
        executor.addTask(() -> {System.out.println("3"); return 1;});
        executor.addTask(() -> {System.out.println("4"); return 1;});
        executor.addTask((Callable)() -> {System.out.println("5"); return 1;});
        executor.addTask(() -> {System.out.println("6"); return 1;});
        executor.addTask(() -> {System.out.println("7"); return 1;});
        executor.addTask(() -> {System.out.println("8"); return 1;});
        executor.addTask(() -> {System.out.println("9"); return 1;});
        executor.addTask(() -> {System.out.println("10"); return 1;});
        executor.addTask(() -> {System.out.println("11"); return 1;});
//        executor.addTask(() -> {System.out.println("12");});
//        executor.addTask(() -> {System.out.println("13");});
//        executor.addTask(() -> {System.out.println("14");});
//        executor.addTask(() -> {System.out.println("15");});
//        executor.addTask(() -> {System.out.println("16");});
//        executor.addTask(() -> {System.out.println("17");});

        executor.executor.shutdown();



    }
}
