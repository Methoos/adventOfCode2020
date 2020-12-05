package day5;

import inputReader.InputReader;

public class DayFifthFirst {
	public static void main(String[] args) {
		String[] inputOfTheDay = InputReader.read("src/day5/day5.txt", "");
		int maxSeatID = 0;
		int seatID = 0;
		for (int i = 0; i < inputOfTheDay.length; i++) {
			int[] rangeOfRows = { 0, 127 };
			int[] rangeOfColumns = { 0, 7 };
			for (int j = 0; j < inputOfTheDay[i].length(); j++) {
				switch (inputOfTheDay[i].substring(j, j + 1)) {
				case "F":rangeOfRows[1] = ((rangeOfRows[0] + rangeOfRows[1]) / 2);break;
				case "B":rangeOfRows[0] = ((rangeOfRows[0] + rangeOfRows[1]) / 2);break;
				case "R":rangeOfColumns[0] = ((rangeOfColumns[0] + rangeOfColumns[1]) / 2);break;
				case "L": rangeOfColumns[1] = ((rangeOfColumns[0] + rangeOfColumns[1])/ 2);break;
				}
				seatID = rangeOfRows[1] * 8 + rangeOfColumns[1];
			}
			if (maxSeatID <= seatID) maxSeatID = seatID;
		}
		System.out.println("The biggest seat ID is: " + maxSeatID);
	}
}