import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LeerPágina {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://httpbin.org/html");
			HttpURLConnection conexionHTTP;
			conexionHTTP = (HttpURLConnection) url.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(conexionHTTP.getInputStream()));

			String respuestaLinea;
			while ((respuestaLinea = in.readLine()) != null) {
				System.out.println(respuestaLinea);
			}

			int responseCode = conexionHTTP.getResponseCode();
			String responseMessage = conexionHTTP.getResponseMessage();
			System.out.println(responseCode + ": " + responseMessage);
		} catch (IOException ex) {
			System.out.println("Error: " + ex.getMessage());
		}

	}

}
