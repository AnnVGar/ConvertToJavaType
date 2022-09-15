package impl;

import core.IConvertToType;

public class ConvertToBool implements IConvertToType<Boolean> {

	@Override
	public Boolean convert(byte[] bytes) {
		if (bytes != null) {
			return (Boolean) (bytes[0] == 0) ? false : true;
		}
		return null;
	}

}
