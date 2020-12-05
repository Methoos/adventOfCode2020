package day7;

import inputReader.InputReader;

public class DaySeventhFirst {
	public static void main(String[] args) {
		String[] inputOfTheDay = InputReader.read("src/day7/day7.txt", "");
		for (int i = 0; i < inputOfTheDay.length; i++) {
			System.out.println(inputOfTheDay[i]);
		}
		System.out.println(inputOfTheDay.length);
	}
}
