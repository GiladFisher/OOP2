package EX_2_1;

import java.io.*;

/**
 * This class is responsible for reading from a single file and returning the number of lines contained in it.
 * @field fileName - a String which is the name of the file it's working on.
 * @field numOfLines - The number of lines in the file ( only valid after run() method ).
 */
public class textThread extends Thread
{
    private String fileName;
    int numOfLines;


    /**
     * A constructor for textThread class.
     * @param fileName - a String which is the name of the file textThread's working on.
     */
    public textThread (String fileName) { this.fileName = fileName; }


    /**
     * An Overriding implementation of the Thread's run() method.
     * In this specific method, we read the file referenced in textThread's fileName,
     * retrieve the number of lines in it and store it in textThread's numOfLines.
     * @return numOfLines
     * @throws Exception when reading the file we can sometimes expect an IOException, so we throw it when necessary.
     */
    @Override
    public void run()
    {
        try {
            int num = 0;

            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while( (line = reader.readLine()) != null ) { num++; }
            reader.close();

            this.numOfLines += num;
        }
        catch (IOException ioe) { ioe.printStackTrace(); }
    }
}
