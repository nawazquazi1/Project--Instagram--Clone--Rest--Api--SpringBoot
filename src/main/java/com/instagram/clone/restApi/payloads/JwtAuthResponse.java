package com.instagram.clone.restApi.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author nawaz
 */
@Data
@ToString
@AllArgsConstructor
public class JwtAuthResponse {

	private String token;
	
	private UserDto user;
}
