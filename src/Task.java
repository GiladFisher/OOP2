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
    public static Task createTask(Callable task, int priority){
        TaskType taskType = TaskType.OTHER;
        try{
            taskType.setPriority(priority);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return new Task(taskType, task);
    }


    @Override
    public int compareTo(T o) {  // by taskTypePriority
        return this.taskType.getPriorityValue() - ((Task<T>)o).taskType.getPriorityValue();
    }

    public TaskType getTaskType(){
        return taskType;
    }
    public int getPriority(){
        return taskType.getPriorityValue();
    }
    public void setPriority(int priority){
        taskType.setPriority(priority);
    }

    @Override
    public T call() throws Exception {
        return task.call();
    }
}
