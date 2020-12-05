package day5;

import java.util.ArrayList;
import java.util.List;

import inputReader.InputReader;

public class DayFifthSecond {
	public static void main(String[] args) {
		String[] inputOfTheDay = InputReader.read("src/day5/day5.txt", "");
		List<Integer> seatIDs = new ArrayList<Integer>();
		for (int i = 0; i < inputOfTheDay.length; i++) {
			int[] rangeOfRows = { 0, 127 };
			int[] rangeOfColumns = { 0, 7 };
			for (int j = 0; j < inputOfTheDay[i].length(); j++) {
				switch (inputOfTheDay[i].substring(j, j + 1)) {
				case "F":rangeOfRows[1] = ((rangeOfRows[0] + rangeOfRows[1]) / 2);break;
				case "B":rangeOfRows[0] = ((rangeOfRows[0] + rangeOfRows[1]) / 2);break;
				case "R":rangeOfColumns[0] = ((rangeOfColumns[0] + rangeOfColumns[1]) / 2);break;
				case "L":rangeOfColumns[1] = ((rangeOfColumns[0] + rangeOfColumns[1]) / 2);break;
				}
			}
			seatIDs.add(rangeOfRows[1] * 8 + rangeOfColumns[1]);
		}
		searchMySeatID(seatIDs);
	}

	private static void searchMySeatID(List<Integer> seatIDs) {
		for (int i = 0; i < seatIDs.size(); i++) {
			int seatID = seatIDs.get(i);
			for (int j = i + 1; j < seatIDs.size(); j++) {
				if (((seatID + 2)) == seatIDs.get(j) && !seatIDs.contains(seatID + 1)) {
					System.out.println("My seat ID is: " + (seatID + 1));
				}
			}
		}
	}
}