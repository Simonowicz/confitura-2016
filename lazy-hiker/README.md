# Explanation of the solution

This problem can be described as the problem of finding optimal path in the graph. Since it is required to return all the best possibilities, full search of search space was required. Depth first search algorithm was used for that purpose. The algorithm tries to go as deep as it can in a single branch before backtracking. The solution guarantees that all best routes will be found. 

# Execution guide

This is applies for all the tasks. An empty line line in System.in is required after all the content of M x N tables for both lazy-hiker and prime-tables problems. The reason for that is that README does not specify anything about the amount of rows of the table being passed as the first parameter so it is not possible to know whether to wait for the next line or the whole was table already passed.

There are several options on how to run the program:

1. Use Bootstrap.main() method from IDE. Gradle project should be fully functional in any IDE after importing and each task has its own Bootstrap class with main() method, so it should be rather easy to execute.
 
2. Use spock test. It does not necessarily match all the requirements listed in README, but spock is cool, easy to use and the infrastructure is ready.

3. Use gradle wrapper to build the project and run jars using java -jar. There are two gradlew scripts, gradlew for UNIX environments and gradlew.bat for Windows. Execute ./gradlew (or .bat) clean jar and as a result there should be build/lib folder for each module. Jars created in directories of all 3 modules are ready to execute through java -jar, for instance java -jar layered-tree-0.0.1-SNAPSHOT.jar. 