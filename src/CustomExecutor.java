import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.*;

public class CustomExecutor {
    ThreadPoolExecutor executor;
    PriorityBlockingQueue<Runnable> taskQueue;
    PriorityQueue<Integer> reversePriorityQueue;

    /**
     * Constructor for CustomExecutor
     */
    public CustomExecutor(){
        int numOfCores = Runtime.getRuntime().availableProcessors(); // get number of logical cores in the system
        this.taskQueue = new PriorityBlockingQueue<>();
        this.executor = new ThreadPoolExecutor(numOfCores / 2, numOfCores - 1,
                                        300, TimeUnit.MILLISECONDS, this.taskQueue);
        reversePriorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
    }

    /**
     * This method adds a task to the executor
     * @param task the task to be added
     * @return task
     */
    public <T> Task<T> submit(Task<T> task){ // submit a task to the executor and return the task object
        Future<T> future = executor.submit(task); // submit the task to the executor while returning a future object
        task.setFuture(future); // set the future object of the task
        reversePriorityQueue.add(task.getPriority());
        return task;
    }

    /**
        this method is used to submit a callable object to the executor
     * @param task the callable object to be submitted
     * @param <T> the type of the return value of the callable object
     * @param taskType the type of the task
     * @return the task object
     */
    public <T> Task<T> submit(Callable<T> task, TaskType taskType){ // submit a task to the executor and return the task object
        Task<T> newTask = new Task<T>(taskType, task);
        reversePriorityQueue.add(newTask.getPriority());
         Future<T> future = executor.submit(newTask);
        newTask.setFuture(future);
        return newTask;
    }

    /**
     * This method is used to submit a callable object to the executor
     * @param task the callable object to be submitted
     * @param <T> the type of the return value of the callable object
     */
    public <T> void submit(Callable<T> task){
        Task<T> newTask = new Task<T>(task);
        submit(newTask);
    }

    /**
     * This method is used to get the priority of the highest priority value executor pool
     * @return Priority of the highest priority value executor pool
     */
    public int getCurrentMax() {
        if (reversePriorityQueue.isEmpty()) return 0;
        return reversePriorityQueue.peek();
    }

    /**
     * This method is used to terminate the executor while allowing the tasks to finish
     */
    public void gracefullyTerminate(){
        executor.shutdown();
        while (!executor.isTerminated()){
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
