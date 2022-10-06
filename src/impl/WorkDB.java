package impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class WorkDB {
	
	public static ResultSet selectDataFromTable(Connection connection) {
		Statement stmt;
		try {
			stmt = connection.createStatement();
			return stmt.executeQuery("(SELECT DataType, DataValue FROM PropertyValue "//     )");
					+ "WHERE DataType = 16 )");
//				+") union (Select 4 as DataType, 0xD093 as DataValue)");             //test type = 4      Ã    
//				+") union (Select 5 as DataType,0x87  as DataValue)");             //test type = 5      -121      
//	            +") union (Select 6 as DataType, 0xFF  as DataValue)");               //test type = 6      255
//				+") union (Select 7 as DataType, 0xD08A  as DataValue)");             //test type = 7      -30000
//		        +") union (Select 8 as DataType, 0xE8FD  as DataValue)");             //test type = 8      65000
//	            +") union (Select 9 as DataType, 0x00317280  as DataValue)");         //test type = 9              -2 140 000 000
//	            +") union (Select 9 as DataType,0x8BDDFA7F  as DataValue)");         //test type = 9              2 147 147 147
//          	+") union (Select 10 as DataType,0x005ED0B2  as DataValue)");         //test type = 10      3 000 000 000
//          	+") union (Select 11 as DataType,0x00007C1DAF931983  as DataValue)"); //test type = 11         -9 000 000 000 000 000 000
//	            +") union (Select 12 as DataType,  0x0000E8890423C78A  as DataValue)"); //test type = 12      TooLargeNumberException
//		        +") union (Select 12 as DataType,  0x0000E8890423C700  as DataValue)"); //test type = 12      56052022765944832

//          	+") union (Select 13 as DataType,0xE78745C1  as DataValue)");         //test type = 13      -12,34568
//	            +") union (Select 14 as DataType,  0x012F83B4E6C75EC0  as DataValue)"); //test type = 14      -123.123456123456
//					+ ") union (Select 15 as DataType,  0x61C80CCECB5C00000000000000000180 as DataValue)");// test type
			// = 15
			// -10203040506070,5
//			    + ") union (Select 15 as DataType,  0x01000000000000000000000000000580  as DataValue)"); // test type = 15      -0.00001
//              +") union (Select 16 as DataType, 0x869E05CF60AE9A08  as DataValue)"); //test type = 16   //  14.09.1965 06(03):55:53
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

}
