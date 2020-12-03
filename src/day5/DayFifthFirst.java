package day5;

import inputReader.InputReader;

public class DayFifthFirst {
	public static void main(String[] args) {
		String[] inputOfTheDay = InputReader.read("src/day5/day5.txt", "");	
		for (int i = 0; i < inputOfTheDay.length; i++) {
			System.out.println(inputOfTheDay[i]);
		}
		System.out.println(inputOfTheDay.length);
	}
}
