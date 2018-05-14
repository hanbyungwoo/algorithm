package Search;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class A2026 {
	static int arr[][] = new int[901][901];
	static boolean visit[], end;
	static int k, n;
	static ArrayList<Integer> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		int f = Integer.parseInt(st.nextToken());
		// k명 소풍, n명 학생, f줄 입력(친구관계)
		
		for(int i=0; i<f; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int one = Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());
			arr[one][two] = 1;
			arr[two][one] = 1;
		}
		
		for(int i=1; i<=n; i++) {
			end = false;
			list = new ArrayList<Integer>();
			visit = new boolean[n+1];
			dfs(i);
			if(end) {
				return;
			}
		}
		System.out.println(-1);
	}
	
	
	public static void dfs(int idx) {
		if(end) {
			return;
		}
		
		visit[idx] = true;
		list.add(idx);
		
		if(k==list.size()) {
			for(int f : list) {
				System.out.println(f);
			}
			end = true;
			return;
		} else {
			for(int i = idx+1; i<=n; i++) {
				if(visit[i]==false) {
					boolean flag = true;
					// 서로 모두가 친구인지 확인
					for(int f : list) {
						if(arr[i][f] == 0) {
							flag = false;
							break;
						}
					}
					if(flag) {
						dfs(i);
					}
				}
			}
		}
		
		
	}
}
