package com.instagram.clone.restApi.payloads;

import lombok.Data;


@Data
public class PostRequest {

    private String imageUrl;
    private String caption;
}
