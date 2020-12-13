package day14;

import inputReader.InputReader;

public class Day14First {
	public static void main(String[] args) {
		String[] inputOfTheDay = InputReader.read("src/day14/day14.txt", "");
		for (int i = 0; i < inputOfTheDay.length; i++) {
			System.out.println(inputOfTheDay[i]);
		}
		System.out.println(inputOfTheDay.length);
	}
}
