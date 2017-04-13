package net.zylk.liferay.portal.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


public class DateFormatUtil  {
	
	// borrar lo siguiente cuando se añada hora/min en la configuracion de cada newsletter.
	// ahora se esta almacenando 0/0/0/0 (hora/min/sec/ms), así que seteo la hora
	private static SimpleDateFormat SDF_Time = new SimpleDateFormat("HH:mm");
	
	static {
		
		SDF_Time.setTimeZone(TimeZone.getDefault());
	}

	// borrar lo siguiente cuando se añada hora/min en la configuracion de cada newsletter.
	// ahora se esta almacenando 0/0/0/0 (hora/min/sec/ms), así que seteo la hora
	public static Date parseDefaultTimeZone(String date) throws ParseException {

		return SDF_Time.parse(date);
	}
	
}