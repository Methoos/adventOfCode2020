package day12;

import inputReader.InputReader;

public class DayTwelveSecond {
	public static void main(String[] args) {
		String[] inputOfTheDay = InputReader.read("src/day12/example.txt", "");
		for (int i = 0; i < inputOfTheDay.length; i++) {
			System.out.println(inputOfTheDay[i]);
		}
		System.out.println(inputOfTheDay.length);
	}
}
