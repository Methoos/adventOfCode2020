package day9;

import java.util.ArrayList;
import java.util.List;

import inputReader.InputReader;

public class DayNinthFirst {
	public static void main(String[] args) {
		String[] inputOfTheDay = InputReader.read("src/day9/day9.txt", "");
		final int preamble = 25;
//		String[] inputOfTheDay = InputReader.read("src/day9/example.txt", "");
//		final int preamble = 5;
		List<Long> numberList = createLongFromLines(inputOfTheDay);
		System.out.println(searchForTheNumber(numberList, preamble) + " is the invalid number.");
	}

	private static List<Long> createLongFromLines(String[] inputOfTheDay) {
		List<Long> numberList = new ArrayList<Long>();
		for (int line = 0; line < inputOfTheDay.length; line++) {
			numberList.add(Long.parseLong(inputOfTheDay[line]));
		}
		return numberList;
	}

	private static long searchForTheNumber(List<Long> numberList, int preamble) {
		for (int theNumbIdx = preamble; theNumbIdx < numberList.size(); theNumbIdx++) {
			if (!searchInSubList(numberList, numberList.get(theNumbIdx), theNumbIdx, preamble)) {
				return numberList.get(theNumbIdx);
			}
		}
		return -1;
	}

	private static boolean searchInSubList(List<Long> numberList, long searchedNumber, int theNumbIdx, int preamble) {
		for (int firstNumbIdx = theNumbIdx - preamble; firstNumbIdx < theNumbIdx - 1; firstNumbIdx++) {
			if (searchInSubSubList(numberList.get(firstNumbIdx), numberList, firstNumbIdx, theNumbIdx, searchedNumber)) {
				return true;
			}
		}
		return false;
	}

	private static boolean searchInSubSubList(long firstNumb, List<Long> numberList, int firstNumbIdx, int theNumbIdx,
			long searchedNumber) {
		int secondNumbIdx = firstNumbIdx + 1;
		while (secondNumbIdx < theNumbIdx) {
			if (checkSum(firstNumb, numberList.get(secondNumbIdx), searchedNumber, numberList)) {
				return true;
			}
			secondNumbIdx++;
		}
		return false;
	}

	private static boolean checkSum(long firstNumb, long secondNumber, long searchedNumber, List<Long> numberList) {
		return searchedNumber == firstNumb + secondNumber;
	}
}
