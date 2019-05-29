package org.moriadry.nacos.grpc;

import io.grpc.BindableService;
import io.grpc.ServerServiceDefinition;
import io.grpc.netty.NettyServerBuilder;
import io.grpc.util.MutableHandlerRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class GrpcServer {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    protected int port;

    /**
     * record server started or not
     */
    protected volatile boolean started;

    /**
     * grpc server
     */
    protected io.grpc.Server server;

    /**
     * service registry
     */
    protected MutableHandlerRegistry handlerRegistry = new MutableHandlerRegistry();

    /**
     * The mapping relationship between BindableService and ServerServiceDefinition
     */
    protected ConcurrentHashMap<BindableService, ServerServiceDefinition> serviceInfo = new ConcurrentHashMap<BindableService,
            ServerServiceDefinition>();

    /**
     * invoker count
     */
    protected AtomicInteger invokerCnt = new AtomicInteger();

    public void init(int port) {
        this.port = port;
        this.server = NettyServerBuilder.forPort(port).fallbackHandlerRegistry(handlerRegistry).build();
    }

    public void start() {
        if (started) {
            return;
        }
        synchronized (this) {
            try {
                server.start();
                logger.info("grpc server started at port {}", port);
            } catch (IOException e) {
                logger.error("grpc server started error, msg: ", e.getMessage());
            }
        }
    }

}
