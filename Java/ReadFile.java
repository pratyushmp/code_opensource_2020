import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * This program will read a file and print each line
 *
 */
public class ReadFile {

	public static void main(String[] args) throws IOException {
		File file = new File("C:/Users/x88195/Documents/Other/Files/file.txt");

		// Opening resource in a try block to handle File IO exceptions and close stream
		// after operation is complete
		try (BufferedReader in = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = in.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			System.err.println("Exception:" + e);
		}
	}
}
