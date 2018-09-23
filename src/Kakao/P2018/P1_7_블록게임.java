package Kakao.P2018;

public class P1_7_��ϰ��� {
	public static void main(String args[]) {
		solution(new int[][]{{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,4,0,0,0},{0,0,0,0,0,4,4,0,0,0},{0,0,0,0,3,0,4,0,0,0},{0,0,0,2,3,0,0,0,5,5},{1,2,2,2,3,3,0,0,0,5},{1,1,1,0,0,0,0,0,0,5}});
	}
	// ����� �پ� �ִ� ��쵵 ������ �ؾ���..
	// �׷���� �� 6������ ���°� ����..
	// �Ф� ����!! üũ�ؼ� �ش� �͸� �����ϰ�..��;;
	public static int solution(int[][] board) {
		int answer = 0;
		
		// n*n 2���� �迭
		int n = board.length;
		boolean line[] = new boolean[n];
		int [][]dx = {{1,1,1},{1,2,2},{1,2,2},{1,1,1},{1,1,1}};
		int [][]dy = {{0,1,2},{0,0,-1},{0,0,1},{0,-1,-2},{-1,0,1}};
		
		// dx, dy�� �ٽ� 6���� ���簢���� Ȯ��������ϴµ�...�� �ƴѰ�..;;��
		//
		
		// ���� Ȯ��
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				
				// ���忡�� 0 �ƴ� �κ� ����
				if(board[i][j] != 0 && !line[j]) {
					// �ش� ���� ���� �� �Ǵ��� Ȯ�� �۾�
					boolean isCheck = false;
					for(int k=0; k<5; k++) {
						int check=0;
						for(int l=0; l<3; l++) {
							int nx = i + dx[k][l];
							int ny = j + dy[k][l];
							// �����ȿ� ����.
							if(nx >= 0 && ny >= 0 && nx < n && ny < n && board[i][j] == board[nx][ny] && !line[ny]) {
								check++;
								if(isCheck) {
									board[nx][ny] = 0;
								}
							} else {
								break;
							}
						}
						// ������ ������� ���� ����
						if(check==3) {
							k--;
							isCheck = true;
							board[i][j] = 0;
							answer++;
						}
					}
					// �ش� �� ���� ���� ���������� ǥ��
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