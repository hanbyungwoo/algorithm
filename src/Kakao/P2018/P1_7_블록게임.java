package Kakao.P2018;

public class P1_7_블록게임 {
	public static void main(String args[]) {
		solution(new int[][]{{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,4,0,0,0},{0,0,0,0,0,4,4,0,0,0},{0,0,0,0,3,0,4,0,0,0},{0,0,0,2,3,0,0,0,5,5},{1,2,2,2,3,3,0,0,0,5},{1,1,1,0,0,0,0,0,0,5}});
	}
	// dx, dy를 다시 6개의 직사각형을 확인해줘야하는데...
	// 3*2 / 2*3 (2가지 케이스)
	static int [][]dx = {{0,0,0,1,1,1},{0,0,1,1,2,2}};
	static int [][]dy = {{0,1,2,0,1,2},{0,1,0,1,0,1}};
	static int n;
	public static int solution(int[][] board) {
		int answer = 0;
		
		// n*n 2차원 배열
		n = board.length;
		int [][] cnt = new int[n][n];
		int [][] chk = new int[n][n];
//		int [][]dx = {{1,1,1},{1,2,2},{1,2,2},{1,1,1},{1,1,1}};
//		int [][]dy = {{0,1,2},{0,0,-1},{0,0,1},{0,-1,-2},{-1,0,1}};
		
		// 맵을 확인
		while(true) {
			boolean flag = false;
			// 초기화
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					cnt[i][j] = chk[i][j] = 0;
				}
			}
			// 값 있는 곳에 cnt증가
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					cnt[i][j] = (board[i][j] > 0 ? 1 : 0);
				}
			}
			// 해당 줄에 몇번째 블록인지 알려줌.
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
			// 해당 while문에 깨진게 하나도 없을 경우
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
					// 위에서 깨지지 않은 블럭이 존재함을 알려줌
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