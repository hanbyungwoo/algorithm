import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class aaaaaaa {
	
	static boolean check[];
	static int n;
	public static void main(String args[]) throws IOException {
		check = new boolean[10];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		
		calc2();
		
//		System.out.println(calc(n));
		
	}
	
	public static void calc2() {
		
	}
	
//	public static int calc(int n) {
//		for(int i=1; i<1000; i++) {
//			int temp = i*i + i + 1;
//			if(n == temp) {
//				return i;
//			}
//		}
//		return 0;
//	}
}
