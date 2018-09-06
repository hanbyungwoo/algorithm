package Kakao.P2017;

public class P1_6_«¡∑ª¡Ó4∫Ì∑œ {
	public static void main (String args[] ) {
		solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"});
		solution(6, 6, new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"});	
	}
	
	public static int solution(int m, int n, String[] board) {
		char[][] map = new char[m][n];
		int answer = 0;
		
		for(int i=0; i<m; i++) {
			map[i] = board[i].toCharArray();
		}
		
		boolean isCheck=false;
		while(!isCheck) {
			isCheck=true;
			for(int i=0; i<m-1; i++) {
				for(int j=0; j<n-1; j++) {
					if(map[i][j] != 0 && map[i][j]%100==map[i][j+1]%100 && map[i][j]%100==map[i+1][j]%100 && map[i][j]%100==map[i+1][j+1]%100) {
						map[i][j] += 100;
						map[i][j+1] += 100;
						map[i+1][j] += 100;
						map[i+1][j+1] += 100;
					}
				}
			}
			
			for(int i=0; i<n; i++) {
				for(int j=m-1; j>=0; j--) {
					if(map[j][i] > 100) {
						for(int k=j; k>0; k--) {
							map[k][i] = map[k-1][i];							
						}
						map[0][i] = 0;
						answer++;
						j++;
						isCheck=false;
					}
				}
			}
		}
		System.out.println(answer);
		
	    
	    return answer;
	}
}
