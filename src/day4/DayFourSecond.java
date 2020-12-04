package day4;

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
		return value.matches("^#[0-9a-f]{6}$");
	}

	private static boolean validatorHGT(String value) {
		if (value.contains("in")) {
			value = value.split("in")[0];
			return betweenMinMax(value, 59, 76);
		}
		if (value.contains("cm")) {
			value = value.split("cm")[0];
			return betweenMinMax(value, 150, 193);
		}
		return false;
	}

	private static boolean betweenMinMax(String value, int min, int max) {
		int number = Integer.parseInt(value);
		return number >= min && number <= max;
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
		if (lengthCheck(value))  {
			return betweenMinMax(value, 2020, 2030);
		}
		return false;
	}

	private static boolean validatorIYR(String value) {
		if (lengthCheck(value)) {
			return betweenMinMax(value, 2010, 2020);
		}
		return false;
	}

	private static boolean validatorBYR(String value) {
		if (lengthCheck(value)) {
			return betweenMinMax(value, 1920, 2002);
		}
		return false;
	}

	private static boolean lengthCheck(String value) {
		if (value.length() == 4) {
			return true;
		}
		return false;
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