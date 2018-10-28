package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//http://organize-study.tistory.com/166
public class SW5653_�ٱ⼼����� {
	static final int range = 200;
	static int n, m, k;
	static int map[][];
	static int dx[] = {0,0,-1,1};
	static int dy[] = {-1,1,0,0};
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ca=1;
		
		int t = Integer.parseInt(st.nextToken());
		while(t-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			Queue<cell> q[] = (Queue<cell>[]) new LinkedList[11];
			for(int i=0; i<=10; i++) {
				q[i] = new LinkedList<cell>();
			}
			int ans=0;
			map = new int[500][500];
			for(int i=range; i<n+range; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=range; j<m+range; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] != 0) {
						// ��ǥ������ ���ش�.
						// �ش� ������ *2�� �ϴ� ������ �ش�ð���ŭ �ẹ�ϰ�, �ش�ð���ŭ Ȱ��ȭ�ϱ� ����
						// ���� life�� �ٽ� map[i][j]�� �������� ���� ������ ��.
						// 0�� �� ���� �� ���� ��쿡�� ��� life�� 1�� �����ϸ� q�� �ٽ� �־���.
						q[map[i][j]].add(new cell(2*map[i][j], i, j));
					}
				}
			}
			
			for(int i=0; i<=k; i++) {
				for(int j=10; j>=1; j--) {
					int size = q[j].size();
					for(int k=0; k<size; k++) {
						cell x = q[j].poll();
						if(x.life > j) {	// �ẹ��
							if(map[x.x][x.y] > 0) {
								ans++;
								map[x.x][x.y] = -map[x.x][x.y];
							}
							q[j].add(new cell(x.life-1, x.x, x.y));
						} else if(x.life == j) {	// Ȱ��ȭ�ϰ� 1�ð� ������.
							// Ȱ��ȭ�ص� �ش��ϴ� �� �ְ� �� ���� Ȱ��ȭ�Ǵ� ������ �߰� �ʿ�.
							// ���� Ȯ�� �� ū ������ ���� ������ �Դµ� �װ��� �̹� ť�� 10���� ���� ��츦 �� ���� ��
							// 10�� ���� Ȯ���ϱ� ������ ū ������ ���� �ڸ��� ����.
							q[j].add(new cell(x.life-1, x.x, x.y));
							for(int l=0; l<4; l++) {
								int nx = x.x + dx[l];
								int ny = x.y + dy[l];
								if(map[nx][ny] != 0) continue;
								map[nx][ny] = j;
								q[j].add(new cell(2*j, nx, ny));
							}
						} else if(j > x.life && x.life > 0) {	// Ȱ��ȭ ��...(������ ������)
							q[j].add(new cell(x.life-1, x.x, x.y));
						} else {
							ans--;
						}
					}
				}
			}
			System.out.println("#"+(ca++)+" "+ans);
		}
	}
	static class cell {
		int x, y, life;
		public cell(int life, int x, int y) {
			this.life = life;
			this.x = x;
			this.y = y;
		}
	}
	
	
}