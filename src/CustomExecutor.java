import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.*;

public class CustomExecutor {
    ThreadPoolExecutor executor;
    PriorityBlockingQueue<Runnable> taskQueue;
    PriorityQueue<Integer> reversePriorityQueue;

    public CustomExecutor(){

        int numOfCores = Runtime.getRuntime().availableProcessors();
        this.taskQueue = new PriorityBlockingQueue<>();

        this.executor = new ThreadPoolExecutor(numOfCores / 2, numOfCores - 1,
                                        300, TimeUnit.MILLISECONDS, this.taskQueue);
        reversePriorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
    }
    public <T> Task<T> submit(Task task){
        Future future = executor.submit(task);
        task.setFuture(future);
        reversePriorityQueue.add(task.getPriority());
        return task;
    }
    public <T> Task<T> submit(Callable task, TaskType taskType){
        Task newTask = new Task(taskType, task);
        reversePriorityQueue.add(newTask.getPriority());
        Future future = executor.submit(newTask);
        newTask.setFuture(future);
        return newTask;
    }
    public <T> Task<T> submit(Callable task){
        Task newTask = new Task(task);
        reversePriorityQueue.add(newTask.getPriority());
        executor.submit(newTask);
        return newTask;
    }
//    public <T> executeFirst(){
//        if (taskQueue.isEmpty()){return;}
//        Task task = (Task) taskQueue.poll();
//        reversePriorityQueue.remove(task.getPriority());
//        return task.call();
//
//        reversePriorityQueue.remove(executor.getQueue().peek().getPriority());
//        return execute(taskQueue.poll());
//    }

    public int getCurrentMax() {
        if (reversePriorityQueue.isEmpty()) return 0;
        return reversePriorityQueue.peek();
    }
}
