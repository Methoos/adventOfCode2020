package day7;

import java.util.ArrayList;
import java.util.List;
import inputReader.InputReader;

public class DaySeventhSecond {
	public static void main(String[] args) {
		String[] inputOfTheDay = InputReader.read("src/day7/day7.txt", "");
		String searchedBag = "  shiny gold";
		int sumOfBags = containedBagsSearch(inputOfTheDay, searchedBag, 0, 1);
		System.out.println(sumOfBags + " bags are required inside the \"" + searchedBag.trim() + "\" bag.");
	}

	private static int containedBagsSearch(String[] inputOfTheDay, String searchedBag, int sumOfBags,
			int sumOfPreviousBags) {
		for (int line = 0; line < inputOfTheDay.length; line++) {
			if (inputOfTheDay[line].startsWith(searchedBag.substring(2))) {
				List<String> containedBags = createBagsFromLine(inputOfTheDay[line]);
				for (int bag = 0; bag < containedBags.size(); bag++) {
					String newBag = containedBags.get(bag);
					if (!newBag.startsWith("n")) {
						int numberOfOneBag = Integer.parseInt(containedBags.get(bag).substring(0, 1));
						int allBagsInOneBag = sumOfPreviousBags * numberOfOneBag;
						sumOfBags += allBagsInOneBag;
						sumOfBags = containedBagsSearch(inputOfTheDay, newBag, sumOfBags, allBagsInOneBag);
					}
				}
			}
		}
		return sumOfBags;
	}

	private static List<String> createBagsFromLine(String line) {
		List<String> containedBags = new ArrayList<>();
		String containedRawBags = line.split("bags contain ")[1];
		String[] rawBags = null;
		if (containedRawBags.contains(" bag")) {
			rawBags = containedRawBags.split(" bag");
		}
		for (int i = 0; i < rawBags.length; i++) {
			if (rawBags[i].startsWith(", ")) {
				rawBags[i] = rawBags[i].replace(", ", "");
			}
			if (rawBags[i].startsWith("s, ")) {
				rawBags[i] = rawBags[i].replace("s, ", "");
			}
			if (rawBags[i].length() > 3) {
				containedBags.add(rawBags[i]);
			}
		}
		return containedBags;
	}
}