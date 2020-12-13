package day12;

import inputReader.InputReader;

public class DayTwelveFirst {
	public static final String[] WIND_ROSE = { "N", "E", "S", "W" };
	public static int currentFacing = 1;

	public static void main(String[] args) {
		String[] inputOfTheDay = InputReader.read("src/day12/day12.txt", "");
		System.out.println("Manhattan distance is: " + letsSail(inputOfTheDay));
	}

	private static int letsSail(String[] inputOfTheDay) {
		int[] coordinates = new int[2];
		int[] realtiveDistance = new int[2];
		for (int line = 0; line < inputOfTheDay.length; line++) {
			realtiveDistance = readInstruction(inputOfTheDay[line]);
			coordinates[0] += realtiveDistance[0];
			coordinates[1] += realtiveDistance[1];
		}
		return calcManhattanDistance(coordinates);
	}

	private static int calcManhattanDistance(int[] coordinates) {
		return Math.abs(coordinates[0]) + Math.abs(coordinates[1]);
	}

	private static int[] readInstruction(String instruction) {
		int[] distance = new int[2];
		String direction = createDirectionFromLine(instruction);
		if (direction.equals("F")) direction = WIND_ROSE[currentFacing];
		
		switch (direction) {
		case "N": distance[0] += createIntFromInstruction(instruction); break;
		case "E": distance[1] += createIntFromInstruction(instruction); break;
		case "S": distance[0] -= createIntFromInstruction(instruction); break;
		case "W": distance[1] -= createIntFromInstruction(instruction); break;
		default: changeDirection(instruction); break;
		}
		return distance;
	}

	private static String createDirectionFromLine(String instruction) {
		return instruction.substring(0, 1);
	}

	private static void changeDirection(String instruction) {
		int degrees = createIntFromInstruction(instruction);
		String direction = createDirectionFromLine(instruction);
		if ((direction.equals("L") && degrees == 90) || (direction.equals("R") && degrees == 270)) {
			currentFacing = (currentFacing + 3) % WIND_ROSE.length;
		} else if ((direction.equals("R") && degrees == 90) || (direction.equals("L") && degrees == 270)) {
			currentFacing = (currentFacing + 1) % WIND_ROSE.length;
		} else {
			currentFacing = (currentFacing + 2) % WIND_ROSE.length;
		}
	}

	private static int createIntFromInstruction(String instruction) {
		return Integer.parseInt(instruction.substring(1));
	}
}