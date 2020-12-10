package day10;

import java.util.Set;
import java.util.TreeSet;

import inputReader.InputReader;

public class DayTenthFirst {
	public static void main(String[] args) {
		String[] inputOfTheDay = InputReader.read("src/day10/day10.txt", "");
		Integer[] adapters = makeSortedIntegerArrayFromLines(inputOfTheDay);
		System.out.println("Multiplied 1 and 3 differences is: "+multipleDifferences(adapters));
	}

	private static int multipleDifferences(Integer[] adapters) {
		int rating = 0; int diffOne = 0; int diffThree = 0;
		for (int i = 0; i < adapters.length; i++) {
			if ((adapters[i] - rating) == 1) diffOne++;
			if ((adapters[i] - rating) == 3) diffThree++;
			rating = adapters[i];
		}
		return diffOne * ++diffThree;
	}

	private static Integer[] makeSortedIntegerArrayFromLines(String[] inputOfTheDay) {
		Set<Integer> adapters = new TreeSet<>();
		for (int line = 0; line < inputOfTheDay.length; line++) {
			adapters.add(Integer.parseInt(inputOfTheDay[line]));
		}
		return adapters.toArray(new Integer[adapters.size()]);
	}
}