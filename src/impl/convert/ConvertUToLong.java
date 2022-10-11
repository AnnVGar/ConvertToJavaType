package impl.convert;

import java.util.Map;

import core.convert.IConvertToLong;
import core.exception.TooLargeNumberException;

public class ConvertUToLong implements IConvertToLong {

	public ConvertUToLong(Map<String, String> settings) {
	}

	@Override
	public Long convert(byte[] bytes) throws TooLargeNumberException {
		if (bytes != null) {
			long result = 0;
			if (bytes.length == 8 && (bytes[bytes.length - 1] >> 7 & 1) == 1) {

				throw new TooLargeNumberException("Unable convert ulong to long");
			}
			for (int i = 0; i < bytes.length; i++) {
				result = result | ((bytes[i] & 0xFFL) << (8 * i));
			}
			return result;
		}
		return null;
	}

}
