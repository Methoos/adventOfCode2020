package day4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import inputReader.InputReader;

public class DayFourSecond {
	public static void main(String[] args) {
		String[] inputOfTheDay = InputReader.read("src/day4/day4.txt", "");
		String[] requiredFields = { "ecl", "pid", "eyr", "hcl", "byr", "iyr", "hgt" };
		int validPassports = 0;
		int reqFieldCounter = 0;
		for (int i = 0; i < inputOfTheDay.length; i++) {
			if ((!"".equals(inputOfTheDay[i]))) {
				for (int j = 0; j < requiredFields.length; j++) {
					if (inputOfTheDay[i].contains(requiredFields[j])) {
						if (requiredFieldValidator(requiredFields[j], inputOfTheDay[i])) {
							reqFieldCounter++;
						}
						if (reqFieldCounter == 7) {
							validPassports++;
						}
					}
				}
			} else {
				reqFieldCounter = 0;
			}
		}
		System.out.println("There are " + validPassports + " valid passports.");
	}

	private static boolean requiredFieldValidator(String requiredField, String rawString) {
		String value = splitRawString(rawString, requiredField);
		boolean isValidField = false;
		switch (requiredField) {
		case "ecl":
			isValidField = validatorECL(value);
			break;
		case "pid":
			isValidField = validatorPID(value);
			break;
		case "eyr":
			isValidField = validatorEYR(value);
			break;
		case "hcl":
			isValidField = validatorHCL(value);
			break;
		case "byr":
			isValidField = validatorBYR(value);
			break;
		case "iyr":
			isValidField = validatorIYR(value);
			break;
		case "hgt":
			isValidField = validatorHGT(value);
			break;
		default:
			break;
		}
		return isValidField;
	}

	private static boolean validatorHCL(String value) {
		String regex = "[0-9]||[a-f]";
		Pattern pattern = Pattern.compile(regex);
		if (value.startsWith("#") && value.length() == 7) {
			Matcher matcher = pattern.matcher(value);
			return matcher.lookingAt();
		} else {
			return false;
		}
	}

	private static boolean validatorHGT(String value) {
		if (value.contains("in")) {
			int height = Integer.parseInt(value.split("in")[0]);
			return height <= 76 && height >= 59;
		}
		if (value.contains("cm")) {
			int height = Integer.parseInt(value.split("cm")[0]);
			return height <= 193 && height >= 150;
		}
		return false;
	}

	private static boolean validatorECL(String value) {
		String[] eyeColors = { "amb", "blu", "brn", "gry", "grn", "hzl", "oth" };
		for (int i = 0; i < eyeColors.length; i++) {
			if (value.equals(eyeColors[i])) {
				return true;
			}
		}
		return false;
	}

	private static boolean validatorPID(String value) {
		return value.length() == 9;
	}

	private static boolean validatorEYR(String value) {
		if (value.length() < 4) {
			return false;
		}
		int number = Integer.parseInt(value);
		return number <= 2030 && number >= 2020;
	}

	private static boolean validatorIYR(String value) {
		if (value.length() < 4) {
			return false;
		}
		int number = Integer.parseInt(value);
		return number <= 2020 && number >= 2010;
	}

	private static boolean validatorBYR(String value) {
		if (value.length() < 4) {
			return false;
		}
		int number = Integer.parseInt(value);
		return number <= 2002 && number >= 1920;
	}
	
	private static String splitRawString(String rawString, String requiredField) {

		String[] splittedRawString = rawString.split(" ");
		String value = null;
		for (int i = 0; i < splittedRawString.length; i++) {
			if (splittedRawString[i].contains(requiredField)) {
				value = splittedRawString[i].split(":")[1];
			}
		}
		return value;
	}
}
