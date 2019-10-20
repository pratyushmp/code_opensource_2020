import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

/**
 * This program will copy contents from one file to another. If second file
 * doesn't exist, a file will be created.
 *
 */
public class CopyFile {

	public static void main(String[] args) throws IOException {
		File file1 = new File("C:/Users/prk/Documents/Other/Files/file1.txt");
		File file2 = new File("C:/Users/prk/Documents/Other/Files/file2.txt");
		Files.copy(file1.toPath(), file2.toPath(), StandardCopyOption.REPLACE_EXISTING);
		System.out.println("File Copy complete");
	}
}
