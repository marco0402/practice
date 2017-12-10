package com.mcapp.practice.java8.datetime;

import java.time.Clock;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimePractice {
	public static void main(String[] args) {
		DateTimeFormatter dateFt = DateTimeFormatter.ISO_DATE;
		DateTimeFormatter timeFt = DateTimeFormatter.ISO_TIME;
		DateTimeFormatter dateTimeFt = DateTimeFormatter.ISO_DATE_TIME;

		Clock utcClock = Clock.systemUTC();
		Clock defaultZoneClock = Clock.systemDefaultZone();
		Clock specificZoneClock = Clock.system(ZoneId.of("Asia/Tokyo"));

		LocalDate lDFromUtcClock = LocalDate.now(utcClock);
		LocalTime lTFromUtcClock = LocalTime.now(utcClock);
		LocalDateTime lDTFromUtcClock = LocalDateTime.now(utcClock);
		ZonedDateTime zDTFromUtcClock = ZonedDateTime.now(utcClock);

		System.out.println("UTC Clock Local Date: " + dateFt.format(lDFromUtcClock));
		System.out.println("UTC Clock Local Time: " + timeFt.format(lTFromUtcClock));
		System.out.println("UTC Clock Local Date Time: " + dateTimeFt.format(lDTFromUtcClock));
		System.out.println("UTC Clock Zoned Date Time: " + dateTimeFt.format(zDTFromUtcClock));

		LocalDate lDFromDefaultZoneClock = LocalDate.now(defaultZoneClock);
		LocalTime lTFromDefaultZoneClock = LocalTime.now(defaultZoneClock);
		LocalDateTime lDTFromDefaultZoneClock = LocalDateTime.now(defaultZoneClock);
		ZonedDateTime zDTFromDefaultZoneClock = ZonedDateTime.now(defaultZoneClock);

		System.out.println("Default Zone Clock Local Date: " + dateFt.format(lDFromDefaultZoneClock));
		System.out.println("Default Zone Clock Local Time: " + timeFt.format(lTFromDefaultZoneClock));
		System.out.println("Default Zone Clock Local Date Time: " + dateTimeFt.format(lDTFromDefaultZoneClock));
		System.out.println("Default Zone Clock Zoned Date Time: " + dateTimeFt.format(zDTFromDefaultZoneClock));

		LocalDate lDFromSpecificZoneClock = LocalDate.now(specificZoneClock);
		LocalTime lTFromSpecificZoneClock = LocalTime.now(specificZoneClock);
		LocalDateTime lDTFromSpecificZoneClock = LocalDateTime.now(specificZoneClock);
		ZonedDateTime zDTFromSpecificZoneClock = ZonedDateTime.now(specificZoneClock);

		System.out.println("Specific Zone Clock Local Date: " + dateFt.format(lDFromSpecificZoneClock));
		System.out.println("Specific Zone Clock Local Time: " + timeFt.format(lTFromSpecificZoneClock));
		System.out.println("Specific Zone Clock Local Date Time: " + dateTimeFt.format(lDTFromSpecificZoneClock));
		System.out.println("Specific Zone Clock Zoned Date Time: " + dateTimeFt.format(zDTFromSpecificZoneClock));

		LocalDate lDNow = LocalDate.now();
		LocalTime lTNow = LocalTime.now();
		LocalDateTime lDTNow = LocalDateTime.now();
		ZonedDateTime zDTNow = ZonedDateTime.now();

		System.out.println("Now Local Date: " + dateFt.format(lDNow));
		System.out.println("Now Local Time: " + timeFt.format(lTNow));
		System.out.println("Now Local Date Time: " + dateTimeFt.format(lDTNow));
		System.out.println("Now Zoned Date Time: " + dateTimeFt.format(zDTNow));

		LocalDate lDSpecificZoneNow = LocalDate.now(ZoneId.of("Asia/Tokyo"));
		LocalTime lTSpecificZoneNow = LocalTime.now(ZoneId.of("Asia/Tokyo"));
		LocalDateTime lDTSpecificZoneNow = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));
		ZonedDateTime zDTSpecificZoneNow = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));

		System.out.println("Specific Zone Now Local Date: " + dateFt.format(lDSpecificZoneNow));
		System.out.println("Specific Zone Now Local Time: " + timeFt.format(lTSpecificZoneNow));
		System.out.println("Specific Zone Now Local Date Time: " + dateTimeFt.format(lDTSpecificZoneNow));
		System.out.println("Specific Zone Now Zoned Date Time: " + dateTimeFt.format(zDTSpecificZoneNow));

		LocalDate lDSpecificValue = LocalDate.of(2007, 12, 24);
		LocalTime lTSpecificValue = LocalTime.of(18, 31, 42, 53);
		LocalDateTime lDTSpecificValue = LocalDateTime.of(2007, 12, 24, 18, 31, 42, 53);
		ZonedDateTime zDTSpecificValue = ZonedDateTime.of(2008, 7, 21, 14, 27, 41, 55, ZoneId.of("Asia/Tokyo"));

		System.out.println("Specific Value Local Date: " + dateFt.format(lDSpecificValue));
		System.out.println("Specific Value Local Time: " + timeFt.format(lTSpecificValue));
		System.out.println("Specific Value Local Date Time: " + dateTimeFt.format(lDTSpecificValue));
		System.out.println("Specific Value Zoned Date Time: " + dateTimeFt.format(zDTSpecificValue));

		Duration duration = Duration.between(lDTSpecificValue, zDTSpecificValue);

		System.out.println("Duration Days: " + duration.toDays());
		System.out.println("Duration Hours: " + duration.toHours());
	}
}
