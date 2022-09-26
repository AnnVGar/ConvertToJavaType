package impl;

import core.IConvertToDouble;

public class ConvertToDouble implements IConvertToDouble {

	@Override
	public Double convert(byte[] bytes) {

		if (bytes != null) {
			int bytesLength = bytes.length;
			if (bytesLength == 4) {
				int toInt = 0;
				for (int i = 0; i < bytes.length; i++) {
					toInt = toInt | ((bytes[i] & 0xFF) << (8 * i));
				}
				float result = Float.intBitsToFloat(toInt);
				return (double) result;
			}
			if (bytesLength == 8) {
				long toLong = 0;
				for (int i = 0; i < bytes.length; i++) {
					toLong = toLong | ((bytes[i] & 0xFFL) << (8 * i));
				}

				double result = Double.longBitsToDouble(toLong);
				return result;
			}
		}
		return null;
	}

}
