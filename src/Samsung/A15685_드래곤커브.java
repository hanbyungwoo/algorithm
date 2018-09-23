package Samsung;
//https://m.blog.naver.com/PostView.nhn?blogId=godori91&logNo=221256904654&proxyReferer=https%3A%2F%2Fwww.google.co.kr%2F
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class A15685_�巡��Ŀ�� {
	static int dx[] = {0,-1,0,1};	// �� �� �� ��
	static int dy[] = {1,0,-1,0};
	
	static boolean map[][];
	static int endx, endy;
	
	static ArrayList<Integer> dragon;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		map = new boolean[102][102];
		int n = Integer.parseInt(st.nextToken());
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			dragon = new ArrayList<Integer>();
			
			// ���� ����
			endx = x;
			endy = y;
			
			// ���� ��ġ ǥ��
			map[endx][endy] = true;
			
			// 0���� �����
			endx = x + dx[d];
			endy = y + dy[d];
			
			// 0���� ��ġ ǥ��
			map[endx][endy] = true;
			
			dragon.add(d);
			
			// 0���� g�������
			for(int j=0; j<g; j++) {
				makeGeneration();
			}
		}
		
		//100*100 2���� ����� 2�� for�� ����� �ܼ��� Ž��
	    //������ 4ĭ�� ��� true�̸�, 4ĭ�� ��� �巡�� Ŀ���� �Ϻ��ΰ�
	    //������ 1������Ų��.
	    int result = 0;
	    for(int i=0; i<=100; i++){
	        for(int j=0; j<=100; j++){
	            
	            //������ 4ĭ�� ���簢���� ��� �巡���� �Ϻ��̸�
	            if(map[i][j] == true && map[i][j+1] == true && map[i+1][j] == true && map[i+1][j+1] == true){
	                
	                //������ 1 ������Ų��.
	                result++;
	            }
	        }
	    }
	    
	    //���� ���
	    System.out.println(result);
	 
		
	}

	private static void makeGeneration() {
		//���� ������ ũ�⸦ ���� ����� ���´�.
		int size = dragon.size();
		
		//������ �ڿ��� ���� �����鼭
	    //���������� ���������� dir = (dragon[i] + 1)%4; ��Ģ�� ���� �����Ѵ�.
		for(int i = size-1; i>=0; i--) {
			int dir = (dragon.get(i) + 1)%4;
			
			//���� ������ ���������� �������� ���� x,y�� ã�� �̸� �����Ѵ�.
			endx = endx + dx[dir];
			endy = endy + dy[dir];
			
			//������� �巡�� Ŀ�긦 ������ �����ش�.
			map[endx][endy] = true;
			
			//�������븦 ���� ���ÿ� ���������� �־��ش�.
			dragon.add(dir);
		}
		
	}
	
	
}