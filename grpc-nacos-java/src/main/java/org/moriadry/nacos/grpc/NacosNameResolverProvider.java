package org.moriadry.nacos.grpc;

import io.grpc.Attributes;
import io.grpc.NameResolver;
import io.grpc.NameResolverProvider;

import javax.annotation.Nullable;
import java.net.URI;

public class NacosNameResolverProvider extends NameResolverProvider {

    protected  static final String NACOS = "nacos";

    @Override
    protected boolean isAvailable() {
        return true;
    }

    @Override
    protected int priority() {
        return 6;
    }

    @Nullable
    @Override
    public NameResolver newNameResolver(URI targetUri, Attributes params) {
        return new NacosNameResolver(null, null, null);
    }

    @Override
    public String getDefaultScheme() {
        return NACOS;
    }
}
