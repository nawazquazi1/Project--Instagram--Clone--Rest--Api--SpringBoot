package com.instagram.clone.restApi.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author nawaz
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {

	private String message;
	private boolean success;
}
