package EX_2_1;

/**
 * This class is responsible for holding a counter for the number of lines are in each file contained in a list.
 * @numOfLines The field used to store the lines in after running the class' getNumOfLinesThreads() method.
 */
public class Counter {

    private int numOfLines;

    /**
     * A constructor for Counter class.
     */
    Counter() { this.numOfLines = 0; }

    /**
     * This method creates a Thread for each file in fileNames that sums the number of lines read.
     * and returns the number of lines in them.
     * @param fileNames A String array containing file names.
     * @return The total number of lines in all files.
     * @throws Exception
     */
    public int getNumOfLinesThreads(String[] fileNames)
    {
        int numOfFiles = fileNames.length;

        textThread [] textThreads = new textThread[numOfFiles];

        for( int i=0; i<numOfFiles; i++)
        {
            textThreads[i] = new textThread(fileNames[i]);
            textThreads[i].start();
        }

        int numOfLines = 0;

        for( int i=0; i<numOfFiles; i++ )
        {
            try
            {
                textThreads[i].join();
                numOfLines += textThreads[i].numOfLines;
            }
            catch ( InterruptedException ie ) { ie.printStackTrace(); }
        }

        this.numOfLines = numOfLines;
        return this.numOfLines;
    }
}

