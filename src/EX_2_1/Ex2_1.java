package EX_2_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.io.File;

public class Ex2_1 {

    /**
     * This method creates text files, fills them with a pseudo-random number of lines containing the same string.
     * and returns a String array containing the files' names.
     * In order to pseudo-randomize the number of lines, we import and use a Random object.
     * @param n The number of files to create
     * @param seed The 'id' for the pseudo-randomized set of numbers generated.
     * @param bound The maximum number generated from the Random object.
     * @return String array containing the files' names.
     */
    public static String[] createTextFiles(int n, int seed, int bound)
    {
        String[] fileNames = new String[n];
        Random rand = new Random(seed);

        for(int i=0 ; i<n ; i++)
        {
            try
            {
                BufferedWriter writer = new BufferedWriter(new FileWriter(
                        "MyText" + i + ".txt"));

                int numOfLines = rand.nextInt(bound);

                for(int j=0 ; j<numOfLines ; j++)
                {
                    writer.write("We love Fortnite!\n");
                }
                writer.close();

                fileNames[i] = "MyText" + i + ".txt";
            }

            catch (IOException ioe1) { ioe1.printStackTrace(); }
        }

        return fileNames;
    }

    /**
     * This method gets a String array containing filenames and deletes the files referenced by them.
     * @param fileNames the array containing the file names.
     */
    public static void deleteTextFiles(String[] fileNames)
    {
        for (String fileName : fileNames) { new File(fileName).delete(); }
    }

    /**
     * This method gets a String array of file names, and iterates
     * through every file to sum the number of all lines in the files.
     * @param fileNames - The String array containing the file names.
     * @return The number of lines in all text files combined.
     */
    public static int getNumOfLines(String[] fileNames)
    {
        int num = 0;

        for ( String fileName : fileNames )
        {
            try
            {
                BufferedReader reader = new BufferedReader(new FileReader(fileName));
                while( reader.readLine() != null ) { num++; }
                reader.close();
            }
            catch (IOException ioe) { ioe.printStackTrace(); }
        }

        return num;
    }

    /**
     * The Main method in our exercise,
     * Performing the 3 methods:
     * @Method2: getNumOfLines() in Ex2_1 class.
     * @Method3: getNumOfLinesThreads() in Counter class.
     * @Method4: getNumOfLinesThreadPool() in ThreadPool class.
     */
    public static void main(String[] args)
    {
        String[] fileNames = createTextFiles(2000,2,2000);

        // Running method 2:
        double start = System.currentTimeMillis();
        int num = getNumOfLines(fileNames);
        double end = System.currentTimeMillis();

        double time = (end-start)/1000;
        System.out.println("Method 2 - Run time: "+time+", No. of Lines: "+num);

        Counter counter = new Counter();

        // Running method 3:
        start = System.currentTimeMillis();
        num = counter.getNumOfLinesThreads(fileNames);
        end = System.currentTimeMillis();

        time = (end-start)/1000;
        System.out.println("Method 3 - Run time: "+time+", No. of Lines: "+num);


        // Running method 4:
        ThreadPool threadPool = new ThreadPool(fileNames.length);

        start = System.currentTimeMillis();
        num = threadPool.getNumOfLinesThreadPool(fileNames);
        end = System.currentTimeMillis();

        time = (end-start)/1000;
        System.out.println("Method 4 - Run time: "+time+", No. of Lines: "+num);

        deleteTextFiles(fileNames);
    }
}
