
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MetodoGET {

	public static void main(String[] args) {
		try {
			URL url = new URL("http://maps.googleapis.com/maps/api/geocode/json?address=Cochabamba");
			HttpURLConnection conexionHTTP;

			conexionHTTP = (HttpURLConnection) url.openConnection();
			conexionHTTP.setRequestMethod("GET");

			System.out.print("Respuesta del Servidor :");
			BufferedReader in = new BufferedReader(new InputStreamReader(conexionHTTP.getInputStream()));
			String response;
			while ((response = in.readLine()) != null) {
				System.out.println(response);
			}
			in.close();
		} catch (IOException ex) {
			System.out.println("Error" + ex.getMessage());
		}
	}

}
