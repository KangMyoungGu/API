package com.backend.v1.data.domain.account;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
	private String userNo;
	private Long expiredDate;
	private String token;
	private String role;
}
