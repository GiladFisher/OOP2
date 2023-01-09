# Object Oriented Programing: Asignment 2
This assignment was divided into two parts, each with a different goal:
1. Creating files with pseudo-random ammount of lines, and counting the total number of lines using main thread, multithreading and threadpool.
2. Implementing an Executor using Enums to orient the task order by priority in the queue.


## Table of Contents

- Explanation & Class Diagram
- Installation
- Tests


## Explanation

### Part one

The class "Ex2_1" is used to create n text files that each contain a pseudo-randomized number of lines, and counting those lines and returning the sum.
This class also has a main method in it which provides data over the runtime and number of lines printed.

It is done so by 1 method that creates those files, and 3 different methods return the summation of lines:

1) createTextFiles() - creates n text files, with a pseudo randomized number of lines up to a given integer.
2) getNumOfLines() - a static method in Ex2_1 class, that count each of the created files' lines one after the other. Basically, the naive solution to our goal.
3) getNumOfLinesThreads() - A method in Counter class, that creates a thread for each file, each returning the number of lines in the file, and returns the summation of them.
4) getNumOfLinesThreadPool() - A method in ThreadPool class, that creates an ExecutorService which is responsible for creating and managing threads that each return the number of lines in a given file.

#### The Classes:

The class "textThread" represents a thread and has a String that holds the name of a text file and an int that will hold the number of lines. the run() method in this class will open the said text file and count the lines within it.

The "Counter" class is used to define a new array of textTheads, to each it will assign a file name and will later sum the number of lines each textThread counted in it's file. 

The "Task" implements Callable<Integer> and holds the fileName and the nuber of lines. The call() method works like the run() method in textThread and puts the result in the fileName parameter.

The class "ThreadPool" has an instance of ExecutorService and an int numOfLines. it can find the sum of the number of lines of all of the files by creating an array, the size of n, of Future objects and initializes them by submitting each Task instance to the ExecutorService instance (each Task has a name of a different file)
It will then sum out the numbers that eac of the Future objects hold to give us the total number of lines in all of the files combined.
  
#### UML Diagram
  
![Screenshot 2023-01-08 115802](https://user-images.githubusercontent.com/117165853/211407012-47978b71-4d09-44e9-bd8e-7d177a983963.png)

#### Run Time of Each Method:
  
The pseudo-randomization of the number of lines in each file is done with a Random object. 
We tested the run time of retrieving the number of lines from 2000 files and up to 2000 lines in each of them and with different seeds inputed in the random object.
Each of the 3 methods was stated via the main method in Ex2_1, and the results state as shown:

Test 1 (seed = 1):

![test1](https://user-images.githubusercontent.com/117165853/211409860-dfd5e52d-568f-4397-b911-b513f9a0d2e4.png)

  
Test 2 (seed = 2):

![test2](https://user-images.githubusercontent.com/117165853/211409871-0b933b4a-84b2-495d-bf93-36ca8b040320.png)

Test 3 (seed = 3):
  
![test3](https://user-images.githubusercontent.com/117165853/211409891-84bdf055-9c15-4aea-87f2-82ecd71361d0.png)

 
As we expected, method no. 2 always takes the longest to return the value at around 7 seconds.
Methods no. 3,4 are showing similar results, always taking aroud 0.2-0.3 seconds in retrieving the value.

Therfore, we can conclude that methods 3,4 are the best in time complexity for handling our goal in part 1.


### Part two

In this part of the assignment, we were asked to implenent an Executor. we were given an Enum class that has three possible values: COMPUTATIONAL, IO and OTHER.
These values are given a priority by that order. The Executor then manages threads made according to the number of cores the user has, meaning at least half of them will have a thread assigned to them and up to -1 of the number of cores.
  
#### The Classes


The "Task" class has the parameter types TaskType, Future<T> and Callable<T> and it inherits the interfaces Callable and Comparable. This class will later be used to represent a Callable task in the priority queue and the TaskType will be used to prioritize it.
  
The "CustomExecutor" class has the parameter types ThreadPoolExecutor and PriorityBlockingQueue<Runnable>. The user can submit tasks to an instance of CustomExecutor with a Callable<T>, Callable<T> and TaskType or with an instance of Task. The submit method will return the Task instance that is submitted to the ThreadPoolExecutor and can later be used to extract the Future value of that Task and ultimately, the return value.
  
#### UML Diagram  
  
![Screenshot 2023-01-09 202600](https://user-images.githubusercontent.com/117165853/211407121-3338ffd8-fbcc-43c9-817e-2d79e71a4835.png)

  
## Installation

To run this project you will specifically need Java 17. For the "Tests" file you will also need JUnit5.8.1 and "Maven" Framework.
  
## Tests
  
The test file "Tests" was given by the course staff, available for inspection in our repository.

