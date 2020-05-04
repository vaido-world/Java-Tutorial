import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.net.URL;

class Main {

	public static void downloadFile(URL url, String fileName) throws IOException {
		try (InputStream in = url.openStream();
				BufferedInputStream bis = new BufferedInputStream(in);
				FileOutputStream fos = new FileOutputStream(fileName)) {

			byte data[] = new byte[1024];
			int count;
			while ((count = bis.read(data, 0, 1024)) != -1) {
				fos.write(data, 0, count);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		downloadFile(new URL("http://vaido.world/index.html"), "vaido.world.html");
	}
}
