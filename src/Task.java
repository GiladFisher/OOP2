import java.util.concurrent.*;

public class Task<T> implements Comparable<T>, Callable<T> {
    private final TaskType taskType;
    private Callable<T> task;

    private Future<T> future;

    /**
     * Constructor for Task
     * @param taskType the type of the task (enum)
     * @param task the callable task to be executed
     */
    public Task(TaskType taskType, Callable<T> task){
        this.taskType = taskType;
        this.task = task;
    }

    /**
     * Constructor for Task
     * @param task the callable task to be executed
     */
    public Task(Callable<T> task){
        this.taskType = TaskType.OTHER; // Default task type
        this.task = task;
    }

    /**
     * This is a Factory method for Task
     * @param call the callable task to be executed
     * @param type the type of the task (enum)
     * @param <T> the type of the return value of the callable object
     * @return Task object
     */
    public static <T> Task<T> createTask(Callable<T> call, TaskType type) {
        return new Task<>(type, call);
    }

    /**
     * resets the Callable object of the task
     * @param task the callable task to be executed
     */
    public void setTask(Callable<T> task){
        this.task = task;
    }

    /**
     * This method lets the BlockingQueue know which task has the higher priority
     * @param o the object to be compared.
     * @return the difference between the priorities of the two tasks' priorities
     */
    @Override
    public int compareTo(T o) {  // by taskTypePriority
        return this.taskType.getPriorityValue() - ((Task<T>)o).taskType.getPriorityValue();
    }
    /**
     * This method is used to get the priority of the task
     * @return the priority of the task
     */
    public TaskType getTaskType(){ // return taskType
        return taskType;
    }
    /**
     * This method is used to get the priority of the task
     * @return numeral value of the priority of the task
     */
    public int getPriority(){ // return taskTypePriority
        return taskType.getPriorityValue();
    }

    /**
     * This will set th numeral value of the priority of all the tasks with the same type
     * @param priority the desired new numeral value of the type of the task
     */
    public void setPriority(int priority){ // set taskTypePriority
        try {
            taskType.setPriority(priority);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * This method runs the task and returns the result, may throw an exception
     * @return the result of the task
     * @throws Exception if unable to complete the task
     */
    @Override
    public T call() throws Exception {
        return task.call();
    }
    /**
     * This method is used to get the future object of the task
     * @return the future object of the task
     */
    public Future<T> getFuture(){
        return future;
    }

    /**
     * This method is used to set the future object of the task
     * @param future the future object of the task
     */
    public void setFuture(Future<T> future){
        this.future = future;
    }

    /**
     * This method is used to get the result of the task
     * @return Future object, the result of the task
     * @throws InterruptedException if the thread is interrupted
     * @throws ExecutionException if the task is unable to complete
     */
    public T get() throws InterruptedException , ExecutionException {
        return future.get();
    }
    /**
     * This method is used to get the result of the task with a timeout
     * @param unit, the time unit to wait num of for the task to complete
     * @param num, the time to wait for the task to complete
     * @return Future object, the result of the task
     * @throws InterruptedException if the thread is interrupted
     * @throws InterruptedException if the thread is interrupted
     * @throws ExecutionException if the task is unable to complete
     */
    public T get(long num, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return future.get(num, unit);
    }
}
