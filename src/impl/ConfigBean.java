package impl;

import java.util.Map;

import core.IConfig;

public class ConfigBean {

	
	private String url;
	private String user;
	private String password;
	private Map<Integer, String> converters;
	private Map<String, Map<String, String>> convertSettings;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String getPassword) {
		this.password = getPassword;
	}
	public Map<Integer, String> getConverters() {
		return converters;
	}
	public void setConverters(Map<Integer, String> converters) {
		this.converters = converters;
	}
	public Map<String, Map<String, String>> getConvertSettings() {
		return convertSettings;
	}
	public void setConvertSettings(Map<String, Map<String, String>> convertSettings) {
		this.convertSettings = convertSettings;
	}

	

}
