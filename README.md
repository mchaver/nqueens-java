# nqueens-java



```
$ ./gradlew build
```

#### nqueens-core

The core library for solving the N-Queens problem and the N-Queens problem with the no-three-in-line constraint. It has a series of tests to prevent regressions and confirm that it produces the correct solutions.

```
$ ./gradlew clean :nqueens-core:test
$ ./gradlew :nqueens-core:javadoc
```

#### nqueens-cli

A command line wrapper for the `nqueens-core` library.

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
