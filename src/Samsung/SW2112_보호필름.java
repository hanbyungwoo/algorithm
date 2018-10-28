package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW2112_��ȣ�ʸ� {
	static int map[][], copymap[][];
	static boolean temp[];
	static int d, w, k, ans;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int ca=1;
		int t = Integer.parseInt(st.nextToken());
		while(t-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			
			d = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			map = new int[d][w];
			copymap = new int[d][w];
			for(int i=0; i<d; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			ans = Integer.MAX_VALUE;
			if(!check()) {
				dfs(0, 0);
			} else {
				ans = 0;
			}
			
			
			System.out.println("#"+ca+" "+ans);
			ca++;
		}
	}
	
	public static void dfs(int row, int len) {
		if(len > ans || len == k+1) {
			return;
		}

		if(row == d) {
			if(check()) {
				ans = Math.min(ans, len);
			}
			return;
		}
		
		// �ϴ� �Ǹ����� �ٱ��� ä�� 
		dfs(row+1, len);
		
		// A�� ä��
		injection(row, 0);
		dfs(row+1, len+1);
		recovery(row);
		
		// B�� ä��
		injection(row, 1);
		dfs(row+1, len+1);
		recovery(row);
	}
	
	public static void injection(int row, int val) {
        for (int i = 0; i < w; ++i) {
            copymap[row][i] = map[row][i];
            map[row][i] = val;
        }
    }

	public static void recovery(int row) {
        for (int i = 0; i < w; ++i) {
            map[row][i] = copymap[row][i];
        }
    }
	
	public static boolean check() {
		int cnt;
		int prev;
		int w_cnt=0;
		
		for(int i=0; i<w; i++) {
			prev = map[0][i];
			cnt = 1;
			for(int j=1; j<d; j++) {
				if(prev == map[j][i]) {
					cnt++;
				} else {
					prev = map[j][i];
					cnt = 1;
				}
				
				if(cnt >= k) {
					// �հݱ��� �̻�
					w_cnt++;
					break;
				}
			}
		}
		
		if(w_cnt == w) {
			return true;
		} else {
			return false;
		}
	}
	

}









