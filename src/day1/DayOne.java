package day1;

import inputReader.InputReader;

public class DayOne {

	public static void main(String[] args) {
		String[] inputOfTheDay = InputReader.read("src/day1/day1.txt", "");
		firstHalf(inputOfTheDay);
		secondHalf(inputOfTheDay);
	}

	private static void secondHalf(String[] inputOfTheDay) {
		int[] numbers = new int[3];
		boolean exit = false;
		for (int i = 0; i < inputOfTheDay.length - 2 && !exit; i++) {
			numbers[0] = Integer.parseInt(inputOfTheDay[i]);
			for (int j = i + 1; j < inputOfTheDay.length - 1 && !exit; j++) {
				numbers[1] = Integer.parseInt(inputOfTheDay[j]);
				for (int k = j + 1; k < inputOfTheDay.length && !exit; k++) {
					numbers[2] = Integer.parseInt(inputOfTheDay[k]);
					if (makeSum(numbers) == 2020) {
						System.out.println("Result is for the second half: " + multipleNumbers(numbers));
						exit = true;
					}
				}
			}
		}
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
