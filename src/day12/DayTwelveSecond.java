package day12;

import inputReader.InputReader;

public class DayTwelveSecond {
	public static final String[] WIND_ROSE = { "N", "E", "S", "W" };
	public static int[] waypontCoordinates= {1,10};

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
		int[] distance = {0,0};
		String direction = createDirectionFromLine(instruction);
		int unit=createUnit(instruction);
		
		switch (direction) {
		case "F": distance= movingShipToWaypont(unit); break;
		case "N": waypontCoordinates[0] += unit; break;
		case "E": waypontCoordinates[1] += unit; break;
		case "S": waypontCoordinates[0] -= unit; break;
		case "W": waypontCoordinates[1] -= unit; break;
		default: rotateWaypontAroundShip(instruction); break;
		}
		return distance;
	}

	private static int[] movingShipToWaypont(int unit) {
		int[] distance= new int[2];
		distance[0]=waypontCoordinates[0]*unit; distance[1]=waypontCoordinates[1]*unit;
		return distance;
	}

	private static String createDirectionFromLine(String instruction) {
		return instruction.substring(0, 1);
	}

	private static void rotateWaypontAroundShip(String instruction) {
		int degrees = createUnit(instruction);
		String direction = createDirectionFromLine(instruction);
		int temp=0; 
		if ((direction.equals("L") && degrees == 90) || (direction.equals("R") && degrees == 270)) {
			temp=waypontCoordinates[1];
			waypontCoordinates[1]= waypontCoordinates[0]*-1;
			waypontCoordinates[0]=temp;
			
		} else if ((direction.equals("R") && degrees == 90) || (direction.equals("L") && degrees == 270)) {
			temp=waypontCoordinates[1];
			waypontCoordinates[1]= waypontCoordinates[0];
			waypontCoordinates[0]=temp*-1;
		} else {
			waypontCoordinates[0]*=-1; waypontCoordinates[1]*=-1;
		}
	}

	private static int createUnit(String instruction) {
		return Integer.parseInt(instruction.substring(1));
	}
}