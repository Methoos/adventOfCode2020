package day5;

import inputReader.InputReader;

public class DayFifthFirst {
	public static void main(String[] args) {
		String[] inputOfTheDay = InputReader.read("src/day5/day5.txt", "");
		int seatID = 0;
		for (int i = 0; i < inputOfTheDay.length; i++) {
			int[] rangeOfRows = { 0, 127 };
			int[] rangeOfColumns = { 0, 7 };
			for (int j = 0; j < inputOfTheDay[i].length(); j++) {
				int sumRow = rangeOfRows[0] + rangeOfRows[1];
				int sumColumn = rangeOfColumns[0] + rangeOfColumns[1];
				if (inputOfTheDay[i].substring(j, j + 1).equals("F")) {
					rangeOfRows[1] = (sumRow / 2);
				}
				if (inputOfTheDay[i].substring(j, j + 1).equals("B")) {
					rangeOfRows[0] = (sumRow / 2);
				}
				if (inputOfTheDay[i].substring(j, j + 1).equals("R")) {
					rangeOfColumns[0] = (sumColumn / 2);
				}
				if (inputOfTheDay[i].substring(j, j + 1).equals("L")) {
					rangeOfColumns[1] = (sumColumn / 2);
				}
			}
			if (seatID <= (rangeOfRows[1] * 8 + rangeOfColumns[1])) {
				seatID = rangeOfRows[1] * 8 + rangeOfColumns[1];
			}
		}
		System.out.println("The biggest seat ID is: " + seatID);
	}
}
