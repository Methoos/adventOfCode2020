package day15;

import inputReader.InputReader;

public class Day15Second {
	public static void main(String[] args) {
		String[] inputOfTheDay = InputReader.read("src/day15/day15.txt", "");
		for (int i = 0; i < inputOfTheDay.length; i++) {
			System.out.println(inputOfTheDay[i]);
		}
		System.out.println(inputOfTheDay.length);
	}
}
