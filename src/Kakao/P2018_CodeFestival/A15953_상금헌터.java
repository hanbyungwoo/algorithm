package Kakao.P2018_CodeFestival;
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A15953_ªÛ±›«Â≈Õ {
	static int[] money1 = {5000000, 3000000, 2000000, 500000, 300000, 100000};
	static int[] money2 = {5120000, 2560000, 1280000, 640000, 320000};
	public static void main(String args[]) throws IOException {
		int person1[] = {1, 3, 6, 10, 15, 21};
		int person2[] = {1, 3, 7, 15, 31};
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int t = Integer.parseInt(st.nextToken());
		 
		
		for(int i=0; i<t; i++) {
			int sum=0;
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if(x!=0) {
				for(int j=0; j<person1.length; j++) {
					if(person1[j] >= x) {
						sum += money1[j];
						break;
					}
				}
			}
			if(y!=0) {
				for(int k=0; k<person2.length; k++) {
					if(person2[k] >= y) {
						sum += money2[k];
						break;
					}
				}
			}
			System.out.println(sum);
		}
	}
	
}