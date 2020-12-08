package day2;

import inputReader.InputReader;

public class DayTwoSecond {
	// example: 9-12 q: qqqxhnhdmqqqqjz
	public static void main(String[] args) {
		String[] inputOfTheDay = InputReader.read("src/day2/day2.txt", "");
		int numberOfValidPasswords = 0;

		for (int i = 0; i < inputOfTheDay.length; i++) {
			String[] splittedPolicy = inputOfTheDay[i].split(": ");
			String[] limitsAndThechar = splittedPolicy[0].split(" ");
			String[] limits = limitsAndThechar[0].split("-");

			String passWord = splittedPolicy[1];
			char searchedCharInThePassword = limitsAndThechar[1].charAt(0);
			int minIdx = Integer.parseInt(limits[0]);
			int maxIdx = Integer.parseInt(limits[1]);

			if (passWord.contains(limitsAndThechar[1])) {
				char[] passwordAsCharacterArray = passWord.toCharArray();
				if (passwordValidator(passwordAsCharacterArray, searchedCharInThePassword, minIdx,
						maxIdx)) {
					numberOfValidPasswords++;
				}
			}
		}
		System.out.println("Result is for the second half: " + numberOfValidPasswords);
	}

	private static boolean passwordValidator(char[] passwordAsCharacterArray,
			char searchedCharInThePassword, int minLimit, int maxLimit) {
		boolean valid = false;
		// (passwordAsCharacterArray[minLimit - 1] == searchedCharInThePassword) ^
		// (passwordAsCharacterArray[maxLimit - 1] == searchedCharInThePassword)
		if (passwordAsCharacterArray[minLimit - 1] == searchedCharInThePassword) {
			valid = true;
		}
		if (passwordAsCharacterArray[maxLimit - 1] == searchedCharInThePassword) {
			valid = !valid;
		}
		return valid;
	}
}
