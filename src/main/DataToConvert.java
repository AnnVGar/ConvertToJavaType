package main;

public class DataToConvert {

	private Integer type;
	private byte[] bytes;

	public DataToConvert(Integer type, byte[] bytes) {
		this.type = type;
		this.bytes = bytes;
	}

	public Integer getType() {
		return type;
	}

	public byte[] getBytes() {
		return bytes;
	}

	@Override
	public String toString() {
		return "type=" + type + " bytes: " + byteArrayToHex(bytes);
	}

	public static String byteArrayToHex(byte[] bytes) {
		if (bytes == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder(bytes.length * 2);
		for (byte b : bytes) {
			sb.append(String.format("%02x", b).toUpperCase());
		}
		return sb.toString();
	}
}
