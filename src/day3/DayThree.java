package day3;

import inputReader.InputReader;

public class DayThree {

	public static void main(String[] args) {
		String[] inputOfTheDay = InputReader.read("src/day3/day3.txt", "");
		long multipliedTrees = 1L;

		multipliedTrees *= countingTrees(1, 1, inputOfTheDay);
		multipliedTrees *= countingTrees(3, 1, inputOfTheDay);
		multipliedTrees *= countingTrees(5, 1, inputOfTheDay);
		multipliedTrees *= countingTrees(7, 1, inputOfTheDay);
		multipliedTrees *= countingTrees(1, 2, inputOfTheDay);
		System.out.println("Result of multiplied trees: " + multipliedTrees);
	}

	private static int countingTrees(int moveRight, int moveDown, String[] inputOfTheDay) {

		int countedTrees = 0;
		int positionOfTheTraveler = 0;
		int row = 0;
		while (row < inputOfTheDay.length - moveDown) {
			if ('#' == inputOfTheDay[row].charAt(positionOfTheTraveler)) {
				countedTrees++;
			}
			positionOfTheTraveler = (positionOfTheTraveler + moveRight) % inputOfTheDay[row].length();
			row += moveDown;
		}
		System.out.println("The result is: " + countedTrees + " trees for right=" + moveRight + " and down=" + moveDown
				+ " excercise.");
		return countedTrees;
	}

}
