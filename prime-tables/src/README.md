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