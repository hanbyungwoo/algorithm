package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A14890_경사로 {
	static int map[][], map2[][];
	static int N, L, ans;
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		
		map = new int[N+1][N+1];
		map2 = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				map2[j][i] = map[i][j];
			}
		}
		
		
		solve(map);
		solve(map2);
		System.out.println(ans);
	}
	
	public static void solve(int arr[][]) {
		int i, j;
		for(i=1; i<=N; i++) {
			int cnt=1;
			for(j=1; j<=N-1; j++) {
				if(arr[i][j] == arr[i][j+1]) cnt++;
				else if(arr[i][j]+1 == arr[i][j+1] && cnt >= L) cnt = 1;	// 오르막길
				else if(arr[i][j]-1 == arr[i][j+1] && cnt >= 0) cnt = -L+1;	// 내리막길
				else break;
			}
			if(j==N && cnt >= 0) {
				ans++;
			}
		}
	}
	
}













