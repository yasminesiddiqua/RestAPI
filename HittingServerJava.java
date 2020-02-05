package sample;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class HittingServerJava {
	// public static int resp;

	// http://localhost:8080/RESTfulExample/json/product/get

	public static void main(String[] args) throws InterruptedException {
		System.out.println(hittingServer());
	}

	public static Map<String, Integer> hittingServer() {
		List<String> links = JsnReader.readJsonFile();
		
		Map<String, Integer> response = new TreeMap<>();;
		int resp = 0;
		System.out.println(links);
		for (String link : links) {
			try {
				URL url = new URL(link);
				// Thread.sleep(2000);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				// Thread.sleep(2000);
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");
				// Thread.sleep(2000);
				
				resp = conn.getResponseCode();
				System.out.println(resp);
		
				if (conn.getResponseCode() != 200) {
					// Thread.sleep(2000);
					throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
					// to write in excel sheet
				}
				
				//conn.disconnect();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			response.put(link, resp);
			resp = 0;
		}
		// return response;
		return response;

	}

}
