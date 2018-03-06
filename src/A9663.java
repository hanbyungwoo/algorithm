import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A9663 {
	static boolean map[][];
	
	static boolean check_col[];	// | 방향
	static boolean check_dig1[];	// / 대각선
	static boolean check_dig2[];	// \ 대각선
	
	static int n;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		
		map= new boolean[n][n];
		check_col = new boolean[n];	// | 방향
		check_dig1 = new boolean[2*n];	// / 대각선
		check_dig2 = new boolean[2*n];	// \ 대각선
		
		System.out.println(calc(0));
	}
	
	public static int calc(int row) {
		if(row == n) {
			return 1;
		}
		
		int cnt = 0;
		for(int col=0; col<n; col++) {
			if(check(row, col)) {
				check_col[col] = true;
				check_dig1[row+col] = true;
				check_dig2[row-col+n] = true;
				map[row][col] = true;
				cnt += calc(row+1);
				check_col[col] = false;
				check_dig1[row+col] = false;
				check_dig2[row-col+n] = false;
				map[row][col] = false;
			}
		}
		
		return cnt;
	}
	
	public static boolean check(int row, int col) {
		if(check_col[col]) {
			return false;
		}
		if(check_dig1[row+col]) {
			return false;
		}
		if(check_dig2[row-col+n]) {
			return false;
		}
		return true;
	}
}
