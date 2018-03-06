import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class A1987 {
	static boolean[][] check;
	static Stack<Character> s;
	static char[][] map;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num[] = br.readLine().split(" ");
		int row = Integer.parseInt(num[0]);
		int col = Integer.parseInt(num[1]);
		
		String value[] = new String[row];
		
		for(int i=0; i<row; i++) {
			value[i] = br.readLine();
		}
		map = new char [row][col];
		map[0] = value[0].toCharArray();
		map[1] = value[1].toCharArray();
		check = new boolean[row][col];
		
		s = new Stack<Character>();
		
		int cnt=0;
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				if(check[i][j]) {
					dfs(i,j,cnt);
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}
	
	public static void dfs(int x, int y) { 
		if(check[x][y]) {
			return;
		}
		check[x][y] = true;
		
		if(s.contains(map[x][y])) {
			dfs()
		} else {
			cnt++;
		}
			
		
	}
}
