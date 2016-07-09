# Explanation of the solution

The solution of this task is provided only with certain probability that it is actually correct. The reason for that is that I used BigInteger.isProbablePrime() method that checks whether certain value is prime number with defined certainty. In my case the certainty of this method providing correct answer equals 0.984375. 

I decided to use this method because verifying whether given number is prime would require significant amount of time for bigger integer values and even in cryptography world usage of probable prime is accepted.

Besides that I believe that the task description provides incorrect answer, since for the data provided, both my algorithm and the solution that I did manually on the sheet of paper indicate that there are in fact 10 prime number sums in sub tables. These are:

Starting at index 0, 0: (row, column)

```
1 1
1 2
```
```
1 1 1
1 2 1 
```
```
1 1
1 2
1 1
```

Starting at index 0, 1:
```
1 1
2 1
```
```
1 1 1
2 1 1
```
```
1 1
2 1
1 1
```

Starting at index 1, 0:
```
1 2
1 1
```
```
1 2 1
1 1 1
```

Starting at index 1, 1:
```
2 1
1 1
```
```
2 1 1
1 1 1
```

I can't find one more sub table that would sum up to prime number. I suspect that the reason for this mistake in provided example solution to the problem is that the check whether given sum is a prime number or not was performed using probability-based method too.

# Execution guide

This is applies for all the tasks. There are several options on how to run the program.

1. Use Bootstrap.main() method from IDE. Gradle project should be fully functional in any IDE after importing and each task has its own Bootstrap class with main() method, so it should be rather easy to execute.
 
2. Use spock test. It does not necessarily match all the requirements listed in README, but spock is cool, easy to use and the infrastructure is ready.

3. Use gradle wrapper to build the project and run jars using java -jar. There are two gradlew scripts, gradlew for UNIX environments and gradlew.bat for Windows. Execute ./gradlew (or .bat) clean jar and as a result there should be build/lib folder for each module. Jars created in directories of all 3 modules are ready to execute through java -jar, for instance java -jar layered-tree-0.0.1-SNAPSHOT.jar. 