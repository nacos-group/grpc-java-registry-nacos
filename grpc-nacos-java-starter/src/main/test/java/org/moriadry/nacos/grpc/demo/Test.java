package org.moriadry.nacos.grpc.demo;

import org.moriadry.nacos.grpc.model.grpc.GrpcTestServiceGrpc;
import org.moriadry.nacos.grpc.model.grpc.impl.GrpcTestServiceImpl;
import org.moriadry.nacos.grpc.starter.GrpcServer;

public class Test {

    public static void main(String[] args) {
        GrpcServer server = new GrpcServer();
        server.init(8890);
//
        server.registerService(new GrpcTestServiceImpl());
    }
}
