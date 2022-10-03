package impl;

import core.IConvertToLong;
import exception.TooLargeNumberException;

public class ConvertUToLong implements IConvertToLong {

	@Override
	public Long convert(byte[] bytes) {
		if (bytes != null) {
			long result = 0;
			try {
				if (bytes.length == 8 && (bytes[bytes.length - 1] >> 7 & 1) == 1) {

					throw new TooLargeNumberException("Unable convert ulong to long");
				}
				for (int i = 0; i < bytes.length; i++) {
					result = result | ((bytes[i] & 0xFFL) << (8 * i));
				}
			} catch (TooLargeNumberException e) {
				e.printStackTrace();
			}
			return result;
		}
		return null;
	}

}
