package inputReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class InputReader {

	public static String[] read(String fileName, String separator) {

		String[] inputOfTheDay = null;
		int sumOfTheLines = 0;

		try (BufferedReader br = new BufferedReader(new FileReader(fileName, StandardCharsets.UTF_8))) {
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line);
				sumOfTheLines++;
				sb.append(System.lineSeparator());
			}
			if (!"".equals(separator)) {
				inputOfTheDay = sb.toString().split(separator);
			} else {
				inputOfTheDay = sb.toString().split(System.lineSeparator());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return inputOfTheDay;
	}
}
