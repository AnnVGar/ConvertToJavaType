package impl;

import java.util.HashMap;
import java.util.Map;

import core.IConvertFactory;
import core.IConvertToType;

public class ConvertFactory implements IConvertFactory {

//	private static Map<Integer,IConvertToType> convertMap = new HashMap<Integer, IConvertToType>() ;

	@Override
	public Map<Integer, IConvertToType<?>> getConvertMap(ConfigXMLParser configXMLParser) {
//		fillConvertMap();
		return  configXMLParser.getConvertMap();
	}
	
//	private void fillConvertMap(){
//		convertMap.put(1, new ConvertToString());
//		convertMap.put(3, new ConvertToBool());
//		convertMap.put(4, new ConvertToString());
//		convertMap.put(5, new ConvertToLong());		
//		convertMap.put(6, new ConvertUToLong());
//		convertMap.put(7, new ConvertToLong());
//		convertMap.put(8, new ConvertUToLong());
//		convertMap.put(9, new ConvertToLong());		
//		convertMap.put(10, new ConvertUToLong());
//		convertMap.put(11, new ConvertToLong());
//		convertMap.put(12, new ConvertToLong());
//		convertMap.put(13, new ConvertToDouble());		
//		convertMap.put(14, new ConvertToDouble());
//		convertMap.put(16, new ConvertToDate());
//		convertMap.put(18, new ConvertToString());
//		convertMap.put(101, new ConvertToString());
//		convertMap.put(105, new ConvertToString());
//		convertMap.put(107, new ConvertToString());
//		
//	}

	
}
