package impl;

import java.math.BigDecimal;
import java.math.BigInteger;

import core.IConvertToDouble;
import exception.ExceedMarginOfError;
import exception.IncorrectDataException;
import main.ConvertToJavaType;

public class ConvertToDouble implements IConvertToDouble {

	@Override
	public Double convert(byte[] bytes) {
		Double result = null;
		if (bytes != null) {
			try {
				int bytesLength = bytes.length;
				if (bytesLength == 4) {
					int toInt = 0;
					for (int i = 0; i < bytes.length; i++) {
						toInt = toInt | ((bytes[i] & 0xFF) << (8 * i));
					}
					result = (double) Float.intBitsToFloat(toInt);
				} else if (bytesLength == 8) {
					long toLong = 0;
					for (int i = 0; i < bytes.length; i++) {
						toLong = toLong | ((bytes[i] & 0xFFL) << (8 * i));
					}

					result = Double.longBitsToDouble(toLong);
				} else if (bytesLength == 16) {
					try {
						int sign = (bytes[15] >> 7 & 1) == 1 ? -1 : 1;
						int powValue = bytes[14];
						byte[] magnitude = new byte[12];
						for (int i = 0; i <= 11; i++) {
							magnitude[i] = bytes[11 - i];
						}
						BigInteger bigInt = new BigInteger(sign, magnitude);
						BigDecimal divisor = new BigDecimal(Math.pow(10, powValue));
						BigDecimal bigDecimal = new BigDecimal(bigInt);
						bigDecimal = bigDecimal.divide(divisor);
						double resultDouble = (bigDecimal.doubleValue());
						BigDecimal castError = bigDecimal.subtract(new BigDecimal(resultDouble));
						if (castError.compareTo(new BigDecimal(ConvertToJavaType.marginOfError)) == 1) {
							throw new ExceedMarginOfError("castError = " + castError);
						}
						result = resultDouble;
						System.out.println(bigDecimal);
					} catch (ExceedMarginOfError e) {
						e.printStackTrace();
					}
				} else {
					throw new IncorrectDataException("Incorrect data length");
				}
			} catch (IncorrectDataException e) {
				e.printStackTrace();
			}
			return result;
		}
		return result;

	}
}