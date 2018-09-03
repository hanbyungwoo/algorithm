package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW2115_벌꿀채취 {
	static int map[][];
	static int n, m, c, max, max1, max2;
	static int val1[], val2[];
	static boolean temp[];
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int ca=1;
		int t = Integer.parseInt(st.nextToken());
		while(t-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			map = new int[n][n];
			val1 = new int[m];
			val2 = new int[m];
			max = 0;
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<n*n; i++) {
				int x = i/n;
				int y = i%n;
				dfs(x, y);
			}
			
			System.out.println("#"+ca+" "+max);
			ca++;
		}
	}
	
	public static void dfs(int x, int y) {
		if(y+m <= n) {
			// 1번이 해당 줄에서만 가능할 경우
			for(int i=0; i<m; i++) {
				val1[i] = map[x][y+i];
			} 
			max1 = 0;
			cal(val1, 1);
			// 해당 줄을 초과할 경우
			// x를 증가시켜서 DFS돌린다.
			for(int i=y+m; i<n; i++) {
				dfs2(x, i);
			}
			for(int i=x+1; i<n; i++) {
				for(int j=0; j<n; j++) {
					dfs2(i, j);					
				}
			}
			
		}
		// 1번이 해당 줄에서는 부족할 경우
		// 그럴 경우는 필요가 없네? 실행하지 말 것
	}
	
	public static void dfs2(int x, int y) {
		if(y+m <= n) {
			for(int i=0; i<m; i++) {
				val2[i] = map[x][y+i];
			}
			
			// 최대값 계산하자.
			max2 = 0;
			cal(val2, 2);
			max = Math.max(max, max1+max2);
		}
	}
	
	// check ( 1 : 1번 꿀통 / 2 : 2번 꿀통 )
	public static void cal(int val[], int check) {
//		System.out.println("1 : " + val1[0] + ", " + val1[1] + " 2 : " + val2[0] + ", " + val2[1]);
		temp = new boolean [m];
		for(int i=0; i<m; i++) {
			if(!temp[i]) {
				temp[i] = true;
				pick(i, val, check);
				temp[i] = false;
			}
		}
	}
	
	public static void pick(int index, int val[], int check) {
		int mul=0;
		int sum=0;
		
		// 모든 경우를 다 체크해주는중
		for(int i=0; i<m; i++) {
			if(temp[i]) {
				sum += val[i];
				mul += val[i]*val[i];
			}
		}
		
		if(sum <= c && check == 1) {
			max1 = Math.max(mul, max1);
		}
		if(sum <= c && check == 2) {
			max2 = Math.max(mul, max2);
		}
		
		for(int i=index+1; i<m; i++) {
			if(!temp[i]) {
				temp[i] = true;
				pick(index+1, val, check);
				temp[i] = false;
			}
			
		}
	}

}









