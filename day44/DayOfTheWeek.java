package com.akash.day44;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

public class DayOfTheWeek {
	public static void main(String[] args) {
		int day = 29;
		int month = 7;
		int year = 2024;
		System.out.println(solution1(day, month, year));
		System.out.println(solution2(day, month, year));
		System.out.println(solution3(day, month, year));
	}

	private static String solution2(int day, int month, int year) {
		LocalDate date = LocalDate.of(year, month, day);
		return date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
	}

	private static String solution3(int day, int month, int year) {
		String[] days = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, day);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		return days[dayOfWeek - 1];
	}

	private static String solution1(int day, int month, int year) {
		String[] week = { "Thursday", "Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday" };
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 1; i <= 12; i++) {
			if (i == 2)
				map.put(i, 28);
			else if (i == 4 || i == 6 || i == 9 || i == 11)
				map.put(i, 30);
			else
				map.put(i, 31);
		}
		System.out.println(map);
		int count = 0;
		for (int i = 1971; i < year; i++) {
			if (i % 4 == 0 && ((i % 100 != 0) || (i % 400 == 0)))
				count += 366;
			else
				count += 365;
		}
		System.out.println(count);// 17532
		if (year % 4 == 0 && ((year % 100 != 0) || (year % 400 == 0)))
			map.put(2, 29);

		int total = 0;
		for (int i = 1; i < month; i++)
			total += map.get(i);

		System.out.println(total);
		int totalTillTheDate = count + total + day;
		System.out.println(totalTillTheDate);
		int rem = (totalTillTheDate) % 7;
		System.out.println(rem);
		return week[rem];
	}

}
