package day11;

import java.util.ArrayList;
import java.util.List;

import inputReader.InputReader;

public class DayElevenFirst {
	public static void main(String[] args) {
		String[] inputOfTheDay = InputReader.read("src/day11/day11.txt", "");
		System.out.println("There are " + takeSeats(inputOfTheDay) + " occupied seats.");
	}

	private static int takeSeats(String[] inputOfTheDay) {
		List<String> changedLines = new ArrayList<>();
		int occupiedSeats;
		int changes;
		String[] changesAndNewLine = new String[2];
		do {
			changes = 0;
			occupiedSeats = 0;
			for (int line = 0; line < inputOfTheDay.length; line++) {
				changesAndNewLine = (lineByLine(inputOfTheDay[line], line, inputOfTheDay));
				changedLines.add(changesAndNewLine[1]);
				changes += Integer.parseInt(changesAndNewLine[0]);
			}
			overWriteInputWithNewLines(inputOfTheDay,changedLines);
			changedLines.clear();
			
			if (changes == 0) {
				occupiedSeats = countOccupiedSeats(0, 0, inputOfTheDay, true);
			}
		} while (changes != 0);
		return occupiedSeats;
	}

	private static void overWriteInputWithNewLines(String[] inputOfTheDay, List<String> changedLines) {
		for (int i = 0; i < inputOfTheDay.length; i++) {
			inputOfTheDay[i] = changedLines.get(i);
		}
	}

	private static String[] lineByLine(String line, int lineIdx, String[] inputOfTheDay) {
		int occupiedSeats = 0;
		Integer changes = 0;
		String[] datas = new String[2];
		StringBuilder newLine = new StringBuilder();
		for (int idx = 0; idx < line.length(); idx++) {
			occupiedSeats = countOccupiedSeats(idx, lineIdx, inputOfTheDay, false);
			char temp = seatChanger(line.charAt(idx), occupiedSeats);
			if (temp != line.charAt(idx))
				changes++;
			newLine.append(temp);
		}
		datas[0] = changes.toString();
		datas[1] = newLine.toString();

		return datas;
	}

	private static char seatChanger(char character, int occupiedSeats) {
		if (occupiedSeats == 0 && character == 'L') {
			return '#';
		} else if (occupiedSeats > 3 && character == '#') {
			return 'L';
		}
		return character;
	}

	private static int countOccupiedSeats(int idx, int lineIdx, String[] inputOfTheDay, boolean isEnd) {
		int occupiedSeats = 0;
		int iFrom = lineIdx == 0 ? lineIdx : lineIdx - 1;
		int iTo = lineIdx == inputOfTheDay.length - 1 ? lineIdx : lineIdx + 1;
		int jFrom = idx == 0 ? idx : idx - 1;
		int jTo = idx == inputOfTheDay[lineIdx].length() - 1 ? idx : idx + 1;
		if (isEnd) {
			iFrom = 0;
			iTo = inputOfTheDay.length - 1;
			jFrom = 0;
			jTo = inputOfTheDay[lineIdx].length() - 1;
		}
		if (!isEnd && inputOfTheDay[lineIdx].charAt(idx) == '#') {
			occupiedSeats--;
		}
		for (int i = iFrom; i <= iTo; i++) {
			for (int j = jFrom; j <= jTo; j++) {
				if (inputOfTheDay[i].charAt(j) == '#') {
					occupiedSeats++;
				}
			}
		}
		return occupiedSeats;
	}
}