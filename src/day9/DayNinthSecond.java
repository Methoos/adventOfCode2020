package day9;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import inputReader.InputReader;

public class DayNinthSecond {
	public static void main(String[] args) {
		String[] inputOfTheDay = InputReader.read("src/day9/day9.txt", "");
		final int preamble = 25;
//		String[] inputOfTheDay = InputReader.read("src/day9/example.txt", "");
//		final int preamble = 5;
		System.out.println("The weakness of the encrypted list is: " + encryptXMAS(inputOfTheDay, preamble));
	}

	private static long encryptXMAS(String[] inputOfTheDay, int preamble) {
		List<Long> numberList =DayNinthFirst.createLongFromLines(inputOfTheDay);
		long invalidNumb = DayNinthFirst.searchForInvalidNumber(numberList, preamble);
		//System.out.println(invalidNumb + " is the invalid number.");
		Set<Long> contegousNumbs = findConteousNumsAsSum(invalidNumb, numberList);
		Long[] contegousNumbsAsArray = contegousNumbs.toArray(new Long[contegousNumbs.size()]);
		
		return contegousNumbsAsArray[0] + contegousNumbsAsArray[contegousNumbsAsArray.length - 1];
	}

	private static Set<Long> findConteousNumsAsSum(long invalidNumb, List<Long> numberList) {
		Set<Long> contegousNumbs = new TreeSet<>();
		int startIdx = 0;
		int index = 0;
		long sumOfNumbers = 0;

		while (index < numberList.size()) {
			sumOfNumbers += numberList.get(index);
			contegousNumbs.add(numberList.get(index));
			if (sumOfNumbers == invalidNumb) {
				return contegousNumbs;
			}
			if (sumOfNumbers > invalidNumb) {
				contegousNumbs.clear();
				sumOfNumbers = 0;
				index = ++startIdx-1;
			}
			index++;
		}
		return contegousNumbs;
	}
}