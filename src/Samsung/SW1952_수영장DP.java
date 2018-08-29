package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW1952_수영장DP {
	static int price[];
	static int month[];
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int ca=1;
		int t = Integer.parseInt(st.nextToken());
		while(t-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			price = new int[4];
			month = new int[13];
			for(int i=0; i<4; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=1; i<=12; i++) {
				month[i] = Integer.parseInt(st.nextToken());
			}
			
			// 매달 최소 금액
			int minMonth[] = new int[13];
			for(int i=1; i<=12; i++) {
				minMonth[i] = Math.min(price[1], price[0]*month[i]);
			}
			int d[] = new int[13];
			
			d[0] = minMonth[0];
			for(int i=1; i<=12; i++) {
				d[i] = d[i-1] + minMonth[i];
				if(i-3 >= 0) {
					if(d[i] > d[i-3] + price[2]) {
						d[i] = d[i-3] + price[2];
					}
				}
			}
			
			if(d[12] > price[3]) {
				d[12] = price[3];
			}
			
			System.out.println("#"+ca+" "+d[12]);
			ca++;
		}
	}
}








