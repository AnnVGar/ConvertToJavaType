package core;

import java.util.Map;

import impl.ConfigXMLParser;

public interface IConvertFactory {
   
	Map<Integer, IConvertToType<?>> getConvertMap(ConfigXMLParser configXMLParser);
	
}
