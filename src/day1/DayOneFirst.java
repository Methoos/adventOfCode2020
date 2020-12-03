package day1;

import inputReader.InputReader;

public class DayOneFirst {

	public static void main(String[] args) {
		String[] inputOfTheDay = InputReader.read("src/day1/day1.txt", "");
		firstHalf(inputOfTheDay);
	}

	private static void firstHalf(String[] inputOfTheDay) {
		int[] numbers = new int[2];
		boolean exit = false;
		for (int i = 0; i < inputOfTheDay.length - 1 && !exit; i++) {
			numbers[0] = Integer.parseInt(inputOfTheDay[i]);
			for (int j = i + 1; j < inputOfTheDay.length && !exit; j++) {
				numbers[1] = Integer.parseInt(inputOfTheDay[j]);
				if (makeSum(numbers) == 2020) {
					System.out.println("Result is for the first half: " + multipleNumbers(numbers));
					exit = true;
				}
			}
		}
	}

	private static long multipleNumbers(int[] numbers) {
		long sum = 1L;
		for (int i = 0; i < numbers.length; i++) {
			sum *= numbers[i];
		}
		return sum;
	}

	private static int makeSum(int[] summarizableNumbers) {
		int sum = 0;
		for (int i = 0; i < summarizableNumbers.length; i++) {
			sum += summarizableNumbers[i];
		}
		return sum;
	}
}
