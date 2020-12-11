package day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import inputReader.InputReader;

public class DayTenthSecond {
	private static Map<String, Long> cache;

	public static void main(String[] args) {
		String[] inputOfTheDay = InputReader.read("src/day10/day10.txt", "");

		List<Integer> adapters = makeListFromLines(inputOfTheDay);

		cache = new HashMap<>();

		long arrangements = findArrangements(adapters);

		System.out.println("Answer is: " + arrangements);

	}

	private static List<Integer> makeListFromLines(String[] inputOfTheDay) {
		List<Integer> adapters = new ArrayList<Integer>();
		for (int i = 0; i < inputOfTheDay.length; i++) {
			adapters.add(Integer.parseInt(inputOfTheDay[i]));
		}
		adapters.sort(Integer::compareTo);
		adapters.add(0, 0);
		adapters.add(adapters.get(adapters.size() - 1) + 3);

		return adapters;
	}

	private static long findArrangements(List<Integer> adapters) {

		if (adapters.size() == 1) {
			return 1L;
		}
		long arrangements = 0;
		int index = 1;
		int current = adapters.get(0);

		while (adapters.size() > index && adapters.get(index) - current < 4) {

			List<Integer> subList = adapters.subList(index, adapters.size());
			String subListStr = Arrays.toString(subList.toArray(new Integer[0]));

			if (cache.containsKey(subListStr)) {
				arrangements += cache.get(subListStr);
			} else {
				long subArrangements = findArrangements(subList);
				cache.put(subListStr, subArrangements);
				arrangements += subArrangements;
			}
			index++;
		}
		return arrangements;
	}
}