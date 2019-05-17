package org.moriadry.nacos.grpc;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import io.grpc.NameResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NacosNameResolver extends NameResolver {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final String serviceName;
    private final String portMetaData;
    private final NamingService namingService;

    public NacosNameResolver(String serviceName, String portMetaData, NamingService namingService) {
        this.serviceName = serviceName;
        this.portMetaData = portMetaData;
        this.namingService = namingService;
    }

    private NamingService buildNamingService (String url) {
        NamingService namingService = null;
        try {
            namingService = NacosFactory.createNamingService(url);
        } catch (NacosException e) {
            logger.error("build naming service error, msg: {}", e.getErrMsg());
        }
        return  namingService;
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