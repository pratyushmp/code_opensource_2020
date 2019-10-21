import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * This program will create a .zip file from an existing file
 *
 */
public class FileToZip {

	public static void main(String[] args) {
		FileInputStream is = null;
		FileOutputStream os = null;
		ZipOutputStream zs = null;

		try {
			File file = new File("C:/Users/x88195/Documents/Other/Files/file.txt");
			File zipFile = new File("C:/Users/x88195/Documents/Other/Files/file.zip");

			os = new FileOutputStream(zipFile);
			zs = new ZipOutputStream(os);
			is = new FileInputStream(file);

			ZipEntry zipEntry = new ZipEntry(file.getName());
			zs.putNextEntry(zipEntry);

			byte[] bytes = new byte[1024];
			int length;
			while ((length = is.read(bytes)) >= 0) {
				zs.write(bytes, 0, length);
			}
		} catch (IOException e) {
			System.err.println("IOException:" + e);
		} finally {
			close(is, os, zs);
		}
		System.out.println("Zip File creation complete");
	}

	private static void close(FileInputStream inputStream, FileOutputStream outputStream, ZipOutputStream zipStream) {
		try {
			if (null != inputStream) {
				inputStream.close();
			}

			if (null != zipStream) {
				zipStream.close();
			}

			if (null != outputStream) {
				outputStream.close();
			}
		} catch (IOException e) {
			System.err.println("IOException:" + e);
		}
	}
}
