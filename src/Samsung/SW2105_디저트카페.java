package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW2105_����Ʈī�� {
	static int map[][];
	static int dx[] = {-1, 1, -1, 1};	// �»� ���� ��� ����
	static int dy[] = {-1, -1, 1, 1};
	static int dCnt[];
	static boolean isDesert[];
	static int n, ans, sx, sy;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int ca=1;
		int t = Integer.parseInt(st.nextToken());
		while(t-- > 0) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			isDesert = new boolean[101];
			map = new int[n][n];
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			ans = -1;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					sx = i;
					sy = j;
					dfs(i, j, 1, -1, 0);
				}
			}
			
			System.out.println("#"+ca+" "+ans);
			ca++;
		}
	}
	
	public static void dfs(int x, int y, int l, int d, int c) {
		// l : ���ݱ��� �� ����, d : ���� ���ϴ� ����, c : ���ݱ��� ������ �ٲ� Ƚ��
		// c �� 3~4�� ���� �簢����
		// ��������� �����ؼ� �� ��������� ���ƿ��� ��� 3
		// ��������� �����ؼ� ����� �ڿ��� �����ϴ� ��� 4
		if( c >= 5 ) {	// 5�̻��̸� �簢�� �ƴ�.
			return;
		}
		
		isDesert[map[x][y]] = true;
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx == sx && ny == sy && l >= 4 && c >= 3) {
				ans = Math.max(ans, l);
				isDesert[map[x][y]] = false;
				return;
			}
			if(nx < 0 || nx >= n || ny < 0 || ny >= n || isDesert[map[nx][ny]]) {
				continue;
			}
			dfs(nx, ny, l+1, i, i==d?c:c+1);
		}
		isDesert[map[x][y]] = false;
	}
	
}