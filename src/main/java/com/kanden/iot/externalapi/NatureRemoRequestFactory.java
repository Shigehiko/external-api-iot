package com.kanden.iot.externalapi;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class NatureRemoRequestFactory {

    /**
     * MultiValueMapを生成
     *
     * @param button ボタン
     * @return MultiValueMap
     */
    public MultiValueMap<String, String> create(String button){

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("button", button);
        return body;
    }

}