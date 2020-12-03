package day2;

import inputReader.InputReader;

public class DayTwo {
//example: 9-12 q: qqqxhnhdmqqqqjz
	public static void main(String[] args) {
		String[] inputOfTheDay = InputReader.read("src/day2/day2.txt", "");
		int numberOfValidPasswordsForFirstHalf = 0;
		int numberOfValidPasswordsForSecondHalf = 0;

		for (int i = 0; i < inputOfTheDay.length; i++) {
			String[] splittedPolicy = inputOfTheDay[i].split(": ");
			String[] limitsAndThechar = splittedPolicy[0].split(" ");
			String[] limits = limitsAndThechar[0].split("-");

			String passWord = splittedPolicy[1];
			char searchedCharInThePassword = limitsAndThechar[1].charAt(0);
			int minLimit = Integer.parseInt(limits[0]);
			int maxLimit = Integer.parseInt(limits[1]);

			if (passWord.contains(limitsAndThechar[1])) {
				char[] passwordAsCharacterArray = passWord.toCharArray();

				if (passwordValidatorForFirstHalf(passwordAsCharacterArray, searchedCharInThePassword, minLimit,
						maxLimit)) {
					numberOfValidPasswordsForFirstHalf++;
				}

				if (passwordValidatorForSecondtHalf(passwordAsCharacterArray, searchedCharInThePassword, minLimit,
						maxLimit)) {
					numberOfValidPasswordsForSecondHalf++;
				}
			}
		}
		System.out.println("Result is for the first half: " + numberOfValidPasswordsForFirstHalf);
		System.out.println("Result is for the second half: " + numberOfValidPasswordsForSecondHalf);
	}

	private static boolean passwordValidatorForSecondtHalf(char[] passwordAsCharacterArray,
			char searchedCharInThePassword, int minLimit, int maxLimit) {
		boolean valid = false;
		if (passwordAsCharacterArray[minLimit - 1] == searchedCharInThePassword) {
			valid=true;
		}
		if (passwordAsCharacterArray[maxLimit - 1] == searchedCharInThePassword) {
			valid=!valid;
		}
		return valid;
	}

	private static boolean passwordValidatorForFirstHalf(char[] passwordAsCharacterArray,
			char searchedCharInThePassword, int minLimit, int maxLimit) {
		int numberOfSearchedCharacter = 0;
		for (int j = 0; j < passwordAsCharacterArray.length; j++) {
			if (passwordAsCharacterArray[j] == searchedCharInThePassword) {
				numberOfSearchedCharacter++;
			}
		}
		if (numberOfSearchedCharacter <= maxLimit && numberOfSearchedCharacter >= minLimit) {
			return true;
		}
		return false;
	}
}
