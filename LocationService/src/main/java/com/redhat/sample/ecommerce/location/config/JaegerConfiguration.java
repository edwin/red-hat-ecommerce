package com.redhat.sample.ecommerce.location.config;

import io.jaegertracing.internal.JaegerTracer;
import io.jaegertracing.internal.metrics.NoopMetricsFactory;
import io.jaegertracing.internal.reporters.RemoteReporter;
import io.jaegertracing.internal.samplers.ProbabilisticSampler;
import io.jaegertracing.thrift.internal.senders.UdpSender;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class JaegerConfiguration {
    @Bean
    public io.opentracing.Tracer initTracer() {
        return new JaegerTracer.Builder("location-service")
                .withMetricsFactory(new NoopMetricsFactory()).withSampler(new ProbabilisticSampler(1))
                .build();
    }

    @Bean
    public RemoteReporter remoteReporter() {
        return new RemoteReporter.Builder().withSender(new UdpSender("localhost", 6831, 0)).build();
    }
}