package day9;

import java.util.ArrayList;
import java.util.List;

import inputReader.InputReader;

public class DayNinthFirst {
	public static void main(String[] args) {
		String[] inputOfTheDay = InputReader.read("src/day9/day9.txt", "");
		final int preamble = 25;
		List<Long> numbers = createLongFromLines(inputOfTheDay);

		System.out.println(searchForTheNumber(numbers, preamble) + " is the searched number.");
	}

	private static List<Long> createLongFromLines(String[] inputOfTheDay) {
		List<Long> numbers = new ArrayList<Long>();
		for (int i = 0; i < inputOfTheDay.length; i++) {
			numbers.add(Long.parseLong(inputOfTheDay[i]));
		}
		return numbers;
	}

	private static long searchForTheNumber(List<Long> Numbers, int preamble) {
		for (int numb = preamble; numb < Numbers.size(); numb++) {
			if (!searchInSubList(Numbers, Numbers.get(numb), numb, preamble)) {
				return Numbers.get(numb);
			}
		}
		return -1;
	}

	private static boolean searchInSubList(List<Long> numbers, long searchedNumber, int numb, int preamble) {
		for (int i = numb - preamble; i < numb - 1; i++) {
			if (searchInSubSubList(numbers.get(i), numbers, i, numb, searchedNumber)) {
				return true;
			}
		}
		return false;
	}

	private static boolean searchInSubSubList(long firstNumb, List<Long> numbers, int i, int numb,
			long searchedNumber) {
		int j = i + 1;
		while (j < numb) {
			if (checkSum(firstNumb, numbers.get(j), searchedNumber, numbers)) {
				return true;
			}
			j++;
		}
		return false;
	}

	private static boolean checkSum(long firstNumb, long secondNumber, long searchedNumber, List<Long> numbers) {
		return searchedNumber == firstNumb + secondNumber;
	}
}
