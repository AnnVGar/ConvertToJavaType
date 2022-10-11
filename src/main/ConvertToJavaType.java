package main;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import core.config.ConfigConvertBean;
import core.config.IConvertConfig;
import core.convert.Convertor;
import core.convert.IConvertFactory;
import impl.WorkDB;
import impl.config.ConvertXMLConfig;
import impl.convert.ConvertFactory;

public class ConvertToJavaType {

	public static final String xmlFilePath = "src" + File.separator + "convertConfig.xml";

	public static void main(String[] args) {
		IConvertConfig config = new ConvertXMLConfig(xmlFilePath);
		ConfigConvertBean configBean = config.getConfig();
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