import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

public class CustomExecutor {
    ThreadPoolExecutor executor;
    PriorityBlockingQueue<Task> taskQueue;
    public CustomExecutor(ThreadPoolExecutor executor){
        this.executor = executor;
        taskQueue = new PriorityBlockingQueue<>(10);
    }
    //PriorityQueue<E> pq = new PriorityQueue(int initialCapacity, Comparator<E> comparator);
}
