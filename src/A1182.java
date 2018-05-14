import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A1182 {
	static int ans;
	static int S, N;
	static int number[];
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//		String[] sArr = br.readLine().trim().split(" ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		number = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0, 0, false);
//		int ans = 0;
//		// 공집합 제외
//		for(int i=1; i<(1<<N); i++) {
//			// 2^N - 1
//			int sum = 0;
//			for(int j=0; j<N; j++) {
//				// 모든 경우의 수를 체크해준다...
//				if( (i&(1<<j)) != 0 ) {
//					sum += number[j];
//				}
//			}
//			if(sum == S) {
//				ans += 1;
//			}
//		}
//		
		System.out.println(ans);
		
	}
	public static void dfs(int sum, int depth, boolean ch) {
		if(sum == S && ch) {
			ans++;
		}
		if(depth >= N) {
			return;
		}
		
		dfs(sum+number[depth], depth+1, true);
		dfs(sum, depth+1, false);
	}
}
