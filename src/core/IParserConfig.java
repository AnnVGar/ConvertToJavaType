package core;

import java.util.Map;

public interface IParserConfig {

	
	 Map<Integer, IConvertToType<?>> getConvertMap();
	 String getUrl() ;
	 String getUser();
	 String getPassword();
	 double getMarginOfError();
	 String getEncoding();
}
