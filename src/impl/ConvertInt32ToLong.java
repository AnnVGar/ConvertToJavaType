package impl;

import core.IConvertToLong;

public class ConvertInt32ToLong implements IConvertToLong {

	@Override
	public Long convert(byte[] bytes) {
		if (bytes != null) {
			long result = 0;
			for (int i = 0; i < bytes.length; i++) {
				result = result | ((bytes[i] & 0xFF) << (8 * i));
			}
			return result;

		}
		return null;
	}

}
