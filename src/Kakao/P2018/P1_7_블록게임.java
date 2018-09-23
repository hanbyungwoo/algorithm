package Kakao.P2018;

public class P1_7_블록게임 {
	public static void main(String args[]) {
		solution(new int[][]{{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,4,0,0,0},{0,0,0,0,0,4,4,0,0,0},{0,0,0,0,3,0,4,0,0,0},{0,0,0,2,3,0,0,0,5,5},{1,2,2,2,3,3,0,0,0,5},{1,1,1,0,0,0,0,0,0,5}});
	}
	// 블록이 붙어 있는 경우도 생각을 해야함..
	// 그럴경우 걍 6구역을 도는게 맞음..
	// ㅠㅠ 젠장!! 체크해서 해당 것만 삭제하고..휴;;
	public static int solution(int[][] board) {
		int answer = 0;
		
		// n*n 2차원 배열
		int n = board.length;
		boolean line[] = new boolean[n];
		int [][]dx = {{1,1,1},{1,2,2},{1,2,2},{1,1,1},{1,1,1}};
		int [][]dy = {{0,1,2},{0,0,-1},{0,0,1},{0,-1,-2},{-1,0,1}};
		
		// dx, dy를 다시 6개의 직사각형을 확인해줘야하는데...아 아닌가..;;흠
		//
		
		// 맵을 확인
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				
				// 보드에서 0 아닌 부분 만남
				if(board[i][j] != 0 && !line[j]) {
					// 해당 보드 검은 색 되는지 확인 작업
					boolean isCheck = false;
					for(int k=0; k<5; k++) {
						int check=0;
						for(int l=0; l<3; l++) {
							int nx = i + dx[k][l];
							int ny = j + dy[k][l];
							// 구역안에 들어옴.
							if(nx >= 0 && ny >= 0 && nx < n && ny < n && board[i][j] == board[nx][ny] && !line[ny]) {
								check++;
								if(isCheck) {
									board[nx][ny] = 0;
								}
							} else {
								break;
							}
						}
						// 검은색 블록으로 해제 가능
						if(check==3) {
							k--;
							isCheck = true;
							board[i][j] = 0;
							answer++;
						}
					}
					// 해당 줄 위에 뭔가 막혀있음을 표시
					if(!isCheck && !line[j]) {
 						line[j] = true;
					}
				}
			}
		}
		System.out.println(answer);
		return answer;
	}
}