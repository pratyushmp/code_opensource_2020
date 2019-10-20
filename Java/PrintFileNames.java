import java.io.File;

/**
 * This program will print all files names in a given location
 *
 */
public class PrintFileNames {

	public static void main(String[] args) {
		File folder = new File("C:/Users/prk/Documents/Other/Files");
		File[] files = folder.listFiles();

		for (File file : files) {
			System.out.println("File name: " + file.getName());
		}
	}
}
