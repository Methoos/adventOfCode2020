package day6;

import inputReader.InputReader;

public class DaySixthFirst {
	public static void main(String[] args) {
		String[] inputOfTheDay = InputReader.read("src/day6/day6.txt", "");	
		for (int i = 0; i < inputOfTheDay.length; i++) {
			System.out.println(inputOfTheDay[i]);
		}
		System.out.println(inputOfTheDay.length);
	}
}
