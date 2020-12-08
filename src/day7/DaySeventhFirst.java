package day7;

import java.util.ArrayList;
import java.util.List;

import inputReader.InputReader;

public class DaySeventhFirst {
	public static void main(String[] args) {
		String[] inputOfTheDay = InputReader.read("src/day7/day7.txt", "");
		String searchedBag = "shiny gold";
		List<String> shinyGoldBagContainers = bagContainersSearch(inputOfTheDay, searchedBag);
		int previousSize = shinyGoldBagContainers.size();
		boolean isAllFound = false;
		while (!isAllFound) {
			searchForAllContainers(inputOfTheDay, shinyGoldBagContainers);
			isAllFound = previousSize == shinyGoldBagContainers.size() ? true : false;
			previousSize = shinyGoldBagContainers.size();
		}
		System.out.println(shinyGoldBagContainers.size() + " colors can contain " + searchedBag + " bags.");
	}

	private static void searchForAllContainers(String[] inputOfTheDay, List<String> shinyGoldBagContainers) {
		for (int line = 0; line < inputOfTheDay.length; line++) {
			for (int bag = 0; bag < shinyGoldBagContainers.size(); bag++) {
				if (isBagContained(inputOfTheDay[line], shinyGoldBagContainers.get(bag))) {
					String bagCanContain = splitString(inputOfTheDay[line]);
					if (!shinyGoldBagContainers.contains(bagCanContain)) {
						shinyGoldBagContainers.add(bagCanContain);
					}
				}
			}
		}
	}

	private static List<String> bagContainersSearch(String[] inputOfTheDay, String bag) {
		List<String> bagContainers = new ArrayList<String>();
		for (int line = 0; line < inputOfTheDay.length; line++) {
			if (isBagContained(inputOfTheDay[line], bag)) {
				bagContainers.add(splitString(inputOfTheDay[line]));
			}
		}
		return bagContainers;
	}

	private static String splitString(String line) {
		return line.split(" bags contain")[0];
	}

	private static boolean isBagContained(String line, String bag) {
		if (line.contains(bag) && !line.startsWith(bag)) {
			return true;
		}
		return false;
	}
}