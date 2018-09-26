package http;

import java.net.URLDecoder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonTest2 {
	public static void main(String args[]) {
		String str = "{"
				+ "\"name\": \"Luke Skywalker\","
				+ "\"height\": \"172\","
				+ "\"mass\": \"77\","
				+ "\"hair_color\": \"blond\","
				+ "\"skin_color\": \"fair\","
				+ "\"eye_color\": \"blue\","
				+ "\"films\": ["
				+   "\"https://swapi.co/api/films/6/\","
				+ 	"\"https://swapi.co/api/films/2/\","
				+ 	"\"https://swapi.co/api/films/1/\","
				+ 	"\"https://swapi.co/api/films/3/\","
				+ 	"\"https://swapi.co/api/films/7/\","
				+"], "
				+"\"species\": ["
				+"\"https://swapi.co/api/species/1/\""
				+"], "
				+"\"url\": \"https://swapi.co/api/people/1/\","
				+"\"한글\": \"한글도되냐\""
				+ "}";
		
		try {
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(str);
			JSONObject jsonObj = (JSONObject) obj;
			JSONArray info;
			String arggg = (String)jsonObj.get("name");
			String url1 = (String)jsonObj.get("height");
			String url11 = (String)jsonObj.get("한글");
			System.out.println(arggg + " : " + url1 + " : " + url11);
			
			JSONArray infoList= (JSONArray)jsonObj.get("films");
			System.out.println(infoList.size());
			for(int i=0; i<infoList.size(); i++) {
//				JSONObject oo = (JSONObject)infoList.get(i);
//				String web = (String)infoList.get(i);
				String web = URLDecoder.decode((String)infoList.get(i), "utf-8");
				System.out.println(web);
			}
			
			
//			
//			String host = (String)oo.get("Host");
//			System.out.println(host);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
