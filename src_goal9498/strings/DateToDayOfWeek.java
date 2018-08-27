package strings;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateToDayOfWeek {

	public static void main(String[] args) {
		int day = 1, month = 8, year = 2018;
		try {
			String result = getDayOfWeek(day, month, year);
			System.out.println(result.split(" ")[0]);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	private static String getDayOfWeek(int day, int month, int year) throws ParseException {
		
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		
		StringBuilder sb = new StringBuilder();
		sb.append(month < 10 ? "0" + month : month).append("/");
		sb.append(day < 10 ? "0" + day : day).append("/");
		sb.append(year);
		
		Date date = df.parse(sb.toString());
		return date.toString();
	}

}
