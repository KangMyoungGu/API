package com.backend.v1.data.dto.account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserDto implements Serializable {
	private static final long serialVersionUID = -2536624275594456755L;
	private String token;
	private String userId;
	private String userName;
}
