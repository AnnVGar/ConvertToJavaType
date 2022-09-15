package impl;

import core.IConvertToDouble;

public class ConvertDoubleToDouble implements IConvertToDouble {

	@Override
	public Double convert(byte[] bytes) {
		if (bytes != null) {
			long toLong = 0;
			for (int i = 0; i < bytes.length; i++) {
				toLong = toLong | ((bytes[i] & 0xFFL) << (8 * i));
			}

			double result = Double.longBitsToDouble(toLong);
			return result;
		}
		return null;
	}

}
