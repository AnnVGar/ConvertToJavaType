package impl;

import java.util.Map;

import core.IConvertFactory;
import core.IConvertToType;

public class ConvertFactory implements IConvertFactory {


	@Override
	public Map<Integer, IConvertToType<?>> getConvertMap(ConfigXMLParser configXMLParser) {
		return  configXMLParser.getConvertMapFromXML();
	}	
	
}
  