package com.backend.v1.data.domain.account;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityUser implements UserDetails {
	
	private final String prefix = "ROLE_";
	
	private String userId;
	private List<GrantedAuthority> authorities;
	
	public SecurityUser(SessionDomain session) {
		
		this.authorities = new ArrayList<GrantedAuthority>();
		
		this.userId = session.getUserId();
		this.authorities.add(new SimpleGrantedAuthority(prefix + session.getRole()));
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;	//체크할 필요가 없으면 return true
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;	
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;	
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return null;
	}
	
	public String getUserId() {
		return this.userId;
	}
}
