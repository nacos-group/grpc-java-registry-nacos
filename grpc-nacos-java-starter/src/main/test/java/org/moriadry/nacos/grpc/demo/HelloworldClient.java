package org.moriadry.nacos.grpc.demo;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.moriadry.nacos.grpc.model.grpc.GrpcTestServiceGrpc;
import org.moriadry.nacos.grpc.model.grpc.GrpcTestService_Request_String;
import org.moriadry.nacos.grpc.model.grpc.GrpcTestService_Response_String;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloworldClient {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final ManagedChannel channel;
    private final GrpcTestServiceGrpc.GrpcTestServiceBlockingStub blockingStub;

    public HelloworldClient(int port) {
        this(ManagedChannelBuilder.forAddress("127.0.0.1", port)
            .usePlaintext(true)
            .build());
    }

    public HelloworldClient(ManagedChannel channel) {
        this.channel = channel;
        blockingStub = GrpcTestServiceGrpc.newBlockingStub(channel);
    }
1
    public void reqString (String req) {
        GrpcTestService_Response_String response = blockingStub.reqString(GrpcTestService_Request_String.newBuilder().setName(req).build());
        System.out.println(response);
    }

    public static void main(String[] args) {
        HelloworldClient client = new HelloworldClient(50051);
        client.reqString("AAA");
    }
}
