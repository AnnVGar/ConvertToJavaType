package main;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import core.IConvertToType;
import impl.ConfigXMLParser;
import impl.ConvertFactory;

public class ConvertToJavaType {

	private static Map<Integer, IConvertToType<?>> convertMapping;

	public static Connection connection;
	public static String JDBC_URL; 
	public static String user;
	public static String password;

	public static void main(String[] args) {
		ConfigXMLParser configXMLParser = new ConfigXMLParser("src" + File.separator + "config.xml");
		convertMapping = new ConvertFactory().getConvertMap(configXMLParser);
		JDBC_URL = configXMLParser.getUrlFromXML();
		user = configXMLParser.getUserFromXML();
		password = configXMLParser.getPasswordFromXML();
		getDbConnection(JDBC_URL, user, password, -1);
	}

	public static void getDbConnection(String url, String user, String password, int typeValue) {
		try {

			connection = DriverManager.getConnection(url, user, password);
			if (connection != null) {
				ResultSet rs = selectFromTableByType(typeValue);
				while (rs.next()) {
					System.out.println(rs.getString("DataValue"));
					int dataType = rs.getInt("DataType");
					System.out.println("datType " + dataType);
					System.out.println(convertMapping.get(dataType).convert(rs.getBytes("DataValue")));
					System.out.println();
				}
			}
			connection.close();
		} catch (Exception sqlException) {
			sqlException.printStackTrace();
		}
	}

	public static ResultSet selectFromTableByType(int typeValue) throws SQLException {
		Statement stmt = connection.createStatement();
		if (typeValue == -1) {
			return stmt.executeQuery("(SELECT DataType, DataValue FROM PropertyValue WHERE DataType < 200 )");
		} else {
			return stmt.executeQuery("(SELECT " + typeValue
					+ " as DataType, DataValue FROM PropertyValue WHERE DataType = " + String.valueOf(typeValue) + ")");
//				") union (Select 0xD093 as DataValue)");             //test type = 4      Ã    
//				") union (Select 0x87  as DataValue)");             //test type = 5      -121      
//	            ") union (Select 0xFF  as DataValue)");               //test type = 6      255
//				") union (Select 0xD08A  as DataValue)");             //test type = 7      -30000
//		        ") union (Select 0xE8FD  as DataValue)");             //test type = 8      65000
//	            ") union (Select 0x00317280  as DataValue)");         //test type = 9              -2 140 000 000
//	            ") union (Select 0x8BDDFA7F  as DataValue)");         //test type = 9              2 147 147 147
//          	") union (Select 0x005ED0B2  as DataValue)");         //test type = 10      3 000 000 000
//          	") union (Select 0x00007C1DAF931983  as DataValue)"); //test type = 11         -9 000 000 000 000 000 000
//          	") union (Select 0xE78745C1  as DataValue)");         //test type = 13      -12,34568
//	            ") union (Select 0x012F83B4E6C75EC0  as DataValue)"); //test type = 14      -123.123456123456

//	            ") union (Select 0x869E05CF60AE9A08  as DataValue)"); //test type = 16   //  14.09.1965 06(03):55:53

		}

	}

}