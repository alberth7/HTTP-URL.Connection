
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class MetodoPOST {

	public static void main(String[] args) {
		try {
			URL url = new URL("http://localhost/script.php");
			HttpURLConnection conexionHTTP;
			conexionHTTP = (HttpURLConnection) url.openConnection();
			conexionHTTP.setDoOutput(true);
			conexionHTTP.setRequestMethod("POST");
			OutputStreamWriter out = new OutputStreamWriter(conexionHTTP.getOutputStream());
			out.write("campo1=contenido1&campo2=contenido2&campo3=contenido3");
			out.close();

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
