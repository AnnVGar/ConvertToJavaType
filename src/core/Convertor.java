package core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import exception.ExceedMarginOfError;
import exception.IncorrectDataException;
import exception.TooLargeNumberException;
import exception.UndefinedConvertException;
import impl.ConfigBean;

public class Convertor {
	public static double marginOfError;
	public static String encoding;
	IConvertFactory factory;
	ConfigBean configBean;
	
	public Convertor( ConfigBean configBean, IConvertFactory factory) {
		
//		marginOfError = parserConfig.getMarginOfError();
//		encoding = parserConfig.getEncoding();
		
		this.configBean = configBean;
		this.factory = factory;
	}
	
	public  void convertData(ResultSet rs) {
		Map<Integer, IConvertToType<?>> convertMapping = factory.getConvertMap(configBean);
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
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
