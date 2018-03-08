package com.a2r2.api.rest.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.util.SerializationUtils;

@Entity()
@Table(name = "oauth_client_token")
public class OAuthClientToken {

	
	@Id
	@Column(name="token_id")
	private String id;

	@Column(name="token", columnDefinition = "blob")
	private byte[] token;

	@Column(name="authentication_id")
	private String authenticationId;

	@Column(name="user_name")
	private String userName;

	@Column(name="client_id")
	private String clientId;
	
	public String getId() {
		return id;
	}

	public void setId(String token_id) {
		this.id = token_id;
	}

	public byte[] getToken() {
		return token;
	}

	@Transient
	private DefaultOAuth2AccessToken defaultOAuth2AccessToken;
	
	
	private synchronized DefaultOAuth2AccessToken getDefaultOAuth2AccessToken () {
		if (this.defaultOAuth2AccessToken==null) {
			this.defaultOAuth2AccessToken =  SerializationUtils.deserialize(this.token);
		}
		return this.defaultOAuth2AccessToken;
	}
	
	public String getTokenValue() {
		return getDefaultOAuth2AccessToken().getValue();
	}
	
	public Date getTokenExpiration() {
		return getDefaultOAuth2AccessToken().getExpiration();
	}
	
	public int getTokenExpirationIn() {
		return getDefaultOAuth2AccessToken().getExpiresIn();
	}
	
	
	public String getRefreshTokenValue() {
		return getDefaultOAuth2AccessToken().getRefreshToken().getValue();
	}	
	
	public void setToken(byte[] token) {
		this.token = token;
	}

	public String getAuthenticationId() {
		return authenticationId;
	}

	public void setAuthenticationId(String authentication_id) {
		this.authenticationId = authentication_id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String user_name) {
		this.userName = user_name;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String client_id) {
		this.clientId = client_id;
	}


	@Override
	public String toString() {
		return "OAuthAccessToken [token_id=" + id
				+ ",  authentication_id=" + authenticationId + ", user_name="
				+ userName + ", client_id=" + clientId  + "]";
	}

}