package impl.convert;

import java.util.Map;

import core.convert.IConvertToLong;
import core.exception.IncorrectDataException;

public class ConvertToLong implements IConvertToLong {

	public ConvertToLong(Map<String, String> settings) {
	}

	@Override
	public Long convert(byte[] bytes) throws IncorrectDataException {
		if (bytes != null) {
			long result = 0;
			int bytesLength = bytes.length;
			if (bytesLength != 1 && bytesLength != 2 && bytesLength != 4 && bytesLength != 8) {
				throw new IncorrectDataException("Incorrect data length");
			}
			for (int i = 0; i < bytes.length; i++) {
				if (bytesLength == 1) {
					result = bytes[i];
				}
				if (bytesLength == 2) {
					result = (short) (result | ((bytes[i] & (0xFF)) << (8 * i)));
				}
				if (bytesLength == 4) {
					result = result | ((bytes[i] & 0xFF) << (8 * i));
				}
				if (bytesLength == 8) {
					result = result | ((bytes[i] & 0xFFL) << (8 * i));
				}
			}
			return result;
		}
		return null;
	}

}