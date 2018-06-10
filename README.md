# nqueens-java

Given a board of height and width `N`, place `N` queens on the board such that no queen is threatenend by any other queen. As an added challenge, make sure that any three or more pieces do not form a line. This will be referred to as the `no-three-in-line` constraint throught the project.

For example, three queens `A` at `(1,1)`, `B` at `(2,3)` and `C` at `(3,5)` do not threaten each other, but they do form a line because the slope of `A` and `B` is equal to the slope of `B` and `C`. This violates the `no-three-in-line` constraint and would be consider as part of a solution. If `C` were located at `(3,6)` then these three pieces would not violate the constaint.

## Calculate no-three-in-line

Give three points, compare the slope of three points as follows:

```
(y1 - y0) / (x1 - x0) == (y2 - y1) / (x2 - x1)

```

There are two issues to watch out for with this formula: division by zero and floating point comparison.

We can rearrange the formula to eliminate these issues:

```
(x0 - x1) * (y0 - y2) == (x0 - x2) * (y0 - y1)
```


Build the project:

```
$ ./gradlew build
```

#### nqueens-core

The core library for solving the N-Queens problem and the N-Queens problem with the no-three-in-line constraint. It has a series of tests to prevent regressions and confirm that it produces the correct solutions.

Run `nqueens-core` tests:

```
$ ./gradlew clean :nqueens-core:test
$ ./gradlew :nqueens-core:javadoc
```

#### nqueens-cli

A command line wrapper for the `nqueens-core` library.

Examples of using the command line tool:

```
$ ./gradlew :nqueens-cli:run -Paargs="['-help']"
$ ./gradlew :nqueens-cli:run -Paargs="['-n=4']"
$ ./gradlew :nqueens-cli:run -Paargs="['-n=4', '-l']"
$ ./gradlew :nqueens-cli:run -Paargs="['-n=8']"
$ ./gradlew :nqueens-cli:run -Paargs="['-n=8', '-l']"
```

#### nqueens-server

A JSON API wrapper for the `nqueens-core` library.

Run a server at `localhost:8081` that allows you to query for the answer of N-Queens Problem

```
$ ./gradlew :nqueens-server:run
```

In another command line window you can perform a request while it is running.

```
$ curl localhost:8081/nqueens?n=4
```
