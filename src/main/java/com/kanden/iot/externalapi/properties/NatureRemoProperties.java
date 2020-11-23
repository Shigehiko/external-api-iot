package com.kanden.iot.externalapi.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "natureremo")
public class NatureRemoProperties {

    private String hostUrl = "https://api.nature.global/1/appliances/";
    private String endPoint = "/tv";
    //TODO: tokenとapplianceIdの管理方法を考える
    private String token = "";
    private String applianceId = "";

}
