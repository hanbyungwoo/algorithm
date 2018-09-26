package http;

import java.io.File;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public final class PostFile {
	  public static final MediaType MEDIA_TYPE_MARKDOWN
	      = MediaType.get("text/x-markdown; charset=utf-8");

	  private final OkHttpClient client = new OkHttpClient();
	  
	  public void run() throws Exception {
		String path = PostFile.class.getResource("").getPath(); // 현재 클래스의 절대 경로를 가져온다.
		System.out.println(path+"123.txt"); //--> 절대 경로가 출력됨
	    File file = new File(path+"123.txt");

	    Request request = new Request.Builder()
	        .url("https://api.github.com/markdown/raw")
	        .post(RequestBody.create(MEDIA_TYPE_MARKDOWN, file))
	        .build();

	    try (Response response = client.newCall(request).execute()) {
	      if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

	      System.out.println(response.body().string());
	    }
	  }

	  public static void main(String... args) throws Exception {
		  
	    new PostFile().run();
	  }
	}