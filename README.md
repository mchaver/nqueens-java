# nqueens-java

```
$ ./gradlew build
```

#### nqueens-core
```
$ ./gradlew clean :nqueens-core:test
$ ./gradlew :nqueens-core:javadoc
```

#### nqueens-cli
```
$ ./gradlew :nqueens-cli:run -Paargs="['-help']"
$ ./gradlew :nqueens-cli:run -Paargs="['-n=4']"
$ ./gradlew :nqueens-cli:run -Paargs="['-n=4', '-l']"
$ ./gradlew :nqueens-cli:run -Paargs="['-n=8']"
$ ./gradlew :nqueens-cli:run -Paargs="['-n=8', '-l']"
```
