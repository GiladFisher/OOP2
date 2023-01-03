import java.util.concurrent.Callable;

public class MainFun {
    public static void main(String[] args) throws Exception {
        Callable<Integer> call = () -> {
            return 7;
        };
        Task<Integer> task = new Task<>(TaskType.COMPUTATIONAL, call);
        System.out.println(task.call());
        System.out.println(task.getPriority());
        System.out.println(task.getTaskType());
    }
}