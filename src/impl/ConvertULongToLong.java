package impl;

import core.IConvertToLong;
import exception.TooLargeNumberException;

public class ConvertULongToLong implements IConvertToLong {

	@Override
	public Long convert(byte[] bytes) {
		if (bytes != null) {
			try {
				if ((bytes[bytes.length - 1] >> 7 & 1) != 1) {
					return new ConvertToLong().convert(bytes);
				} else {
					throw new TooLargeNumberException("Unable convert ulong to long");
				}
			} catch (TooLargeNumberException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}