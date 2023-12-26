package demo.java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DemoDateAndTimeAPI {
	public static void main(String[] args) {
		// Demo LocalDate
		LocalDate currentDate = LocalDate.now();
		System.out.println("Current date: " + currentDate);

		// Demo LocalTime
		LocalTime currentTime = LocalTime.now();
		System.out.println("Current time: " + currentTime);

		// Demo LocalDateTime
		ZonedDateTime zoneDateTime = ZonedDateTime.now();
		System.out.println("current zoneDateTime: " + zoneDateTime);

		// Demo LocalDateTime
		LocalDateTime currentDateTime = LocalDateTime.now();
		System.out.println("current DateTime: " + currentDateTime);

		// -1 day
		LocalDate yesterday = currentDate.minusDays(1);
		System.out.println("localDate after minus: " + yesterday);

		// +2 day
		LocalDate plusDays = currentDate.plusDays(2);
		System.out.println("localDate after plus: " + plusDays);

		// Demo DateTimeFormatter
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String formattedDate = currentDate.format(formatter);
		System.out.println("Date formated: " + formattedDate);

		// Demo of(yyyy, MM, dd) by LocalDate create Date
		LocalDate specificDate = LocalDate.of(2023, 12, 26);
		System.out.println("Date created: " + specificDate);

		// Demo compare Date
		System.out.println("The day before the current day " 
		+ specificDate + " : " + currentDate.isBefore(specificDate));
		System.out.println("The day after the current day " 
		+ specificDate + " : " + currentDate.isAfter(specificDate));
	}
}
