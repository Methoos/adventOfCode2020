package day3;

import inputReader.InputReader;

public class DayThreeFirst {

	public static void main(String[] args) {
		String[] inputOfTheDay = InputReader.read("src/day3/day3.txt", "");
		int countedTrees = 0;
		int positionOfTheTraveler = 0;
		int row = 0;
		while (row < inputOfTheDay.length - 1) {
			if ('#' == inputOfTheDay[row].charAt(positionOfTheTraveler)) {
				countedTrees++;
			}
			positionOfTheTraveler = (positionOfTheTraveler + 3) % inputOfTheDay[row].length();
			row += 1;
		}
		System.out.println("The result is: " + countedTrees + ".");
	}
}
