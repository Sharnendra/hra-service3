package com.rnlic.hraapp.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MailerConfig {
	@Value("${mail.debug}")
	private Boolean debug=false;
	@Value("${mail.store.protocol}")
	private String storeProtocol;
	@Value("${mail.transport.protocol}")
	private String transportProtocol;
	@Value("${mail.smtp.auth}")
	private Boolean auth;
	@Value("${mail.smtp.starttls}")
	private Boolean starttls;
	@Value("${mail.smtp.host}")
	private String host;
	@Value("${mail.smtp.port}")
	private String port;
	@Value("${proxySet}")
	private Boolean proxySet;
	@Value("${socksProxyHost}")
	private String socksProxyHost;
	@Value("${socksProxyHost}")
	private String socksProxyPort;
	public Boolean getDebug() {
		return debug;
	}
	public void setDebug(Boolean debug) {
		this.debug = debug;
	}
	public String getStoreProtocol() {
		return storeProtocol;
	}
	public void setStoreProtocol(String storeProtocol) {
		this.storeProtocol = storeProtocol;
	}
	public String getTransportProtocol() {
		return transportProtocol;
	}
	public void setTransportProtocol(String transportProtocol) {
		this.transportProtocol = transportProtocol;
	}
	public Boolean getAuth() {
		return auth;
	}
	public void setAuth(Boolean auth) {
		this.auth = auth;
	}
	public Boolean getStarttls() {
		return starttls;
	}
	public void setStarttls(Boolean starttls) {
		this.starttls = starttls;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public Boolean getProxySet() {
		return proxySet;
	}
	public void setProxySet(Boolean proxySet) {
		this.proxySet = proxySet;
	}
	public String getSocksProxyHost() {
		return socksProxyHost;
	}
	public void setSocksProxyHost(String socksProxyHost) {
		this.socksProxyHost = socksProxyHost;
	}
	public String getSocksProxyPort() {
		return socksProxyPort;
	}
	public void setSocksProxyPort(String socksProxyPort) {
		this.socksProxyPort = socksProxyPort;
	}
	@Override
	public String toString() {
		return "MailerConfig [debug=" + debug + ", storeProtocol=" + storeProtocol + ", transportProtocol="
				+ transportProtocol + ", auth=" + auth + ", starttls=" + starttls + ", host=" + host + ", port=" + port
				+ ", proxySet=" + proxySet + ", socksProxyHost=" + socksProxyHost + ", socksProxyPort=" + socksProxyPort
				+ "]";
	}
	
	

}
