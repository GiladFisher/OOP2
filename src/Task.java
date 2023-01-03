import java.util.concurrent.Callable;

public class Task<T> implements Comparable<T>, Callable<T> {
    private TaskType taskType;
    private Callable<T> task = null;
    public Task(TaskType taskType, Callable<T> task){
        this.taskType = taskType;
        this.task = task;
    }
    public Task(TaskType taskType){
        this.taskType = taskType;
    }
    public void setTask(Callable<T> task){
        this.task = task;
    }
    @Override
    public int compareTo(T o) {
        return 0;
    }

    public TaskType getTaskType(){
        return taskType;
    }
    public int getPriority(){
        return taskType.getPriorityValue();
    }

    @Override
    public T call() throws Exception {
        return task.call();
    }
}
