##### Running 2 Vanilla Threads - extends Thread
```
Running Thread 1
Running Thread 2
Tick Thread 2 -> 1
Tick Thread 1 -> 1
Tick Thread 1 -> 2
Tick Thread 2 -> 2
Tick Thread 1 -> 3
Tick Thread 2 -> 3
Tick Thread 1 -> 4
Tick Thread 2 -> 4
Tick Thread 2 -> 5
Tick Thread 1 -> 5
Tick Thread 1 -> 6
Tick Thread 2 -> 6
Tick Thread 1 -> 7
Tick Thread 2 -> 7
Tick Thread 1 -> 8
Tick Thread 2 -> 8
Tick Thread 1 -> 9
Tick Thread 2 -> 9
Tick Thread 1 -> 10
Tick Thread 2 -> 10
```
#### Mark a Thread as Daemon
```
Running Thread 1
Running Thread 2
Tick Thread 2 -> 1
Tick Thread 1 -> 1
Tick Thread 2 -> 2
Tick Thread 1 -> 2
Tick Thread 2 -> 3
Tick Thread 1 -> 3
Tick Thread 2 -> 4
Tick Thread 1 -> 4
Tick Thread 2 -> 5
Tick Thread 1 -> 5
Tick Thread 1 -> 6

Process finished with exit code 0
```
Mark Thread 1 as Daemon but also call Join on it
```
Running Thread 1
Running Thread 2
Tick Thread 1 -> 1
Tick Thread 2 -> 1
Tick Thread 1 -> 2
Tick Thread 2 -> 2
Tick Thread 1 -> 3
Tick Thread 2 -> 3
Tick Thread 1 -> 4
Tick Thread 2 -> 4
Tick Thread 2 -> 5
Tick Thread 1 -> 5
Tick Thread 1 -> 6
Tick Thread 1 -> 7
Tick Thread 1 -> 8
Tick Thread 1 -> 9
Tick Thread 1 -> 10

Process finished with exit code 0
```
Throw Runtime Exception in main thread
```
Exception in thread "main" java.lang.RuntimeException
at RunTwoThreadsMainException.main(RunTwoThreadsMainException.java:7)
Running Thread 1
Running Thread 2
Tick Thread 1 -> 1
Tick Thread 2 -> 1
Tick Thread 1 -> 2
Tick Thread 2 -> 2
Tick Thread 2 -> 3
Tick Thread 1 -> 3

Process finished with exit code 1
```