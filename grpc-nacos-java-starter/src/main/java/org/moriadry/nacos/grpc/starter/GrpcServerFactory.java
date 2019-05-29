package org.moriadry.nacos.grpc.starter;

public interface GrpcServerFactory {

    void start();

    void stop();

    <T> T newServer();

}
