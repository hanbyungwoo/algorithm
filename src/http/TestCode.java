package http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
 
public class TestCode {
     
    public void naverInvoker(){
        try {
 
//        	URL url = new URL("https://swapi.co/api/");
        	String mainUrl = "https://search.naver.com/search.naver";
        	String data = "?ie=UTF-8&query=ns&sm=chr_hty";
        	URL url = new URL(mainUrl+data);
        	
//        	String data = URLEncoder.encode("key1", "ie") + "=" + URLEncoder.encode("value1", "UTF-8");
//			data += "&" + URLEncoder.encode("key2", "query") + "=" + URLEncoder.encode("value2", "ns포대유청");
//			data += "&" + URLEncoder.encode("key3", "sm") + "=" + URLEncoder.encode("value3", "chr_hty");
        	
        	 
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
//            connection.setRequestProperty("content-Type", "application/json");
            connection.setRequestProperty("content-Type", "text/html");
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
            connection.setDoInput(true);
//            connection.setDoOutput(true);
//            connection.setRequestProperty("Accept-Charset", "EUC-KR");
//            connection.setRequestProperty("Content-Type", "multipart/form-data;boundary=*****;charset=utf-8");
 
            InputStream is = connection.getInputStream();
            // 상태코드
//            int responseCode = connection.getResponseCode();
//            System.out.println(responseCode);
            
            // 한글~
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String readLine = null;
//            OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream());
//			wr.write(data);
            
            // post데이터 전송
//            DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
//          //writeBytes에 한글이 들어갈 경우 깨져서 전송된다. UrlEncoder로 UTF-8, EUC-KR을 해줘도 깨짐
//            dos.writeBytes(lineEnd + twoHyphens + boundary + lineEnd);
//            dos.writeBytes("Content-Disposition: form-data; name=\"hangul\"" + lineEnd + lineEnd + "한글");
//            				
//            //한글 부분만 writeUTF 을 사용하여 전송하면 깨지지않고 보낼 수 있다.
//            dos.writeBytes(lineEnd + twoHyphens + boundary + lineEnd);
//            dos.writeBytes("Content-Disposition: form-data; name=\"hangul\"" + lineEnd + lineEnd);
//            dos.writeUTF("한글");
            while ((readLine = br.readLine()) != null) {
                System.out.println(readLine);
            }
 
            br.close();
 
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
     
    public static void main(String[] args) {
         
        TestCode t = new TestCode();
        t.naverInvoker();
    }
}