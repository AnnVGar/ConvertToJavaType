package impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import core.IConvertFactory;
import core.IConvertToType;

public class ConvertFactory implements IConvertFactory {

	private static Map<Integer,IConvertToType> convertMap = new HashMap<Integer, IConvertToType>() ;

	@Override
	public Map<Integer,IConvertToType> getConvertMap() {
		fillConvertMap();
		return convertMap;
	}
	
	private void fillConvertMap(){
		convertMap.put(1, new ConvertToString());
		convertMap.put(3, new ConvertToBool());
		convertMap.put(4, new ConvertToString());
		convertMap.put(5, new ConvertByteToLong());		
		convertMap.put(6, new ConvertUToLong());
		convertMap.put(7, new ConvertInt16ToLong());
		convertMap.put(8, new ConvertUToLong());
		convertMap.put(9, new ConvertInt32ToLong());
//		convertMap.put(9, new ConvertToLong());		????сделать один метод для всех знаковых переменных???
		convertMap.put(10, new ConvertUToLong());
		convertMap.put(11, new ConvertInt64ToLong());
		convertMap.put(13, new ConvertSingleToDouble());		
		convertMap.put(14, new ConvertDoubleToDouble());
		convertMap.put(16, new ConvertToDate());
		convertMap.put(18, new ConvertToString());
		convertMap.put(101, new ConvertToString());
		convertMap.put(107, new ConvertToString());
		
	}

	
}
