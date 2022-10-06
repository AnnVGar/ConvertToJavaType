package impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;

import core.IConvertToDouble;
import exception.ExceedMarginOfError;
import exception.IncorrectDataException;

public class ConvertToDouble implements IConvertToDouble {

	private final double permissibleError;

	public ConvertToDouble(Map<String, String> settings) {
		permissibleError = Double.valueOf(settings.getOrDefault("permissibleError", "0.00001"));
	}

	@Override
	public Double convert(byte[] bytes) throws IncorrectDataException, ExceedMarginOfError {
		if (bytes == null) {
			return null;
		}
		int bytesLength = bytes.length;
		if (bytesLength == 4) {
			return floatToDouble(bytes);

		}
		if (bytesLength == 8) {
			return doubleToDouble(bytes);
		}
		if (bytesLength == 16) {
			return decimalToDouble(bytes);
		}
		throw new IncorrectDataException("Incorrect data length");

	}

	private Double floatToDouble(byte[] bytes) {
		int toInt = 0;
		for (int i = 0; i < bytes.length; i++) {
			toInt = toInt | ((bytes[i] & 0xFF) << (8 * i));
		}
		return (double) Float.intBitsToFloat(toInt);
	}

	private Double doubleToDouble(byte[] bytes) {
		long toLong = 0;
		for (int i = 0; i < bytes.length; i++) {
			toLong = toLong | ((bytes[i] & 0xFFL) << (8 * i));
		}

		return Double.longBitsToDouble(toLong);
	}

	private Double decimalToDouble(byte[] bytes) throws ExceedMarginOfError {
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
		double resultDouble = bigDecimal.doubleValue();
		BigDecimal castError = bigDecimal.subtract(new BigDecimal(resultDouble)).abs();
		if (castError.compareTo(new BigDecimal(permissibleError)) == 1) {

			throw new ExceedMarginOfError("castError = " + castError);
		}
		return resultDouble;

	}
}
