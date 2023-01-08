package EX_2_1;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * This class makes use of a fixed ThreadPool, which holds and manages a unique task for each file in a file list
 * that sums the number of lines in it. After all tasks are done, this class sums all the returned values from each task and returns the summation.
 * @pool A threadPool object instance managing the tasks.
 * @numOfLines Stores the summed number of lines when all tasks are done.
 */
public class ThreadPool {

    private ExecutorService pool;
    private int numOfLines;


    /**
     * A constructor for ThreadPool class.
     * @param numOfFiles - The number of files that ThreadPool needs to manage.
     */
    public ThreadPool(int numOfFiles)
    {
        this.numOfLines = 0;
        this.pool = Executors.newFixedThreadPool(numOfFiles);
    }


    /**
     * This method creates a Future for each task that will store a task's returned value (the number of lines in the file it's working on).
     * @param fileNames A String array containing the file names, while each file will have a new task made for it.
     * @return The number of lines of all files.
     * @throws Exception If submitting the task fails, an exception will be thrown.
     */
    public int getNumOfLinesThreadPool(String[] fileNames)
    {
        int numOfFiles = fileNames.length;

        Future<Integer> [] future = new Future[numOfFiles];

        for(int i=0 ; i<numOfFiles ; i++) { future[i] = pool.submit( new Task(fileNames[i]) ); }

        for(int i=0 ; i<numOfFiles ; i++)
        {
            try                 { numOfLines += future[i].get(); }
            catch (Exception e) { e.printStackTrace(); }
        }

        pool.shutdown();

        return this.numOfLines;
    }
}
