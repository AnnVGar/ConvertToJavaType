package impl.config;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLConfig {
	Document document;

	public XMLConfig(String xmlFilePath) {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			this.document = builder.parse(new File(xmlFilePath));
			document.getDocumentElement().normalize();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected String getTagValueByTagName(NodeList nodeList, String tagName) {
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node.getNodeType() != Node.TEXT_NODE && node.getNodeName().equals(tagName)) {
				return node.getTextContent();
			}
		}
		return null;
	}

	protected NodeList getAllChildrenNode(String nodeName) {
		return document.getDocumentElement().getElementsByTagName(nodeName).item(0).getChildNodes();
	}

	protected NodeList getDefinedChildrenNode(String nodeName, String childName) {
		Element node = (Element) document.getDocumentElement().getElementsByTagName(nodeName).item(0);
		return node.getElementsByTagName(childName);
	}

}
