Profiler
========

A very useful tool for measuring the duration and order of processes in your java applications.

To get started:
-------

Put this at the start of your program:
```
Profiler.startProfiler(Logger.LogLevel.INFO);
```
_You can choose between the following log levels:_
- ALL
- DEBUG
- INFO
- WARNING
- ERROR
- CRITICAL

_Only log entries with the same or a higher log level (priority) will be logged._

<hr>

This should be standing at the end of your program:
```
Profiler.stopProfiler();
```

<hr>

For each process you want to measure the duration of, use this:
```
Profiler.start("Process1");
  //Process
Profiler.stop("Process1");
```
_Note that "Process1" is only a placeholder for the name you want to give your process. It has to match in the `start` and  `stop` statement._
