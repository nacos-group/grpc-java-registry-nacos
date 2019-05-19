package org.moriadry.nacos.grpc.starter;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.util.RoundRobinLoadBalancerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcNacosConguration {

    @Value("")
    private String nacosServiceId;

    @Bean
    @ConditionalOnMissingBean(ManagedChannel.class)
    public ManagedChannel defaultManagedChannel() {
        return ManagedChannelBuilder
                .forTarget("nacos://" + nacosServiceId)
//                .nameResolverFactory(new NacosNameResolver())
                .loadBalancerFactory(RoundRobinLoadBalancerFactory.getInstance())
                .usePlaintext(true)
                .build();
    }
}
