package day8;

import java.util.ArrayList;
import java.util.List;

import inputReader.InputReader;

public class DayEighthSecond {
	public static void main(String[] args) {
		String[] inputOfTheDay = InputReader.read("src/day8/day8.txt", "");
		int accumulator = 0;
		int line = 0;
		int nopIdx = -1;
		int jmpIdx = -1;
		boolean isOriginLoopCreated = false;
		boolean jmpSearchCanStart = false;
		boolean nopSearchCanStart = false;
		List<Integer> originLoop = new ArrayList<>();
		List<Integer> currentLoop = new ArrayList<>();
		List<Integer> nopsList = new ArrayList<>();
		List<Integer> jmpsList = new ArrayList<>();
		
		while (line < inputOfTheDay.length) {
			if (isLoopAndLineToCurrentLoop(line, currentLoop)) {
				if (!isOriginLoopCreated) {
					originLoop = currentLoop;
					isOriginLoopCreated = true;
					findNopsAndJmpsInOriginLoop(originLoop, nopsList, jmpsList, inputOfTheDay);
					accumulator = 0;
					line = resetCurrentLoop(currentLoop);
				} else {
					accumulator = 0;
					line = resetCurrentLoop(currentLoop);
					if (checkListSize(nopsList, nopIdx)) {
						nopSearchCanStart = true;
						nopIdx++;
					} else {
						nopSearchCanStart = false;
						if (checkListSize(jmpsList, jmpIdx)) {
							jmpSearchCanStart = true;
							jmpIdx++;
						}
					}
				}
			}
			switch (makeInstruction(inputOfTheDay[line])) {
			case "nop":
				line = nopSearch(nopSearchCanStart, nopsList, nopIdx, line, inputOfTheDay);
				break;
			case "acc":
				accumulator = changeValue(inputOfTheDay[line], accumulator);
				line = nextLine(line, 1);
				break;
			case "jmp":
				line = jmpSearch(jmpSearchCanStart, jmpsList, jmpIdx, line, inputOfTheDay);
				break;
			}
		 }
		System.out.println("The value of accumulator is " + accumulator + ".");
	}
	
	private static boolean checkListSize(List<Integer> list, int idx) {
		return (list.size() - 1) > idx;
	}

	private static int resetCurrentLoop(List<Integer> currentLoop) {
		currentLoop.clear();
		isLoopAndLineToCurrentLoop(0, currentLoop);
		return 0;
	}

	private static void findNopsAndJmpsInOriginLoop(List<Integer> originLoop, List<Integer> nopsList,
			List<Integer> jmpsList, String[] inputOfTheDay) {
		for (int index = 0; index < originLoop.size(); index++) {
			findNops(originLoop, nopsList, inputOfTheDay, index);
			findJmps(originLoop, jmpsList, inputOfTheDay, index);
		}
	}

	private static void findJmps(List<Integer> originLoop, List<Integer> jmpsList, String[] inputOfTheDay, int index) {
		if (makeInstruction(inputOfTheDay[originLoop.get(index)]).equals("jmp")
				&& makeInteger(inputOfTheDay[originLoop.get(index)]) != 0) {
			jmpsList.add(originLoop.get(index));
		}
	}

	private static void findNops(List<Integer> originLoop, List<Integer> nopsList, String[] inputOfTheDay, int index) {
		if (makeInstruction(inputOfTheDay[originLoop.get(index)]).equals("nop")
				&& makeInteger(inputOfTheDay[originLoop.get(index)]) != 0) {
			nopsList.add(originLoop.get(index));
		}
	}

	private static int jmpSearch(boolean jmpSearchStarted, List<Integer> jmpsInOriginLoop, int jmpIdx, int line,
			String[] inputOfTheDay) {
		if (jmpSearchStarted && line == jmpsInOriginLoop.get(jmpIdx)) {
			return nextLine(line, 1);
		} else {
			return nextLine(line, makeInteger(inputOfTheDay[line]));
		}
	}

	private static int nopSearch(boolean nopSearchStarted, List<Integer> nopsInOriginLoop, int nopIdx, int line,
			String[] inputOfTheDay) {
		if (nopSearchStarted && line == nopsInOriginLoop.get(nopIdx)) {
			return nextLine(line, makeInteger(inputOfTheDay[line]));
		} else {
			return nextLine(line, 1);
		}
	}

	private static String makeInstruction(String line) {
		return line.substring(0, 3);
	}

	private static boolean isLoopAndLineToCurrentLoop(int line, List<Integer> linesOfLoop) {
		if (linesOfLoop.contains(line)) {
			return true;
		} else {
			linesOfLoop.add(line);
			return false;
		}
	}

	private static int changeValue(String line, int number) {
		return number + makeInteger(line);
	}

	private static int makeInteger(String line) {
		return Integer.parseInt(line.substring(4, line.length()));
	}

	private static int nextLine(int line, int step) {
		return line + step;
	}
}