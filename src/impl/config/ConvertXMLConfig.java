package impl.config;

import java.util.HashMap;
import java.util.Map;


import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import core.config.ConfigConvertBean;
import core.config.IConvertConfig;

public class ConvertXMLConfig extends XMLConfig implements IConvertConfig {

	

	public ConvertXMLConfig(String xmlFilePath) {
		super(xmlFilePath);
	}



	@Override
	public ConfigConvertBean getConfig() {
		ConfigConvertBean configBean = new ConfigConvertBean();
		configBean.setUrl(getUrl());
		configBean.setUser(getUser());
		configBean.setPassword(getPassword());
		configBean.setConverters(getConverters());
		configBean.setConvertSettings(getConvertSettings());

		return configBean;
	}
	
	

	public String getUrl() {
		NodeList url = document.getElementsByTagName("url");
		String urlValue = url.item(0).getTextContent();
		return urlValue;
		
	}

	public String getUser() {
		NodeList user = document.getElementsByTagName("user");
		String userValue = user.item(0).getTextContent();
		return userValue;
	}

	public String getPassword() {
		NodeList password = document.getElementsByTagName("password");
		String passwordValue = password.item(0).getTextContent();
		return passwordValue;
	}

	public Map<Integer, String> getConverters() {
		Map<Integer, String> convertMap = new HashMap<Integer, String>();
		NodeList convertElements = document.getDocumentElement().getElementsByTagName("converter");
		for (int i = 0; i < convertElements.getLength(); i++) {
			Node convert = convertElements.item(i);
			NamedNodeMap attributes = convert.getAttributes();
			convertMap.put(Integer.valueOf(attributes.getNamedItem("dbType").getNodeValue()), convert.getTextContent());
		}
		return convertMap;
	}

	public Map<String, Map<String, String>> getConvertSettings() {
		Map<String, Map<String, String>> convertSettings = new HashMap<String, Map<String, String>>();
		NodeList settingsElement = document.getDocumentElement().getElementsByTagName("settings");
		for (int i = 0; i < settingsElement.getLength(); i++) {
			Node settings = settingsElement.item(i);
			String convertorName = settings.getAttributes().getNamedItem("for").getNodeValue();

			HashMap<String, String> setting = new HashMap<String, String>();
			NodeList settigElement = settings.getChildNodes();
			for (int j = 0; j < settigElement.getLength(); j++) {
				Node node = settigElement.item(j);
				if (node.getNodeType() != Node.TEXT_NODE) {
					setting.put(settigElement.item(j).getAttributes().getNamedItem("name").getNodeValue(),
							settigElement.item(j).getTextContent());
				}
			}

			convertSettings.put(convertorName, setting);
		}
		return convertSettings;
	}

}
