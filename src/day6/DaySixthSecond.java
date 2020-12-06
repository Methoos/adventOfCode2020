package day6;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import inputReader.InputReader;

public class DaySixthSecond {
	public static void main(String[] args) {
		String[] inputOfTheDay = InputReader.read("src/day6/day6.txt", "");
		List<String> list = new ArrayList<String>();
		int counter = 0;
		boolean isFirstMemberInGroup = true;
		for (int i = 0; i < inputOfTheDay.length; i++) {
			if ((!"".equals(inputOfTheDay[i]))) {
				String memberOfGroup = inputOfTheDay[i];
				ListIterator<String> it = list.listIterator();
				if (!isFirstMemberInGroup) {
					while (it.hasNext()) {
						String target = it.next();
						if (!memberOfGroup.contains(target)) {
							it.remove();
						}
					}
				} else {
					for (int j = 0; j < memberOfGroup.length(); j++) {
						list.add(memberOfGroup.substring(j, j + 1));
					}
					isFirstMemberInGroup = false;
				}
			} else {
				counter += list.size();
				list.clear();
				isFirstMemberInGroup = true;
			}
		}
		counter += list.size();
		System.out.println("The result is: " + counter);
	}
}