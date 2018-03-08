package com.a2r2.api.rest.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "oauth_code")
public class OAuthCode {

	@Id
	@Column(name = "code")
	private String code;

	@Column(name="authentication", columnDefinition = "blob")
	private byte[] authentication;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public byte[] getAuthentication() {
		return authentication;
	}

	public void setAuthentication(byte[] authentication) {
		this.authentication = authentication;
	}

	@Override
	public String toString() {
		return "OAuthCode [" + (code != null ? "code=" + code + ", " : "")
				+ (authentication != null ? "authentication=" + Arrays.toString(authentication) : "") + "]";
	}

	
	
}