package com.kanden.iot.externalapi.client;

import com.kanden.iot.externalapi.NatureRemoRequestFactory;
import com.kanden.iot.externalapi.properties.NatureRemoProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
public class NatureRemoApiClient {

    private final NatureRemoRequestFactory natureRemoRequestFactory;
    private final RestTemplate restTemplate;
    private final NatureRemoProperties natureRemoProperties;

    /**
     * TV操作処理のAPIコール
     *
     * @param button ボタン
     */
    public void getNatureRemoInfo(String button) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("authorization", "Bearer " + natureRemoProperties.getToken());

        MultiValueMap request = natureRemoRequestFactory.create(button);

        HttpEntity httpEntity = new HttpEntity(request, headers);
        restTemplate.exchange(natureRemoProperties.getHostUrl() + natureRemoProperties.getApplianceId() + natureRemoProperties.getEndPoint(),
                HttpMethod.POST,
                httpEntity,
                Void.class
        );
    }
}