package impl;

import java.util.Map;

import core.IConvertFactory;
import core.IConvertToType;
import core.IParserConfig;

public class ConvertFactory implements IConvertFactory {


	@Override
	public Map<Integer, IConvertToType<?>> getConvertMap(IParserConfig configParser) {
		return  configParser.getConvertMap();
	}	
	
}
  