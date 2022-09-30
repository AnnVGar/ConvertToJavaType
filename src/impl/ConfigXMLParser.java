package impl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import core.IConvertToType;

public class ConfigXMLParser {

	Document document;

	public ConfigXMLParser(String xmlFilePath) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			this.document = builder.parse(new File(xmlFilePath));
			document.getDocumentElement().normalize();
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}

	public Map<Integer, IConvertToType<?>> getConvertMapFromXML() {
		Map<Integer, IConvertToType<?>> convertMap = new HashMap<Integer, IConvertToType<?>>();
		NodeList parserElements = document.getDocumentElement().getElementsByTagName("parser");
		for (int i = 0; i < parserElements.getLength(); i++) {
			Node parser = parserElements.item(i);
			NamedNodeMap attributes = parser.getAttributes();

			try {
				convertMap.put(Integer.valueOf(attributes.getNamedItem("dbType").getNodeValue()),
						(IConvertToType<?>) Class.forName(attributes.getNamedItem("packageName").getNodeValue()
								+ attributes.getNamedItem("javaClass").getNodeValue()).newInstance());
			} catch (NumberFormatException | DOMException | InstantiationException | IllegalAccessException
					| ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return convertMap;
	}

	public String getUrlFromXML() {
		NodeList url = document.getElementsByTagName("connection");
		String urlValue = url.item(0).getAttributes().getNamedItem("value").getNodeValue();
		return urlValue;
	}

	public String getUserFromXML() {
		NodeList user = document.getElementsByTagName("user");
		String userValue = user.item(0).getAttributes().getNamedItem("value").getNodeValue();
		return userValue;
	}

	public String getPasswordFromXML() {
		NodeList password = document.getElementsByTagName("password");
		String passwordValue = password.item(0).getAttributes().getNamedItem("value").getNodeValue();
		return passwordValue;
	}
	
	public double getMarginOfError() {
		NodeList password = document.getElementsByTagName("marginOfError");
		String passwordValue = password.item(0).getAttributes().getNamedItem("value").getNodeValue();
		return Double.valueOf(passwordValue);
	}

}
