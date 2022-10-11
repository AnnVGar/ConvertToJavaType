package impl.config;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import core.config.IDBConfig;

public class DBXMLConfig  extends XMLConfig implements IDBConfig {
	
	Document document;

	public DBXMLConfig(String xmlFilePath) {
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
	
	private Node getdbConnectNode(){
		return document.getDocumentElement().getElementsByTagName("dbConnect").item(0);
		
	}

}
