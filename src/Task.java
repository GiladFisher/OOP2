import java.util.concurrent.Callable;

public class Task<T> implements Comparable<T>, Callable<T> {
    private final TaskType taskType;
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

    // factory method that creates a task using only a callable object and a priority
    public static Task createTask(Callable task, int priority){
        TaskType taskType = TaskType.OTHER;
        try{
            taskType.setPriority(priority);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return null;
        }
        return new Task(taskType, task);
    }
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
}
