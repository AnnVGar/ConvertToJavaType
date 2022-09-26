package impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import core.IConvertToDate;

public class ConvertToDate implements IConvertToDate {

	@Override
	public Date convert(byte[] bytes) {

		if (bytes != null) {
			long forDate = 0;
			for (int i = 0; i < bytes.length; i++) {
				forDate = forDate | ((bytes[i] & 0xFFL) << (8 * i));
			}
			System.out.println("FromBinary forDate    " + forDate);
			long kind = forDate >>> 62;
			long ticks = forDate << 2 >>> 2;
			System.out.println("kind    " + kind + "   ticks " + ticks);

			TimeZone timeZone = (kind <= 1) ? TimeZone.getTimeZone("UTC") : TimeZone.getDefault();
			System.out.println("tz = " + timeZone.getDisplayName());
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy' 'HH:mm:ss");
			dateFormat.setTimeZone(timeZone);
			long temp = 0;
			if (ticks != 0) {
				temp = (ticks - 621355968000000000L) / 10000;
			}
			System.out.println("temp " + temp);
			Date result = new Date(temp);
			System.out.println(dateFormat.format(result));
			return result;
		}
		return null;
	}

}
