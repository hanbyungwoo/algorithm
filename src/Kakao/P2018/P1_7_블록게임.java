package Kakao.P2018;

public class P1_7_��ϰ��� {
	public static void main(String args[]) {
		solution(new int[][]{{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,4,0,0,0},{0,0,0,0,0,4,4,0,0,0},{0,0,0,0,3,0,4,0,0,0},{0,0,0,2,3,0,0,0,5,5},{1,2,2,2,3,3,0,0,0,5},{1,1,1,0,0,0,0,0,0,5}});
	}
	// dx, dy�� �ٽ� 6���� ���簢���� Ȯ��������ϴµ�...
	// 3*2 / 2*3 (2���� ���̽�)
	static int [][]dx = {{0,0,0,1,1,1},{0,0,1,1,2,2}};
	static int [][]dy = {{0,1,2,0,1,2},{0,1,0,1,0,1}};
	static int n;
	public static int solution(int[][] board) {
		int answer = 0;
		
		// n*n 2���� �迭
		n = board.length;
		int [][] cnt = new int[n][n];
		int [][] chk = new int[n][n];
//		int [][]dx = {{1,1,1},{1,2,2},{1,2,2},{1,1,1},{1,1,1}};
//		int [][]dy = {{0,1,2},{0,0,-1},{0,0,1},{0,-1,-2},{-1,0,1}};
		
		// ���� Ȯ��
		while(true) {
			boolean flag = false;
			// �ʱ�ȭ
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					cnt[i][j] = chk[i][j] = 0;
				}
			}
			// �� �ִ� ���� cnt����
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					cnt[i][j] = (board[i][j] > 0 ? 1 : 0);
				}
			}
			// �ش� �ٿ� ���° ������� �˷���.
			for(int i=1; i<n; i++) {
				for(int j=0; j<n; j++) {
					cnt[i][j] += cnt[i-1][j];
				}
			}
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					for(int k=0; k<2; k++) {
						if(possi(i,j,k,cnt,board,chk)) {
							flag = true;
							answer++;
						}
					}
				}
			}
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(chk[i][j] > 0) {
						board[i][j] = 0;
					}
				}
			}
			// �ش� while���� ������ �ϳ��� ���� ���
			if(!flag) break;
		}
		System.out.println(answer);
		return answer;
	}
	
	public static boolean possi(int x, int y, int k, int[][] cnt, int[][] board, int[][] chk) {
		int col = -1;
		int cur = 0;
		for(int i=0; i<6; i++) {
			int nx = x+dx[k][i];
			int ny = y+dy[k][i];
			if(nx >= 0 && ny >= 0 && nx < n && ny < n) {
				if(board[nx][ny] > 0) {
					if(col == -1) {
						col = board[nx][ny];
					} else {
						if(col != board[nx][ny]) {
							return false;
						}
					}
				} else {
					cur++;
					// ������ ������ ���� ���� �������� �˷���
					if(cnt[nx][ny] > 0) {
						return false;
					}	
				}
			}
			else {
				return false;
			}
		}
		
		if(cur != 2) {
			return false;
		}
		for(int i=0; i<6; i++) {
			int nx = x + dx[k][i];
			int ny = y + dy[k][i];
			chk[nx][ny] = 1;
		}
		
		return true;
		
	}
	
}