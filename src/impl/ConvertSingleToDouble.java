package impl;

import core.IConvertToDouble;

public class ConvertSingleToDouble implements IConvertToDouble {

	
	@Override
	public Double convert(byte[] bytes) {
		if (bytes != null) {
			int toInt = 0;
			for (int i = 0; i < bytes.length; i++) {
				toInt = toInt | ((bytes[i] & 0xFF) << (8 * i));
			}

			float result = Float.intBitsToFloat(toInt);
			return (double) result;
		}
		return null;
	}

}
