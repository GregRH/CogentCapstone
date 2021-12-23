package com.cogent.dto;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {
	private String autority;
	
	public Authority(String authority) {
		this.autority=authority;
	}
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.autority;
	}
}
