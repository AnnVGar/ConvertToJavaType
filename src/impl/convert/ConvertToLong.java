package impl.convert;

import java.util.Map;

import core.convert.IConvertToLong;

public class ConvertToLong implements IConvertToLong {

	public ConvertToLong(Map<String, String> settings) {
	}

	@Override
	public Long convert(byte[] bytes) {
		if (bytes != null) {
			long result = 0;
			int bytesLength = bytes.length;
			for (int i = 0; i < bytes.length; i++) {
				if (bytesLength == 1) {
					result = (byte) (result | ((bytes[i] & (0xFF)) << (8 * i)));
				}
				if (bytesLength <= 2) {
					result = (short) (result | ((bytes[i] & (0xFF)) << (8 * i)));
				}
				if (bytesLength <= 4) {
					result = result | ((bytes[i] & 0xFF) << (8 * i));
				}
				if (bytesLength <= 8) {
					result = result | ((bytes[i] & 0xFFL) << (8 * i));
				}
			}
			return result;
		}
		return null;
	}

}