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
    	
    	myHashMap1.put("�̸�", "���ڸ�");
    	myHashMap1.put("�ٸ�����", "6");

    	jsonObject1 = new JSONObject(myHashMap1);
        jsonArray1.add(jsonObject1);
        
        myHashMap1 = new HashMap<String, Object>();
        myHashMap1.put("�̸�", "�罿����");
        myHashMap1.put("�ٸ�����", "6");

        jsonObject1 = new JSONObject(myHashMap1);
        jsonArray1.add(jsonObject1);
         
        finalJsonObject1.put("����", jsonArray1);
        finalJsonObject1.put("����", "�ڳ���");
        finalJsonObject1.put("�Ĺ�", "����ȭ");
        
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