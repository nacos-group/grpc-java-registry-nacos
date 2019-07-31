# Nacos ECO project

[![Build Status](https://travis-ci.org/apache/dubbo.svg?branch=master)](https://travis-ci.org/nacos-group/grpc-java-registry-nacos)

# grpc-java-registry-nacos

this is common way of gRPC Nacos Java integration. Please feel free to add more features with this repo by sending pull requests and raising a issue.

## Features

* grpc client usage
* grpc server builder and starter
* integrate with [Nacos](https://github.com/alibaba/nacos)
* Automatic service registration and discovery
* Round robin LoadBalancer which supported by gRPC

## Requirements

Latest stable [Apache Maven](http://maven.apache.org), Maven 3.2.5 or above. Note that this is build-time requirement.

Runtime requirement: JDK 8 is a recommend to run this application.

## Building

You may clone this project and step into grpc-java-registry-nacos sub directory before read on.

```bash
# git clone https://github.com/nacos-group/grpc-java-registry-nacos
# cd grpc-java-registry-nacos
```

Run the following command to build the project(Java 1.8 is required to build the master branch).

```
  mvn clean install
```

## Getting started by demo


#### Step 1: Start nacos server

Start a [Nacos naming server](https://github.com/alibaba/nacos#quick-start) is a must.

#### Step 2: Config for projects

Check the necessary config [here](https://github.com/nacos-group/grpc-java-registry-nacos/blob/master/grpc-java-registry-nacos-example/src/main/java/com/alibaba/nacos/grpc/example/proto/GrpcNacosConfig.proto)
You can copy this proto to your project. And do pay attention to the config usage.

    `nacos_uri` means the uri of Nacos naming uri to register.
    `grpc_nacos_port` means the port of Grpc server,which is needed by both server and client.

    use `GrpcNacosOptions.getDescriptor().getOptions().getExtension(GrpcNacosProto.grpcNacosPort)` to get configuration of grpc port,
    and `GrpcNacosOptions.getDescriptor().getOptions().getExtension(GrpcNacosProto.nacosUri)` represents the configuration of nacos registry url. 
     
    
    
#### Step 3: Start gRPC server

```bash
cd grpc-java-registry-nacos-example
mvn exec:java@server-demo
```

#### Step 4: Start gRPC client

```bash
mvn exec:java@client-demo
```
#### Step 5: Result

Calling result will be print out on the screen.

## Next Steps

* Golang will be supported when nacos-go-sdk provided.

* More features welcome to be requested.

## License

gRPC Nacos java is under the Apache 2.0 license. See the [LICENSE](https://github.com/nacos-group/grpc-java-registry-nacos/blob/master/LICENSE) file for details.
