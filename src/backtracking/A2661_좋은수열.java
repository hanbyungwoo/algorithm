package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A2661_좋은수열 {
	static int num;
	static boolean stop = false;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		num = Integer.parseInt(st.nextToken());
		
		dfs(1, "1");

	}
	
	public static void dfs(int depth, String s) {
		if(stop) {
			return;
		}
		if(depth == num) {
			// 맨 처음에 나오는 값이 최소값임.
			stop = true;
			System.out.println(s);
		} else {
			for(int i=1; i<4; i++) {
				if(isSatisfy(s+i)) {
					dfs(depth+1, s+i);
				}
			}
		}
	}
	
	public static boolean isSatisfy(String s) {
		// 문자가 하나씩 추가될때 마다 만족하는지 검색해준다.
		// 그렇기 때문에 문자열 길이의 1/2만 확인해주면된다.
		// 예시 : 123123
		// 첫번째 비교 : 1231 (2 3)
		// 두번째 비교 : 12 (31 23)	--> 12 31은 비교안하는 이유는 이미 그 전에 비교를 해서 6개 길이까지 넘어온 것들임
		// 세번째 비교 : (123 123)
		int len = s.length();
		int loop = len / 2;
		int start = len - 1;
		int end = len;
		
		for(int i = 1; i <= loop; i++) {
			if(s.substring(start-i, end-i).equals(s.substring(start, end))) {
				return false;
			}
			start -= 1;
		}
		
		return true;
		
	}
}

