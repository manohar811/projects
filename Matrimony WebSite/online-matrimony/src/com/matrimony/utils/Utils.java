package com.matrimony.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.matrimony.constants.Constants;
import com.matrimony.exceptions.AppException;
import com.matrimony.vo.enums.Education;

public final class Utils {

	private static final String SHORT_DATE_FORMAT = "dd/MM/yyyy";
	private static final SimpleDateFormat sdfddMMyyyy = new SimpleDateFormat(SHORT_DATE_FORMAT);

	public static String toString(List<?> list) {
		StringBuilder result = new StringBuilder();
		for (Object obj : list) {
			result.append((obj != null) ? obj.toString() : null).append(", ");
		}

		// delete last two chars
		int length = result.length();
		if (length > 0) {
			result.delete(length - 2, length);
		}
		return result.toString();
	}

	public static Date toDate(String date) throws AppException {
		try {
			return sdfddMMyyyy.parse(date);
		} catch (ParseException e) {
			throw new AppException("Date must be in " + SHORT_DATE_FORMAT.toLowerCase() + " format.", e);
		}
	}

	public static int getAgeInYears(Date birthDate) {
		Date now = Calendar.getInstance().getTime();
		double elapsed = now.getTime() - birthDate.getTime();

		double diff = elapsed / Constants.MILLISECONDS_IN_DAY;
		return (int) (diff / 365);
	}

	public static int getAgeInMonths(Date birthDate) {
		Date now = Calendar.getInstance().getTime();
		double elapsed = now.getTime() - birthDate.getTime();

		double diff = elapsed / Constants.MILLISECONDS_IN_DAY;
		return (int) (diff / 365);
	}

	public static String getAgeInYearsAndMonths(Date birthDate) {
		String yearsMonths = "%d years, %d months";
		String years = "%d years";
		Date now = Calendar.getInstance().getTime();
		int months = monthsBetween(birthDate, now);
		int ageMonths = months % 12;
		int ageYears = (months - ageMonths) / 12;
		if (ageMonths != 0) {
			return String.format(yearsMonths, ageYears, ageMonths);
		} else {
			return String.format(years, ageYears);
		}
	}

	public static int dateDiff(Date startDate, Date endDate, int diffIn) {
		Calendar startDateCal = Calendar.getInstance();
		startDateCal.setTime(startDate);
		Calendar endDateCal = Calendar.getInstance();
		endDateCal.setTime(endDate);

		Calendar tempStartdate = (Calendar) startDateCal.clone();
		int diff = 0;
		while (tempStartdate.before(endDateCal)) {
			tempStartdate.add(diffIn, 1);
			// System.out.println(sdfddMMyyyy.format(tempStartdate.getTime()));
			diff++;
		}

		// substract one to provide completed age
		return (diff - 1);
	}

	public static int daysBetween(Date startDate, Date endDate) {
		return dateDiff(startDate, endDate, Calendar.DAY_OF_MONTH);
	}

	public static int yearsBetween(Date startDate, Date endDate) {
		return dateDiff(startDate, endDate, Calendar.YEAR);
	}

	public static int monthsBetween(Date startDate, Date endDate) {
		return dateDiff(startDate, endDate, Calendar.MONTH);
	}

	public static String toString(String[] array) {
		StringBuilder result = new StringBuilder();

		if (array != null) {
			for (String s : array) {
				result.append(s).append(", ");
			}

			// delete last comma
			result.delete(result.length() - 2, result.length());
		}

		return result.toString();
	}

	public static void main(String[] args) throws Exception {
		System.out.println(Education.BACHELOR_OF_ARTS.getLiteral());
		
		for (int i = 1; i < 50; i++) {
			System.out.println("my_profile.age." + i + "=" + (i + 17));
		}

		// System.out.println(getAgeInYearsAndMonths(sdfddMMyyyy.parse("29/02/2000")));
		//
		// System.out.println("केतू , ८");
		/*System.out.println(OptionsEnum.KETU.getOption());*/

		/*int monthsDiff = monthsBetween(sdfddMMyyyy.parse("13/10/1980"), new Date());

		System.out.println("Months Diff: " + monthsDiff);

		int ageMonths = monthsDiff % 12;
		int ageYears = (monthsDiff - ageMonths) / 12;

		System.out.println(ageYears + " years and " + ageMonths + " months");

		System.out.println(yearsBetween(sdfddMMyyyy.parse("13/10/1980"), new Date()));*/
	}
}
