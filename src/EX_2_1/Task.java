package EX_2_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Callable;

/**
 * This class is responsible for reading from a single file and returning the number of lines contained in it.
 * @fileName a String which is the name of the file it's working on.
 * @numOfLines The number of lines in the file ( only valid after run() method ).
 */
public class Task implements Callable<Integer>
{
    private String fileName;
    int numOfLines;


    /**
     * A constructor for Task class.
     * @param fileName a String which is the name of the file Task's working on.
     */
    public Task(String fileName) { this.fileName = fileName; }


    /**
     * An Overriding implementation of the Callable's run() method.
     * In this specific method, we read the file referenced in Task's fileName,
     * retrieve the number of lines in it and store it in Task's numOfLines.
     * @return numOfLines
     * @throws Exception when reading the file we can sometimes expect an IOException, so we throw it when necessary.
     */
    @Override
    public Integer call() throws Exception
    {
        try {
            int num = 0;

            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            while( reader.readLine() != null ) { num++; }
            reader.close();

            this.numOfLines += num;
        }
        catch (IOException ioe) { ioe.printStackTrace(); }

        return this.numOfLines;
    }
}
