import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomExecutor {
    ThreadPoolExecutor executor;
    PriorityBlockingQueue<Task> taskQueue;
    public CustomExecutor(){

        Comparator<Task> comparator = new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o1.compareTo(o2);
            }
        };

        int numOfCores = Runtime.getRuntime().availableProcessors();
        this.executor = new ThreadPoolExecutor(numOfCores / 2, numOfCores - 1, 300, TimeUnit.MILLISECONDS, null);
        taskQueue = new PriorityBlockingQueue<>(10, comparator);
    }
    public void addTask(Task task){
        taskQueue.add(task);
    }
    public void addTask(Callable task, TaskType taskType){
        Task newTask = new Task(taskType, task);
        taskQueue.add(newTask);
    }
    public void addTask(Callable task){
        Task newTask = new Task(task);
        taskQueue.add(newTask);
    }
    public void executeFirst(){
    }
    //PriorityQueue<E> pq = new PriorityQueue(int initialCapacity, Comparator<E> comparator);
}
