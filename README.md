# grpc-nacos-java

this is common way of GRPC Nacos Java integration. Please feel free to add more features with this repo by sending pull requests and raising a issue.

## Features

* grpc client usage
* grpc server builder and starter
* integrate with [Nacos](https://github.com/alibaba/nacos)
* Automatic service registration and discovery
* Round robin LoadBalancer which supported by Grpc

## Requirements

Latest stable [Apache Maven](http://maven.apache.org), Maven 3.2.5 or above. Note that this is build-time requirement.

Runtime requirement: JDK 8 is a recommend to run this application.

## Building

You may clone this project and step into grpc-nacos-java sub directory before read on.

```bash
# git clone https://github.com/Moriadry/grpc-nacos-java
# cd grpc-nacos-java
```

Run the following command to build the project(Java 1.8 is required to build the master branch).

```
  mvn clean install
```

## Getting started by demo


#### Step 1: Start nacos server

Start a [Nacos naming server](https://github.com/alibaba/nacos#quick-start) is a must.

#### Step 2: Config for projects

Check the necessary config [here](https://github.com/Moriadry/grpc-nacos-java/blob/master/grpc-nacos-java-starter/src/test/resources/config.properties)

    `NACOS_URI` means the uri of Nacos naming uri to register.
    `GRPC_PORT` means the port of Grpc server,which is needed by both server and client.

#### Step 3: Start grpc server

```bash
cd grpc-nacos-java-starter
mvn exec:java@server-test
```

#### Step 4: Start grpc client

```bash
mvn exec:java@client-test
```
#### Step 5: Result

Calling result will be print out on the screen.

## Next Steps

* Golang support when nacos-go-sdk is ready.

* And more features welcome to be requested.

## License

Grpc Nacos java is under the Apache 2.0 license. See the [LICENSE](https://github.com/Moriadry/grpc-nacos-java/blob/master/LICENSE) file for details.
