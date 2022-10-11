package impl.config;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

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
}
