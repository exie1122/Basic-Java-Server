import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.net.HttpURLConnection; 
import java.net.URL; 
import java.nio.file.Files; 
import java.nio.file.Path; 

public class WebServerConnection { 
 
	public static void main(String[] args) 
	{ 
		try { 
			//REPLACE WITH DESIRED URL
			String url = "https://www.example.com"; 


			URL serverUrl = new URL(url); 

//init connection
			HttpURLConnection connection 
				= (HttpURLConnection) 
					serverUrl.openConnection(); 

			//GET
			connection.setRequestMethod("GET"); 

//HTTP
			int responseCode = connection.getResponseCode(); 
			System.out.println("Response Code: "
							+ responseCode); 

	//exe
			BufferedReader reader 
				= new BufferedReader(new InputStreamReader( 
					connection.getInputStream())); 

			String line; 
			StringBuilder responseContent 
				= new StringBuilder(); 

			while ((line = reader.readLine()) != null) { 
				responseContent.append(line); 
			} 

			reader.close(); 

//FILE NAME
			Path fileName = Path.of("../temp.html"); 

			Files.writeString(fileName, responseContent.toString()); 

			System.out.println( 
				"Response Content:\n"
				+ responseContent.toString()); 
		} 
		catch (IOException e) { 
			e.printStackTrace(); 
		} 
	} 
} 
