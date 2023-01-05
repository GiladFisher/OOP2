import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomExecutor {
    ThreadPoolExecutor executor;
    PriorityBlockingQueue<Runnable> taskQueue;


    public CustomExecutor(){

        int numOfCores = Runtime.getRuntime().availableProcessors();
        this.taskQueue = new PriorityBlockingQueue<>();

        this.executor = new ThreadPoolExecutor(numOfCores / 2, numOfCores - 1, 300, TimeUnit.MILLISECONDS, this.taskQueue);

    }
    public void addTask(Task task){
        executor.submit(task);
    }
    public void addTask(Callable task, TaskType taskType){
        Task newTask = new Task(taskType, task);
        executor.submit(newTask);
    }
    public void addTask(Callable task){
        Task newTask = new Task(task);
        executor.submit(newTask);
    }
    public void executeFirst(){
    }
    //PriorityQueue<E> pq = new PriorityQueue(int initialCapacity, Comparator<E> comparator);
}
