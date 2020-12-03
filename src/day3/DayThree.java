package day3;

import inputReader.InputReader;

public class DayThree {

	public static void main(String[] args) {
		String[] inputOfTheDay = InputReader.read("src/day3/day3.txt", "");

		for (int i = 0; i < inputOfTheDay.length; i++) {
			System.out.println(inputOfTheDay[i]);	
		}
		System.out.println(inputOfTheDay.length);
	}
}
