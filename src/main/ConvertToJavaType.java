package main;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import core.Convertor;
import core.IConvertFactory;
import core.IConfig;
import impl.ConfigBean;
import impl.ConvertFactory;
import impl.WorkDB;
import impl.XMLConfig;

public class ConvertToJavaType {

	public static final String xmlFilePath = "src" + File.separator + "config.xml";

	public static void main(String[] args) {
		IConfig config = new XMLConfig(xmlFilePath);
		ConfigBean configBean = config.getConfig();
		IConvertFactory convertFactory = new ConvertFactory();
		Convertor convertor = new Convertor(configBean, convertFactory);
		try (Connection connection = DriverManager.getConnection(configBean.getUrl(), configBean.getUser(),
				configBean.getPassword())) {
			if (connection != null) {
				ResultSet resultSet = WorkDB.selectDataFromTable(connection);
				convertor.convertData(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
 
}