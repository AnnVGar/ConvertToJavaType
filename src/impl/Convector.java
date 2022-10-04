package impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import core.IConvertToType;
import core.IParserConfig;
import exception.ExceedMarginOfError;
import exception.IncorrectDataException;
import exception.TooLargeNumberException;
import exception.UndefinedConvertException;

public class Convector {
	static double marginOfError;
	static String encoding;
	
	public Convector( IParserConfig parserConfig) {
		marginOfError = parserConfig.getMarginOfError();
		encoding = parserConfig.getEncoding();
	}
	
	public  void convertData(ResultSet rs, Map<Integer, IConvertToType<?>> convertMapping) {
		
		try {
			while (rs.next()) {
				try {
					System.out.println(rs.getString("DataValue"));
					int dataType = rs.getInt("DataType");
					System.out.println("dataType " + dataType);
					if (!convertMapping.containsKey(dataType)) {
						throw new UndefinedConvertException("Convert for dataType =  " + dataType + " is undefined");
					}
					System.out.println(convertMapping.get(dataType).convert(rs.getBytes("DataValue")));
					System.out.println();
				} catch (TooLargeNumberException | UndefinedConvertException | IncorrectDataException
						| ExceedMarginOfError e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
