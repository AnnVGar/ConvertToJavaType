package impl.convert;

import java.nio.charset.Charset;
import java.util.Map;

import core.convert.IConvertToString;

public class ConvertToString implements IConvertToString {

	private final Charset charset;

	public ConvertToString(Map<String, String> settings) {
		charset = Charset.forName(settings.getOrDefault("encoding", "UTF-8"));
	}

	@Override
	public String convert(byte[] bytes) {
		if (bytes != null) {
			return new String(bytes, charset); // StandardCharsets.UTF_8
		}
		return null;

	}
}