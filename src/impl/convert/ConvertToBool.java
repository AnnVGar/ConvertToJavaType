package impl.convert;

import java.util.Map;

import core.convert.IConvertToType;

public class ConvertToBool implements IConvertToType<Boolean> {
	
		
	public ConvertToBool(Map<String, String> settings){
	}

	@Override
	public Boolean convert(byte[] bytes) {
		if (bytes != null) {
			return (Boolean) (bytes[0] == 0) ? false : true;
		}
		return null;
	}

}
