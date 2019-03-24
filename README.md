# akka-http-starter-kit
Hello World example using Akka Http.

## Dev
```
$ cd akka-http-starter-kit
$ sbt> universal:stage 
```

## Build Package
```
$ cd akka-http-starter-kit
$ sbt> universal:packageBin
```

## Start API Server
```
$ cd target/universal
$ unzip akka-http-starter-kit-1.0-SNAPSHOT.zip
$ cd akka-http-starter-kit-0.1.0-SNAPSHOT
$ bin/start.sh
$ tail -f logs/stdout.log
```

## Test
```
$ curl http://127.0.0.1:8080/
Hello World!
```
