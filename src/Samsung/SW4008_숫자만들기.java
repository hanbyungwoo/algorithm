package Samsung;
// 백준 14888 연산자 끼워넣기
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW4008_숫자만들기 {
	static int n;
	static int num[];
	static int max, min;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int ca=1;
		int t = Integer.parseInt(st.nextToken());
		while(t-- > 0) {
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			
			
			int oper[] = new int[4];
			// 0 +
			// 1 -
			// 2 *
			// 3 /
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<4; i++) {
				oper[i] = Integer.parseInt(st.nextToken());
			}
			
			
			num = new int[n];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<n; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(1, oper[0], oper[1], oper[2], oper[3], num[0]);
			
			System.out.println("#"+ca+" "+(max-min));
			ca++;
		}
	}
	
	public static void dfs(int depth, int plus, int minus, int mul, int div, int sum) {
		if(depth == n) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			
			return;
		} else {
			if(plus > 0) {
				dfs(depth+1, plus-1, minus, mul, div, sum+num[depth]);
			}
			if(minus > 0) {
				dfs(depth+1, plus, minus-1, mul, div, sum-num[depth]);
			}
			
			if(mul > 0) {
				dfs(depth+1, plus, minus, mul-1, div, sum*num[depth]);
			}
			if(div > 0) {
				dfs(depth+1, plus, minus, mul, div-1, sum/num[depth]);
			}
		}
	}
}

