package day13;

import inputReader.InputReader;

public class Day13First {
	public static void main(String[] args) {
		String[] inputOfTheDay = InputReader.read("src/day13/day13.txt", "");
		System.out
				.println("Earliest bus ID multiplied waiting minutes: " + findEarliestBus(inputOfTheDay));
	}

	private static int findEarliestBus(String[] inputOfTheDay) {
		final int startTimeStamp = Integer.parseInt(inputOfTheDay[0]);
		int solution = 0;
		int min = Integer.MAX_VALUE;
		for (int busID = 1; busID < inputOfTheDay.length; busID++) {
			int ID = Integer.parseInt(inputOfTheDay[busID]);
			int diff = calcTimestampDiff(ID, startTimeStamp);
			if (diff < min) {
				solution = diff * ID; min = diff;
			}
		}
		return solution;
	}

	private static int calcTimestampDiff(int busID, int startTimeStamp) {
		return ((startTimeStamp / busID) + 1) * busID - startTimeStamp;
	}
}