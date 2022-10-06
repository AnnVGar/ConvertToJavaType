package impl;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import core.Convertor;
import core.IConvertToString;

public class ConvertToString implements IConvertToString {
	
//	private final Charset charset;
	
//	public ConvertToString(Map<String, String> options) {
//		charset = Charset.forName(options.getOrDefault("encoding", "UTF-8"));
//	}
	
	@Override
	public String convert(byte[] bytes) {
		if (bytes != null) {
//			return new String(bytes, charset);   //StandardCharsets.UTF_8
			return new String(bytes, StandardCharsets.UTF_8);   //StandardCharsets.UTF_8
		}
		return null;

	}
} 