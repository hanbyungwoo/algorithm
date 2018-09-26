package http;

import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class JsonTest {
    
	public static void main(String[] args) {
        
    	HashMap<String, Object> myHashMap1 = new HashMap<String, Object>();
    	JSONObject jsonObject1 = new JSONObject();
    	JSONArray jsonArray1 = new JSONArray();
    	JSONObject finalJsonObject1 = new JSONObject();
    	
    	myHashMap1.put("ÀÌ¸§", "ÀáÀÚ¸®");
    	myHashMap1.put("´Ù¸®°¹¼ö", "6");

    	jsonObject1 = new JSONObject(myHashMap1);
        jsonArray1.add(jsonObject1);
        
        myHashMap1 = new HashMap<String, Object>();
        myHashMap1.put("ÀÌ¸§", "»ç½¿¹ú·¹");
        myHashMap1.put("´Ù¸®°¹¼ö", "6");

        jsonObject1 = new JSONObject(myHashMap1);
        jsonArray1.add(jsonObject1);
         
        finalJsonObject1.put("°ïÃæ", jsonArray1);
        finalJsonObject1.put("µ¿¹°", "ÄÚ³¢¸®");
        finalJsonObject1.put("½Ä¹°", "¹«±ÃÈ­");
        
        System.out.println(finalJsonObject1);
    }
    
}

class JsonValue {
	int x;
	int y;
	String arr[];
	String str;
	public JsonValue(int x, int y, String[] arr, String str) {
		this.x = x;
		this.y = y;
		this.arr = arr;
		this.str = str;
	}
	@Override
	public String toString() {
		return this.x +", " + this.y + ", " + arr[1] + ", " + str;
	}
}