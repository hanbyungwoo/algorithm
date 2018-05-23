package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A15683 {
	static int N, M;
	static int map[][];
	static int ans = Integer.MAX_VALUE;
	static ArrayList<graphInfo> list;
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		list = new ArrayList<graphInfo>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			for(int j=0; j<M; j++) {
				int temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
				// ī�޶��� ��� 1~5
				if(temp > 0 && temp < 6) {
					list.add(new graphInfo(i, j, temp));
				}
				
			}
		}
		
		search(0, map);
		System.out.println(ans);
	}
	
	public static void search(int cctvCnt, int prev[][]) {
		int visited[][] = new int[N][M];
		if(cctvCnt == list.size()) {
			// ��� ī�޶� Ž���Ϸ�
			int temp = 0;
			// �簢���� Ž�� 
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(prev[i][j] == 0) {
						temp++;
					}
				}
			}
			// �簢���� �ּڰ����� ����
			if(temp < ans) {
				ans = temp;
			}
		} else {
			graphInfo info = list.get(cctvCnt);
			int idx = info.val;
			int x = info.x;
			int y = info.y;
			
			switch(idx) {
			case 1 :
				// 1�� ī�޶� 4�� ȸ��
				for(int k=0; k<4; k++) {
					for(int i=0; i<N; i++) {
						// ���� ���� ��Ȳ
						visited[i] = Arrays.copyOf(prev[i], M);
					}
					// ���ÿ��� üũ
					detect(visited, y, x, k);
					// ���� CCTV Ž��
					search(cctvCnt + 1, visited);
				}
				break;
			case 2 : 
				// 2�� ī�޶� 2�� ȸ��
				for(int k=0; k<2; k++) {
					for(int i=0; i<N; i++) {
						// ���� ���� ��Ȳ
						visited[i] = Arrays.copyOf(prev[i], M);
					}
					// ���ÿ��� üũ
					detect(visited, y, x, k);
					detect(visited, y, x, k+2);
					// ���� CCTV Ž��
					search(cctvCnt + 1, visited);
				}
				break;
			case 3 :
				// 3�� ī�޶� 4�� ȸ��
				for(int k=0; k<4; k++) {
					for(int i=0; i<N; i++) {
						// ���� ���� ��Ȳ
						visited[i] = Arrays.copyOf(prev[i], M);
					}
					// ���ÿ��� üũ
					detect(visited, y, x, k);
					detect(visited, y, x, (k+1)%4);
					// ���� CCTV Ž��
					search(cctvCnt + 1, visited);
				}
				break;
			case 4 :
				// 4�� ī�޶� 4�� ȸ��
				for(int k=0; k<4; k++) {
					for(int i=0; i<N; i++) {
						// ���� ���� ��Ȳ
						visited[i] = Arrays.copyOf(prev[i], M);
					}
					// ���ÿ��� üũ
					detect(visited, y, x, k);
					detect(visited, y, x, (k+1)%4);
					detect(visited, y, x, (k+2)%4);
					// ���� CCTV Ž��
					search(cctvCnt + 1, visited);
				}
				break;
			case 5 :
				// 5�� ī�޶� 1�� ȸ��
				for(int i=0; i<N; i++) {
					// ���� ���� ��Ȳ
					visited[i] = Arrays.copyOf(prev[i], M);
				}
				// ���ÿ��� üũ
				detect(visited, y, x, 0);
				detect(visited, y, x, 1);
				detect(visited, y, x, 2);
				detect(visited, y, x, 3);
				// ���� CCTV Ž��
				search(cctvCnt + 1, visited);
				break;
			}
		}
	}
	
	public static void detect(int visited[][], int i, int j, int direction) {
		switch(direction) {
		case 0 :
			for(int k=j; k>=0; k--) {
				if(map[i][k] == 6) {
					break;
				}
				visited[i][k] = 7;
			}
			break;
		case 1 :
			for(int k=i; k>=0; k--) {
				if(map[k][j] == 6) {
					break;
				}
				visited[k][j] = 7;
			}
			break;
		case 2 :
			for(int k=j; k<M; k++) {
				if(map[i][k] == 6) {
					break;
				}
				visited[i][k] = 7;
			}
			break;
		case 3 :
			for(int k=i; k<N; k++) {
				if(map[k][j] == 6) {
					break;
				}
				visited[k][j] = 7;
			}
			break;
			
		}
	}
}

class graphInfo {
	int x;
	int y;
	int val;
	
	public graphInfo(int y, int x, int val) {
		this.x = x;
		this.y = y;
		this.val = val;
	}
}
