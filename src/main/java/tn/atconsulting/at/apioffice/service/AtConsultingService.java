package tn.atconsulting.at.apioffice.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import tn.atconsulting.at.apioffice.domain.dto.ConnectionDTO;

//import tn.atconsulting.at.apioffice.domain.dto.CustomerDTO;

@Service
public class AtConsultingService {
	
	@SuppressWarnings("deprecation")
	public ResponseEntity<String> nodeRoot(ConnectionDTO connectionDTO) {
	    try {
	    	HttpURLConnection con = null;
	        String url_str = "https://graph.microsoft.com/v1.0/me/drive/items/" + connectionDTO.getIdFolder()  + "/children";

	        URL url = new URL(url_str);
	        con = ( HttpURLConnection )url.openConnection();
	        con.setDoInput(true);
	        con.setDoOutput(true);
	        con.setUseCaches(false);
	        con.setRequestMethod("GET");
	        con.setRequestProperty("Authorization","Bearer " + connectionDTO.getBearer_token());
	        System.out.println("Token : " + connectionDTO.getBearer_token());
	        con.setRequestProperty("Accept","application/json"); // I added this line.
	        con.connect();

	        BufferedReader br = new BufferedReader(new InputStreamReader( con.getInputStream() ));
	        String str = "";
	        String line;
	        while((line = br.readLine()) != null){
	            str += line;
	        }
	        System.out.println("Aminos : " + str);
	        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(str); 
	    } catch (Exception e) {
	    	System.out.println("ERROR : "+e.toString());

	    }		
	    return ResponseEntity.ok().body("NOK"); 
	}

	
	@SuppressWarnings("deprecation")
	public ResponseEntity<String> getClients(ConnectionDTO connectionDTO) {
	    try {
	    	HttpURLConnection con = null;
	        String url_str = // "https://graph.microsoft.com/v1.0/me";
	        		//"https://graph.microsoft.com/v1.0/me/messages";
	        "https://graph.microsoft.com/v1.0/me/drive/root/children";
	        //String bearer_token = "EwBwA8l6BAAU6k7+XVQzkGyMv7VHB/h4cHbJYRAAAd7QteOqSFxxfTNKBPWJYdWMhC6WwAfiSB6C0QOW6fepTqtqMiSleUDVNzlhzL/ysmbQ2tLKyj+/LuFQPvIIbicuAXYs6fZcKzIXoFF0bMJZakwkxDl6p6JS6Q8+wvU1UCivAinjfS06LUySiFQF1WZ5XGPyoBlxnTWvKtO9pRvUFKO7gCyU4nBwUIHAMEHmFyekmJfR+vSBhoEznDDPyQAcPZoi3JcuZZGzvrQm5tzJgwhd+712izNQHaURobFipXpW7CLLtt1n/0g+RvnhUH6lz8TlovYz0UsedeMdi56P07jLieEr4CPyTjSIfmOlf/af4C4sfiirYymB4jHgbQwDZgAACH6iIfII5I5tQAK8fkezXE/3YlInAsNZYbn+fqnxIF8S5uihjJuXCLgI6i0W3gQtId/Y8hz978Ev9KtGH8udOM4nIFu3W2WpXCNEfX88zpIkQxukJbvifiaQ2VPqVOLCnsAXip1bgJV3Zl6lZy6HBMISqCmSTIRY3c282drexUfnGWfuxTU3L1lhLSAJz2cyBu2JnsQ3JdoQj3GQHTj7TRgNep8qhRJvw3d2kYtXi0yFKIMfkx43gTwwm6lzTG5ywnkI7BcUzAVC970sGUQ2OKyGGB6o9PP6L/W4J3jEmJWqtGWtT1vDE2zCIpa9sYYmRYaUcHWMhngYg7KaaE+W3xs08C4dnLTniX7zzSTMMYJTNsjTCEgqj2iGzPwXbtmPDtRfK0aE72S3lvSfIP7w01bl4IsGIv1U3opqE8tAuus+wAeUMnJ6geEo9UzbZjamXCXpfuOfQv8xWcJUigF2b0woqXoh+/PUlcSKZw1uRfk+HwbEuzevwPP5oYn15qOUce5e1+HksI/abQS8O2kelTnHUnsMsqiBRv6piyD9Xt6FyViQo13TTdBTePLHVobOD/1bDX6xcTzhs+9xNyXGYosVe7O6EAExedAmEYy0d09+sEM8cxPldnjO+qTa0pfMQwENIKZnIJVma1mMVI9R6/dp4ZB4m+7C5cf63RF6RcI1jUJYWXySe/y0lvfCrytoLHatJHDZVbMQh9sulJNSWbS/p4RDILSBX5UjasNIxlwJ6ir7CGLctdInFatPpXi2PCyUytBABquMnl6GAg==";

	        URL url = new URL(url_str);
	        con = ( HttpURLConnection )url.openConnection();
	        con.setDoInput(true);
	        con.setDoOutput(true);
	        con.setUseCaches(false);
	        con.setRequestMethod("GET");
	        con.setRequestProperty("Authorization","Bearer " + connectionDTO.getBearer_token());
	        System.out.println("Token : " + connectionDTO.getBearer_token());
	        con.setRequestProperty("Accept","application/json"); // I added this line.
	        con.connect();

	        BufferedReader br = new BufferedReader(new InputStreamReader( con.getInputStream() ));
	        String str = "";
	        String line;
	        while((line = br.readLine()) != null){
	            str += line;
	        }
	        System.out.println("Aminos : " + str);
	        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(str); 
	    } catch (Exception e) {
	    	System.out.println("ERROR : "+e.toString());

	    }
		

		
	    return ResponseEntity.ok().body("NOK"); 
		 
	}

}
