package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import core.IConvertToType;
import impl.ConvertFactory;

public class ConvertToJavaType {

	private static Map<Integer, IConvertToType> convertMapping;

	public static Connection connection;
	public static String JDBC_URL = "jdbc:sqlserver://10.18.40.136:1433";
	public static String user = "a.garshina";
	public static String password = "123";

	public static void main(String[] args) {
		convertMapping = new ConvertFactory().getConvertMap();
		getDbConnection(16);
	}

	public static void getDbConnection(int typeValue) {
		try {

			connection = DriverManager.getConnection(JDBC_URL, user, password);
			if (connection != null) {
				ResultSet rs = selectFromTableByType(typeValue);
				while (rs.next()) {
					System.out.println(rs.getString("DataValue"));
					System.out.println(convertMapping.get(typeValue).convert(rs.getBytes("DataValue")));
					System.out.println();
					
				}
			}
		} catch (Exception sqlException) {
			sqlException.printStackTrace();
		}
	}

	public static ResultSet selectFromTableByType(int typeValue) throws SQLException {
		Statement stmt = connection.createStatement();
		return stmt.executeQuery("(SELECT  DataValue FROM PropertyValue WHERE DataType = " + String.valueOf(typeValue) +
//				")");
//				") union (Select 0xD093 as DataValue)");             //test type = 4      Г    
//				") union (Select 0x88FF  as DataValue)");             //test type = 5      -120      
//	            ") union (Select 0xFF  as DataValue)");               //test type = 6      255
//				") union (Select 0xD08A  as DataValue)");             //test type = 7      -30000
//		        ") union (Select 0xE8FD  as DataValue)");             //test type = 8      65000
//	            ") union (Select 0xD5FDFFFF  as DataValue)");         //test type = 9              -555
//          	") union (Select 0x005ED0B2  as DataValue)");         //test type = 10      3 000 000 000
//          	") union (Select 0x00007C1DAF931983  as DataValue)"); //test type = 11      9 000 000 000 000 000 000
//          	") union (Select 0xE78745C1  as DataValue)");         //test type = 13      -12,345689
//	            ") union (Select 0x012F83B4E6C75EC0  as DataValue)"); //test type = 14      -123.123456123456
		
//	            ") union (Select 0x869E05CF60AE9A08  as DataValue)"); //test type = 16   //  14.09.1965 06(03):55:53

//				") union (Select 0x595BCE733A0B  as DataValue)");     // test type = 16 //надо 15.01.0001 г. 09(06):56:07  /получаем 17.01.0001 09:56:07
	            ") union (Select 0x00C0DAFBFABF4F04  as DataValue)"); //test type = 16  //надо 02.07.0985 г. 03(00):00:00  /получаем 27.06.0985 03:00:00
//	            ") union (Select 0xFF20E8E4F320E220EAE8EDEE  as DataValue)");             //test type = 16     я иду в кино      Г    
		

	}

}