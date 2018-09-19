package http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
//  http://second27.tistory.com/133
public class URLConnectionTest {
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		try {
			//单捞磐 积己.
//			String data = URLEncoder.encode("key1", "UTF-8") + "=" + URLEncoder.encode("value1", "UTF-8");
//			data += "&" + URLEncoder.encode("key2", "UTF-8") + "=" + URLEncoder.encode("全辨悼", "UTF-8");
			
			// send Data
			URL url = new URL("https://swapi.co/api/people/1/");
//			URL url = new URL("http://www.naver.com");
//			URLConnection conn = url.openConnection();
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setDoInput(true);
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setDoOutput(true);
//			con.setRequestProperty("Authorization", header_info2);
//			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
//			conn.setRequestProperty("Accept-Charset", "UTF-8");
			
			conn.connect();
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
//			wr.write(data);
//			wr.flush();
			
			// get Data
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String line;
			while((line = br.readLine())!= null) {
				System.out.println(line);
			}
			wr.close();
			br.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
