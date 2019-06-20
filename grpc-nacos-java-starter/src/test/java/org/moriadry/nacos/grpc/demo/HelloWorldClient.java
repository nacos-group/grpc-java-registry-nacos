package org.moriadry.nacos.grpc.demo;

import io.grpc.Attributes;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.moriadry.nacos.grpc.internal.NacosNameResolverProvider;
import org.moriadry.nacos.grpc.model.grpc.GrpcTestServiceGrpc;
import org.moriadry.nacos.grpc.model.grpc.GrpcTestService_Request_String;
import org.moriadry.nacos.grpc.model.grpc.GrpcTestService_Response_String;
import org.moriadry.nacos.grpc.starter.utils.ConfigResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;

public class HelloWorldClient {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final ManagedChannel channel;
    private final GrpcTestServiceGrpc.GrpcTestServiceBlockingStub blockingStub;

    public HelloWorldClient(int port, URI uri, String nacosServiceId) {
        this(ManagedChannelBuilder.forTarget("nacos://" + nacosServiceId)
            .nameResolverFactory(new NacosNameResolverProvider(uri, Attributes.newBuilder().build()))
            .usePlaintext(true)
            .build());
    }

    public HelloWorldClient(ManagedChannel channel) {
        this.channel = channel;
        blockingStub = GrpcTestServiceGrpc.newBlockingStub(channel);
    }

    public void reqString (String req) {
        GrpcTestService_Response_String response = blockingStub.reqString(GrpcTestService_Request_String.newBuilder().setName(req).build());
        System.out.println(response);
    }

    public static void main(String[] args) {
        HelloWorldClient client = new HelloWorldClient(ConfigResult.GRPC_PORT, URI.create(ConfigResult.NACOS_URI), "GrpcTestService");
        client.reqString("AAA");
    }
}
