package impl.config;

import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import core.config.ConvertConfigBean;
import core.config.IConvertConfigProvider;

public class ConvertXMLConfig extends XMLConfig implements IConvertConfigProvider {

	public ConvertXMLConfig(String xmlFilePath) {
		super(xmlFilePath);
	}

	@Override
	public ConvertConfigBean getConfig() {
		ConvertConfigBean configBean = new ConvertConfigBean();
		configBean.setConverters(getConverters());
		configBean.setConvertSettings(getConvertSettings());
		return configBean;
	}

	public Map<Integer, String> getConverters() {
		Map<Integer, String> convertMap = new HashMap<Integer, String>();
		NodeList convertElements = getDefinedChildrenNode("converters", "converter");
		for (int i = 0; i < convertElements.getLength(); i++) {
			Node convert = convertElements.item(i);
			NamedNodeMap attributes = convert.getAttributes();
			convertMap.put(Integer.valueOf(attributes.getNamedItem("dbType").getNodeValue()), convert.getTextContent());
		}
		return convertMap;
	}

	public Map<String, Map<String, String>> getConvertSettings() {
		Map<String, Map<String, String>> convertSettings = new HashMap<String, Map<String, String>>();
		NodeList settingsElement = getDefinedChildrenNode("convertSettings", "settings");
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
