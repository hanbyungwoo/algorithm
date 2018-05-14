package Kakao;

public class P1_6 {
	public static void main (String args[] ) {
		
		int m=4, n=5;
		String []board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
		char[][] map = new char[m][n];
		int[][] mapCheck = new int[m][n];
		for(int i=0; i<m; i++) {
			map[i] = board[i].toCharArray();
		}
		int check=0;
		while(true) {
			for(int i=0; i<m-1; i++) {
				for(int j=0; j<n-1; j++) {
					if(map[i][j] == map[i+1][j] &&
						map[i][j] == map[i][j+1] &&
						map[i][j]== map[i+1][j+1] && map[i][j] != ' ') {
						// 2 by 2 같은 경우
						mapCheck[i][j]++;
						mapCheck[i+1][j]++;
						mapCheck[i][j+1]++;
						mapCheck[i+1][j+1]++;
						check++;
					}
				}
			}
			for(int i=0; i<m; i++) {
				for(int j=0; j<n; j++) {
					if(mapCheck[i][j] != 0) {
						map[i][j] = ' ';
					}
				}
			}
			if(check != 0) {
				check=0;
				// m 4 n 5
				for(int i=0; i<n; i++) {
					for(int j=m-1; j>=0; j--) {
						// 공백을 내려야함..
						if(mapCheck[j][i] != 0 ) {	// 터진 놈.
							for(int k=j; k>0; k--) {
								map[k][i] = map[k-1][i];
							}
							
							map[0][i] = ' ';
							mapCheck[j][i]=0;
							
							j += 1;
						}
//						if()
					}
				}
			} else {
				break;
			}
		}
		int ans=0;
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(mapCheck[i][j] == 0) {
					ans++;
				}
			}
		}
		System.out.println(ans);
	}
}
