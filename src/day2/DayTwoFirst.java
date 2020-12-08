package day2;

import inputReader.InputReader;

public class DayTwoFirst {
//example: 9-12 q: qqqxhnhdmqqqqjz
	public static void main(String[] args) {
		String[] inputOfTheDay = InputReader.read("src/day2/day2.txt", "");
		int numberOfValidPasswords = 0;

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

				if (passwordValidator(passwordAsCharacterArray, searchedCharInThePassword, minLimit,
						maxLimit)) {
					numberOfValidPasswords++;
				}
			}
		}
		System.out.println("Result is for the first half: " + numberOfValidPasswords);
	}

	private static boolean passwordValidator(char[] passwordAsCharacterArray,
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
