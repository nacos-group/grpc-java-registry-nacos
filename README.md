# grpc-nacos-java

this is common way of GRPC Nacos Java integration. Please feel free to add more features with this repo by sending pull requests and raising a issue.

## Features

* grpc client usage
* grpc server builder and starter
* integrate with [Nacos](https://github.com/alibaba/nacos)
* Automatic service registration and discovery
* Round robin LoadBalancer which supported by Grpc

## Building

You may clone this project and step into grpc-nacos-java sub directory before read on.

```bash
# git clone https://github.com/Moriadry/grpc-nacos-java
# cd grpc-nacos-java
```

Run the following command to build the project(Java 1.8 is required to build the master branch).

```
  mvn clean compile
```

## Getting started by demo


#### Step 1: Start nacos server

Start a [Nacos naming server](https://github.com/alibaba/nacos#quick-start) is a must.

#### Step 2: Start grpc server

```bash
cd grpc-nacos-java-starter
mvn exec:java@server-test
```

### Step 3: Start grpc client

```bash
mvn exec:java@client-test
```



