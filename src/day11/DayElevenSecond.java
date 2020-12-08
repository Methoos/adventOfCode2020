package day11;

import inputReader.InputReader;

public class DayElevenSecond {
	public static void main(String[] args) {
		String[] inputOfTheDay = InputReader.read("src/day11/day11.txt", "");
		for (int i = 0; i < inputOfTheDay.length; i++) {
			System.out.println(inputOfTheDay[i]);
		}
		System.out.println(inputOfTheDay.length);
	}
}
