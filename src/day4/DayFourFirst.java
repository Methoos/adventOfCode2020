package day4;

import inputReader.InputReader;

public class DayFourFirst {
	public static void main(String[] args) {
		String[] inputOfTheDay = InputReader.read("src/day4/day4.txt", "");
		String[] requiredFields = { "ecl", "pid", "eyr", "hcl", "byr", "iyr", "hgt" };
		int validPassports = 0;
		int reqFieldCounter = 0;
		for (int i = 0; i < inputOfTheDay.length; i++) {
			if ((!"".equals(inputOfTheDay[i]))) {
				for (int j = 0; j < requiredFields.length; j++) {
					if (inputOfTheDay[i].contains(requiredFields[j])) {
						reqFieldCounter++;
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
}
