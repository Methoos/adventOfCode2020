package day4;

import inputReader.InputReader;

public class DayFourSecond {
	public static void main(String[] args) {
		String[] inputOfTheDay = InputReader.read("src/day4/day4.txt", "");
		for (int i = 0; i < inputOfTheDay.length; i++) {
			System.out.println(inputOfTheDay[i]);
		}
		System.out.println(inputOfTheDay.length);
	}
}
