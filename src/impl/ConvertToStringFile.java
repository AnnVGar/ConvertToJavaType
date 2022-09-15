package impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import core.IConvertToString;

public class ConvertToStringFile implements IConvertToString {
	@Override
	public String convert(byte[] bytes) {
		if (bytes != null) {
			InputStream is = new ByteArrayInputStream(bytes);
			int temp;
			try {
				FileOutputStream baos = new FileOutputStream("d:\\work\\test.txt", true);
				while ((temp = is.read()) != -1) {
					baos.write(temp);
				}
				baos.write(System.getProperty("line.separator").getBytes());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return null;
	}

}
