package basic.topic.interview;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ISTtoGMTConverter {
	public static void main(String[] args) {
		String istDateString = "2024-05-06 11:51:05";

		// Define input format
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		// Parse as LocalDateTime (no timezone yet)
		LocalDateTime localDateTime = LocalDateTime.parse(istDateString, formatter);

		// Assign IST timezone
		ZonedDateTime istZonedDateTime = localDateTime.atZone(ZoneId.of("Asia/Kolkata"));

		// Convert to GMT
		ZonedDateTime gmtZonedDateTime = istZonedDateTime.withZoneSameInstant(ZoneId.of("GMT"));

		// Output in same format
		String gmtFormatted = gmtZonedDateTime.format(formatter);

		System.out.println("IST Time: " + istDateString);
		System.out.println("GMT Time: " + gmtFormatted);
	}
}
