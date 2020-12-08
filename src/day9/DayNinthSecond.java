package day9;

import inputReader.InputReader;

public class DayNinthSecond {
	public static void main(String[] args) {
		String[] inputOfTheDay = InputReader.read("src/day9/day9.txt", "");
		for (int i = 0; i < inputOfTheDay.length; i++) {
			System.out.println(inputOfTheDay[i]);
		}
		System.out.println(inputOfTheDay.length);
	}
}
