package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A6987_������ {
	static int result[][][] = new int[4][6][3];
	static int temp[][] = new int[6][3];
	static boolean ans[] = new boolean[4];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int t = 0; t < 4; t++){
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 6; i++){
				for (int j = 0; j < 3; j++){
					result[t][i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}
		backTracking(0,1);
		for (int i = 0; i < 4; i++){
			if (ans[i])
				System.out.print("1 ");
			else
				System.out.print("0 ");
		}
		

	}
	
	public static void backTracking(int team1, int team2) {
		if (team1 == 5 && team2 == 6){
			for (int i = 0; i < 4; i++){
				if (isSame(i)){
					ans[i] = true;
				}
			}
			return;
		}
		// �� �� �� �÷ȴ� ���ȴ�
		for (int k = 1; k <= 3; k++){
			int nextT1 = team1, nextT2 = team2 + 1;
			if (team2 == 5) {
				// ������ ������ �������Ƿ� �ٽ� team1 �ϳ� �ø��� ��ʸ�Ʈ �� ���Ѻ���
				nextT1++;
				nextT2 = nextT1 + 1;
			}
			if (k == 1){
				// team1 �� ������ team2 �� ������
				temp[team1][0]++;
				temp[team2][2]++;

			}
			if (k == 2){
				temp[team1][2]++;
				temp[team2][0]++;

			}
			if (k == 3){
				temp[team1][1]++;
				temp[team2][1]++;
			}
			backTracking(nextT1, nextT2);
			if (k == 1){
				temp[team1][0]--;
				temp[team2][2]--;

			}
			if (k == 2){
				temp[team1][2]--;
				temp[team2][0]--;

			}
			if (k == 3){
				temp[team1][1]--;
				temp[team2][1]--;
			}

		}
	}
	
	// ���� ��� �ִ��� ã�ƺ���~.~
	public static boolean isSame(int idx){
		for (int i = 0; i < 6; i++){
			for (int j = 0; j < 3; j++){
				if (temp[i][j] != result[idx][i][j]) return false;
			}
		}
		return true;
	}
}

