package com.backend.v1.data.domain.account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SessionDomain {
	// Javascript Data type Number != Java Long type. so use userNo as cast String
	private String userId;
	private String token;
}
