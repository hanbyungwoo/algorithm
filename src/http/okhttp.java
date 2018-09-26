package http;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class okhttp {
    public static void main(String[] args) {
		String json = "";
    	String url = "http://httpbin.org/get";
    	
    	 OkHttpClient client = new OkHttpClient();
    	 try {
             Request request = new Request.Builder()
                     .url(url)
                     .build();

             Response response = client.newCall(request).execute();
             json = response.body().string();    // 받아온 것 간순히 넣어주는 중..

         } catch (Exception e) {
             e.printStackTrace();
         }
    	 
    	 System.out.println(json);
    }
}
