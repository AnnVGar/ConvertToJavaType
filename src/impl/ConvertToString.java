package impl;

import java.nio.charset.StandardCharsets;

import core.IConvertToString;

public class ConvertToString implements IConvertToString {
	
	public ConvertToString() {
		
	}

	@Override
	public String convert(byte[] bytes) {

		if (bytes != null) {

			return new String(bytes, StandardCharsets.UTF_8);
			
			
		}

		return null;

	}
}
