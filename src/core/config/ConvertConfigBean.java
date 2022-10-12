package core.config;

import java.util.Map;

public class ConvertConfigBean {

	
	
	private Map<Integer, String> converters;
	private Map<String, Map<String, String>> convertSettings;

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
