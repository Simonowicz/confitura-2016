# Explanation of the solution

Problem was solved using self developed algorithm. It has O(n) = n log(n) time complexity because sorting of integers providing is required to execute the algorithm. After the list of integers is sorted, populating the tree takes linear time as it is known at that point where the value should land on the tree.

# Execution guide

This is applies for all the tasks. There are several options on how to run the program.

1. Use Bootstrap.main() method from IDE. Gradle project should be fully functional in any IDE after importing and each task has its own Bootstrap class with main() method, so it should be rather easy to execute.
 
2. Use spock test. It does not necessarily match all the requirements listed in README, but spock is cool, easy to use and the infrastructure is ready.

3. Use gradle wrapper to build the project and run jars using java -jar. There are two gradlew scripts, gradlew for UNIX environments and gradlew.bat for Windows. Execute ./gradlew (or .bat) clean jar and as a result there should be build/lib folder for each module. Jars created in directories of all 3 modules are ready to execute through java -jar, for instance java -jar layered-tree-0.0.1-SNAPSHOT.jar. 