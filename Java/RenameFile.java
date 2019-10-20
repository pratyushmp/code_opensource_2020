import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

/**
 * This program will rename/replace a file with provided file names.
 *
 */
public class RenameFile {

	public static void main(String[] args) throws IOException {
		File file1 = new File("C:/Users/prk/Documents/Other/Files/file1.txt");
		File file2 = new File("C:/Users/prk/Documents/Other/Files/file2.txt");
		Files.move(file1.toPath(), file2.toPath(), StandardCopyOption.REPLACE_EXISTING);
		System.out.println("File rename complete");
	}
}
