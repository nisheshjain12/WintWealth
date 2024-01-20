import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ContentStreaming {

    public static void main(String[] args) {
        try {
            URL url = new URL("https://dfmye9ryu8rat.cloudfront.net/orionCipherFlow.txt");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = connection.getInputStream();
            
            FileOutputStream fileOutputStream = new FileOutputStream("content.txt"); // Assuming ROM storage as a file
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }
            
            fileOutputStream.close();
            inputStream.close();
            System.out.println("Content downloaded and stored in ROM successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
