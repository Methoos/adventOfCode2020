package day3;

import inputReader.InputReader;

public class DayThree {

	public static void main(String[] args) {
		String[] inputOfTheDay = InputReader.read("src/day3/day3.txt", "");
		int countedTrees = 0;
		int positionOfTheTraveler = 0;
		boolean success = false;
		int row = 0;

		while (!success) {
			if (row < inputOfTheDay.length - 1) {
				if (positionOfTheTraveler + 3 < inputOfTheDay[row].length()) {
					positionOfTheTraveler += 3;
				} else {
					positionOfTheTraveler = 2 - (inputOfTheDay[row].length() - 1 - positionOfTheTraveler);
				}
				if ("#".equals(inputOfTheDay[++row].substring(positionOfTheTraveler, positionOfTheTraveler + 1))) {
					countedTrees++;
				}
			} else {
				success = true;
			}
		}
		System.out.println("The result is: "+ countedTrees+" trees.");
	}
}
