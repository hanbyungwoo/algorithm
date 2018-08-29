package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW1952_수영장DFS {
	static int min;
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
			month = new int[12];
			for(int i=0; i<4; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			min = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<12; i++) {
				month[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0, 0);
			
			System.out.println("#"+ca+" "+min);
			ca++;
		}
	}
	
	public static void dfs(int mon, int sum) {
		if(mon >= 12) {
			min = Math.min(min, sum);
			return;
		}
		
		// 1일 이용권
		dfs(mon+1, sum+price[0]*month[mon]);
		// 1달 이용권
		dfs(mon+1, sum+price[1]);
		// 3달 이용권
		dfs(mon+3, sum+price[2]);
		// 12달 이용권
		dfs(mon+12, sum+price[3]);
	}
}








