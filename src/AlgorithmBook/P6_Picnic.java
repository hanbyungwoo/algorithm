package AlgorithmBook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P6_Picnic {
	
	static boolean isFriend[][];
	static int num;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		num = Integer.parseInt(st.nextToken());
		int pair = Integer.parseInt(st.nextToken());
		
		isFriend = new boolean[num][num];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<pair; i++) {
			int one = Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());
			isFriend[one][two] = true;
			isFriend[two][one] = true;
		}
		
		boolean isPair[] = new boolean[num];
		
		System.out.println(dfs(isPair));
	}
	
	public static int dfs(boolean isPair[]) {
		int first = -1;
		for(int i=0; i<num; i++) {
			if(!isPair[i]) {
				first = i;
				break;
			}
		}
		if(first == -1) return 1;
		int ret = 0;
		for(int i=first+1; i<num; i++) {
			if(!isPair[i] && isFriend[first][i]) {
				isPair[i] = true;
				isPair[first] = true;
				ret += dfs(isPair);
				isPair[i] = false;
				isPair[first] = false;
			}
		}
		
		return ret;
	}
}
