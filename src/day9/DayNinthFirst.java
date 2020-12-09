package day9;

import java.util.ArrayList;
import java.util.List;

import inputReader.InputReader;

public class DayNinthFirst {
	public static void main(String[] args) {
		String[] inputOfTheDay = InputReader.read("src/day9/day9.txt", "");
		final int preamble = 25;
		List<Long> numbersList = createLongFromLines(inputOfTheDay);

		System.out.println(searchForTheNumber(numbersList, preamble) + " is the searched number.");
	}

	private static List<Long> createLongFromLines(String[] inputOfTheDay) {
		List<Long> numbersList = new ArrayList<Long>();
		for (int line = 0; line < inputOfTheDay.length; line++) {
			numbersList.add(Long.parseLong(inputOfTheDay[line]));
		}
		return numbersList;
	}

	private static long searchForTheNumber(List<Long> numbersList, int preamble) {
		for (int theNumbIdx = preamble; theNumbIdx < numbersList.size(); theNumbIdx++) {
			if (!searchInSubList(numbersList, numbersList.get(theNumbIdx), theNumbIdx, preamble)) {
				return numbersList.get(theNumbIdx);
			}
		}
		return -1;
	}

	private static boolean searchInSubList(List<Long> numbersList, long searchedNumber, int theNumbIdx, int preamble) {
		for (int firstNumbIdx = theNumbIdx - preamble; firstNumbIdx < theNumbIdx - 1; firstNumbIdx++) {
			if (searchInSubSubList(numbersList.get(firstNumbIdx), numbersList, firstNumbIdx, theNumbIdx, searchedNumber)) {
				return true;
			}
		}
		return false;
	}

	private static boolean searchInSubSubList(long firstNumb, List<Long> numbersList, int firstNumbIdx, int theNumbIdx,
			long searchedNumber) {
		int secondNumbIdx = firstNumbIdx + 1;
		while (secondNumbIdx < theNumbIdx) {
			if (checkSum(firstNumb, numbersList.get(secondNumbIdx), searchedNumber, numbersList)) {
				return true;
			}
			secondNumbIdx++;
		}
		return false;
	}

	private static boolean checkSum(long firstNumb, long secondNumber, long searchedNumber, List<Long> numbersList) {
		return searchedNumber == firstNumb + secondNumber;
	}
}
