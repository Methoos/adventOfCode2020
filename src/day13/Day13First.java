package day13;

import inputReader.InputReader;

public class Day13First {
	public static void main(String[] args) {
		String[] inputOfTheDay = InputReader.read("src/day13/day13.txt", "");
		for (int i = 0; i < inputOfTheDay.length; i++) {
			System.out.println(inputOfTheDay[i]);
		}
		System.out.println(inputOfTheDay.length);
	}
}
