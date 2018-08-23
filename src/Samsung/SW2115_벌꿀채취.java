package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW2115_¹ú²ÜÃ¤Ãë {
	static int map[][];
	static int dx[] = {-1, 1, 0, 0};	// »ó ÇÏ ÁÂ ¿ì
	static int dy[] = {0, 0, -1, 1};
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int ca=1;
		int t = Integer.parseInt(st.nextToken());
		while(t-- > 0) {
			
			System.out.println("#"+ca+" ");
			ca++;
		}
	}
	

}









