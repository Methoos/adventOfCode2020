package day6;

import java.util.ArrayList;
import java.util.List;

import inputReader.InputReader;

public class DaySixthFirst {
	public static void main(String[] args) {
		String[] inputOfTheDay = InputReader.read("src/day6/day6.txt", "");
		List<String> list = new ArrayList<String>();
		int counter = 0;
		for (int i = 0; i < inputOfTheDay.length; i++) {
			if ((!"".equals(inputOfTheDay[i]))) {
				String memberOfGroup = inputOfTheDay[i];
				for (int j = 0; j < memberOfGroup.length(); j++) {
					if (!list.contains(memberOfGroup.substring(j, j + 1))) {
						list.add(memberOfGroup.substring(j, j + 1));
					}
				}
			} else {
				counter += list.size();
				list.clear();
			}
		}
		counter += list.size();
		System.out.println("There were " + counter + " \"yes\" answers.");
	}
}
