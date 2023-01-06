import java.util.concurrent.*;

public class Task<T> implements Comparable<T>, Callable<T> {
    private final TaskType taskType;
    private Callable<T> task;

    private Future<T> future;
    public Task(TaskType taskType, Callable<T> task){
        this.taskType = taskType;
        this.task = task;
    }
    public Task(Callable<T> task){
        this.taskType = TaskType.OTHER; // Default task type
        this.task = task;
    }

    public static <T> Task<T> createTask(Callable<T> call, TaskType type) {
        return new Task<>(type, call);
    }


    public void setTask(Callable<T> task){
        this.task = task;
    }

    // factory method that creates a task using only a callable object and a priority
//    public static Task createTask(Callable task, int priority){
//        TaskType taskType = TaskType.OTHER;
//        try{
//            taskType.setPriority(priority);
//        }
//        catch (IllegalArgumentException e){
//            System.out.println(e.getMessage());
//            return null;
//        }
//        Task newTask = new Task(taskType, task);
//        return newTask;
//    }
    @Override
    public int compareTo(T o) {  // by taskTypePriority
        return this.taskType.getPriorityValue() - ((Task<T>)o).taskType.getPriorityValue();
    }

    public TaskType getTaskType(){ // return taskType
        return taskType;
    }
    public int getPriority(){ // return taskTypePriority
        return taskType.getPriorityValue();
    }
    public void setPriority(int priority){ // set taskTypePriority
        try {
            taskType.setPriority(priority);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
    @Override
    public T call() throws Exception {
        return task.call();
    }
    public Future<T> getFuture(){
        return future;
    }
    public void setFuture(Future<T> future){
        this.future = future;
    }
    public T get() throws InterruptedException , ExecutionException {
        return future.get();
    }
    public T get(long num, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return future.get(num, unit);
    }
}
