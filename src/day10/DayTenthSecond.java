package day10;

import inputReader.InputReader;

public class DayTenthSecond {
	public static void main(String[] args) {
		String[] inputOfTheDay = InputReader.read("src/day10/day10.txt", "");
		for (int i = 0; i < inputOfTheDay.length; i++) {
			System.out.println(inputOfTheDay[i]);
		}
		System.out.println(inputOfTheDay.length);
	}
}
