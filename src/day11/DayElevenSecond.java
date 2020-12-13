package day11;

import java.util.ArrayList;
import java.util.List;

import inputReader.InputReader;

public class DayElevenSecond extends DayElevenFirst {
	public static void main(String[] args) {
		String[] inputOfTheDay = InputReader.read("src/day11/day11.txt", "");
		System.out.println("There are " + takeSeats(inputOfTheDay) + " occupied seats.");
	}

	public static int takeSeats(String[] inputOfTheDay) {
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
			overWriteInputWithNewLines(inputOfTheDay, changedLines);
			changedLines.clear();

			if (changes == 0) {
				occupiedSeats = countOccupiedSeatsAtEnd(inputOfTheDay);
			}
		} while (changes != 0);
		return occupiedSeats;
	}

	private static int countOccupiedSeatsAtEnd(String[] inputOfTheDay) {
		int counter = 0;
		for (int i = 0; i < inputOfTheDay.length; i++) {
			for (int j = 0; j < inputOfTheDay[i].length(); j++) {
				if (inputOfTheDay[i].charAt(j) == '#') {
					counter++;
				}
			}
		}
		return counter;
	}

	private static void printSeats(String[] inputOfTheDay) {
		for (int i = 0; i < inputOfTheDay.length; i++) {
			System.out.println(inputOfTheDay[i]);
		}
		System.out.println();
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
			occupiedSeats = countOccupiedSeats(idx, lineIdx, inputOfTheDay);
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
		} else if (occupiedSeats > 4 && character == '#') {
			return 'L';
		}
		return character;
	}

	private static int countOccupiedSeats(int idx, int lineIdx, String[] inputOfTheDay) {
		int occupiedSeats = 0;
		occupiedSeats += checkSeatsHorizontally(idx, lineIdx, inputOfTheDay);
		occupiedSeats += checkSeatsVertically(idx, lineIdx, inputOfTheDay);
		occupiedSeats += checkSeatsDiagonally(idx, lineIdx, inputOfTheDay);
		return occupiedSeats;
	}

	private static int checkSeatsDiagonally(int idx, int lineIdx, String[] inputOfTheDay) {
		int seeableSeats = 0;
		boolean canStop = false;
		int row = 0;
		int col = 0;
		if (lineIdx < inputOfTheDay.length - 1 && idx > 0) {
			row = lineIdx + 1;
			col = idx - 1;
			canStop = false;
			while ((row < inputOfTheDay.length && col > -1) && !canStop) {
				if (inputOfTheDay[row].charAt(col) == 'L') {
					canStop = true;
				}
				if (inputOfTheDay[row].charAt(col) == '#') {
					seeableSeats++;
					canStop = true;
				}
				row++;
				col--;
			}
		}
		
		if (lineIdx < inputOfTheDay.length - 1 && idx < inputOfTheDay[lineIdx].length() - 1) {
			row = lineIdx+1 ;
			col = idx + 1;
			canStop = false;
			while (row < inputOfTheDay.length && col < inputOfTheDay[lineIdx].length() && !canStop) {
				if (inputOfTheDay[row].charAt(col) == 'L') {
					canStop = true;
				}
				if (inputOfTheDay[row].charAt(col) == '#') {
					seeableSeats++;
					canStop = true;
				}
				row++;
				col++;
			}
		}
		
		if (lineIdx > 0 && idx < inputOfTheDay[lineIdx].length() - 1) {
			row = lineIdx - 1;
			col = idx + 1;
			canStop = false;
			while (row >= 0 && col < inputOfTheDay[lineIdx].length() && !canStop) {
				if (inputOfTheDay[row].charAt(col) == 'L') {
					canStop = true;
				}
				if (inputOfTheDay[row].charAt(col) == '#') {
					seeableSeats++;
					canStop = true;
				}
				row--;
				col++;
			}
		}
		
		if (lineIdx > 0 && idx > 0) {
			row = lineIdx - 1;
			col = idx - 1;
			canStop = false;
			while (row > -1 && col > -1 && !canStop) {
				if (inputOfTheDay[row].charAt(col) == '#') {
					seeableSeats++;
					canStop = true;
				}
				if (inputOfTheDay[row].charAt(col) == 'L') {
					canStop = true;
				}
				
				row--;
				col--;
			}
		}
		return seeableSeats;
	}

	private static int checkSeatsVertically(int idx, int lineIdx, String[] inputOfTheDay) {
		int seeableSeats = 0;
		boolean canStop = false;
		int index = 0;
		if (lineIdx < inputOfTheDay.length - 1) {
			index = lineIdx + 1;
			while (index < inputOfTheDay.length && !canStop) {
				if (inputOfTheDay[index].charAt(idx) == 'L') {
					canStop = true;
				}
				if (inputOfTheDay[index].charAt(idx) == '#') {
					seeableSeats++;
					canStop = true;
				}
				index++;
			}
		}
		if (lineIdx >= 1) {
			index = lineIdx - 1;
			canStop = false;
			while (index >= 0 && !canStop) {
				if (inputOfTheDay[index].charAt(idx) == 'L') {
					canStop = true;
				}
				if (inputOfTheDay[index].charAt(idx) == '#') {
					seeableSeats++;
					canStop = true;
				}
				index--;
			}
		}
		return seeableSeats;
	}

	private static int checkSeatsHorizontally(int idx, int lineIdx, String[] inputOfTheDay) {
		int seeableSeats = 0;
		boolean canStop = false;
		int index = 0;
		if (idx <= inputOfTheDay[lineIdx].length() - 1) {
			index = idx + 1;
			while (index < inputOfTheDay[lineIdx].length() && !canStop) {
				if (inputOfTheDay[lineIdx].charAt(index) == 'L') {
					canStop = true;
				}
				if (inputOfTheDay[lineIdx].charAt(index) == '#') {
					seeableSeats++;
					canStop = true;
				}
				index++;
			}
		}
		if (idx >= 1) {
			index = idx - 1;
			canStop = false;
			while (index >= 0 && !canStop) {
				if (inputOfTheDay[lineIdx].charAt(index) == 'L') {
					canStop = true;
				}
				if (inputOfTheDay[lineIdx].charAt(index) == '#') {
					seeableSeats++;
					canStop = true;
				}
				index--;
			}
		}
		return seeableSeats;
	}
}