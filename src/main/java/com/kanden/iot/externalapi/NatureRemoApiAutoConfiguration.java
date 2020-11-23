package com.kanden.iot.externalapi;

import com.kanden.iot.externalapi.client.NatureRemoApiClient;
import com.kanden.iot.externalapi.properties.NatureRemoProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ConditionalOnClass(NatureRemoApiClient.class)
@EnableConfigurationProperties({
        NatureRemoProperties.class
})
public class NatureRemoApiAutoConfiguration {

    @Bean
    public NatureRemoRequestFactory natureRemoRequestFactory() {
        return new NatureRemoRequestFactory();
    }

    @Bean
    public NatureRemoApiClient natureRemoApiClient(
            NatureRemoRequestFactory natureRemoRequestFactory,
            NatureRemoProperties natureRemoProperties
    ) {
        RestTemplate restTemplate = new RestTemplate();

        return new NatureRemoApiClient(
                natureRemoRequestFactory,
                restTemplate,
                natureRemoProperties
        );
    }

}