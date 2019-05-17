package org.moriadry.grpc.nacos;

import io.grpc.NameResolver;

public class NacosNameResolver extends NameResolver {

    private final String serviceName;
    private final String portMetaData;

    public NacosNameResolver(String serviceName, String portMetaData) {
        this.serviceName = serviceName;
        this.portMetaData = portMetaData;
    }

    @Override
    public String getServiceAuthority() {
        return null;
    }

    @Override
    public void start(Listener listener) {

    }

    @Override
    public void shutdown() {

    }
}