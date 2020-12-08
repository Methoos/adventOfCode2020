package day8;

import java.util.ArrayList;
import java.util.List;

import inputReader.InputReader;

public class DayEighthFirst {
	public static void main(String[] args) {
		String[] inputOfTheDay = InputReader.read("src/day8/day8.txt", "");
		List<Integer> linesOfLoop = new ArrayList<>();
		int accumulator = 0;
		int line = 0;
		boolean loop = true;
		while (loop) {
			if (isLoop(line, linesOfLoop)) {
				System.out.println("Accumulator is at " + accumulator + " before the second start.");
				loop = false;
			}
			switch (makeInstruction(inputOfTheDay[line])) {
			case "nop":
				line = nextLine(line, 1);
				break;
			case "acc":
				accumulator = changeValue(inputOfTheDay[line], accumulator);
				line = nextLine(line, 1);
				break;
			case "jmp":
				line = nextLine(line, makeInteger(inputOfTheDay[line]));
				break;
			}
		}
	}

	private static int nextLine(int line, int step) {
		return line + step;
	}

	private static boolean isLoop(int line, List<Integer> linesOfLoop) {
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

	private static String makeInstruction(String line) {
		return line.substring(0, 3);
	}

	private static int makeInteger(String line) {
		return Integer.parseInt(line.substring(4, line.length()));
	}
}