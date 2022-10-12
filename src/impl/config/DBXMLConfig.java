package impl.config;

import org.w3c.dom.NodeList;

import core.config.DBConfigBean;
import core.config.IDBConfigProvider;

public class DBXMLConfig extends XMLConfig implements IDBConfigProvider {

	NodeList dbConnectSettings;

	public DBXMLConfig(String xmlFilePath) {
		super(xmlFilePath);
		dbConnectSettings = getAllChildrenNode("dbConnect");
	}

	@Override
	public DBConfigBean getConfig() {
		DBConfigBean configBean = new DBConfigBean();
		configBean.setUrl(getUrl());
		configBean.setUser(getUser());
		configBean.setPassword(getPassword());
		return configBean;
	}

	public String getUrl() {
		return getTagValueByTagName(dbConnectSettings, "url");
	}

	public String getUser() {
		return getTagValueByTagName(dbConnectSettings, "user");
	}

	public String getPassword() {
		return getTagValueByTagName(dbConnectSettings, "password");
	}

}
