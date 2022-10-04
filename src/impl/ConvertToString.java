package impl;

import java.nio.charset.Charset;

import core.IConvertToString;

public class ConvertToString implements IConvertToString {

	@Override
	public String convert(byte[] bytes) {
		if (bytes != null) {
			return new String(bytes, Charset.forName(Convector.encoding));   //StandardCharsets.UTF_8
		}
		return null;

	}
}