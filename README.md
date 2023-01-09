# Object Oriented Programing: Asignment 2
This assignment was divided into two parts:
1. Counting number of lines in text files using main thread, multithreading and threadpool
2. Implementing an Executor using Enums to orient the task order in the queue

## Table of Contents

- Explanation
- Class Diagram
- Installation
- Tests
- Conclusion

### Explanation

#### Part one

The class "Ex2_1" is used to create n text files that each contain a different number of lines and by using only the main thread, counting those lines and returning the sum.

The class "textThread" represents a thread and has a String that holds the name of a text file and an int that will hold the number of lines. the run() method in this class will open the said text file and count the lines within it.

The "Counter" class is used to define a new array of textTheads, to each it will assign a file name and will later sum the number of lines each textThread counted in it's file. 




#### Part two

In this part of the assignment, we were asked to implenent an Executor. we were given an Enum class that has three possible values: COMPUTATIONAL, IO and OTHER.

The class "Task" has the parameter types TaskType, Future<T> and Callable<T> and it inherits the interfaces Callable and Comparable. This class will later be used to represent a Callable task in the priority queue and the TaskType will be used to prioritize it.
  
The class "CustomExecutor" has the parameter types ThreadPoolExecutor and PriorityBlockingQueue<Runnable>. The user can submit tasks to an instance of CustomExecutor with a Callable<T>, Callable<T> and TaskType or with an instance of Task. The submit method will return the Task instance that is submitted to the ThreadPoolExecutor and can later be used to extract the Future value of that Task and ultimately, the return value.
