package Samsung;
//https://m.blog.naver.com/PostView.nhn?blogId=godori91&logNo=221256904654&proxyReferer=https%3A%2F%2Fwww.google.co.kr%2F
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class A15685_드래곤커브 {
	static int dx[] = {0,-1,0,1};	// 좌 상 우 하
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
			
			// 끝점 갱신
			endx = x;
			endy = y;
			
			// 현재 위치 표시
			map[endx][endy] = true;
			
			// 0세대 만들기
			endx = x + dx[d];
			endy = y + dy[d];
			
			// 0세대 위치 표시
			map[endx][endy] = true;
			
			dragon.add(d);
			
			// 0부터 g세대까지
			for(int j=0; j<g; j++) {
				makeGeneration();
			}
		}
		
		//100*100 2차원 행렬을 2중 for문 사용한 단순한 탐색
	    //인접한 4칸이 모두 true이면, 4칸이 모두 드래곤 커브의 일부인것
	    //갯수를 1증가시킨다.
	    int result = 0;
	    for(int i=0; i<=100; i++){
	        for(int j=0; j<=100; j++){
	            
	            //인접한 4칸의 정사각형이 모두 드래곤의 일부이면
	            if(map[i][j] == true && map[i][j+1] == true && map[i+1][j] == true && map[i+1][j+1] == true){
	                
	                //갯수를 1 증가시킨다.
	                result++;
	            }
	        }
	    }
	    
	    //갯수 출력
	    System.out.println(result);
	 
		
	}

	private static void makeGeneration() {
		//현재 스택의 크기를 먼저 계산해 놓는다.
		int size = dragon.size();
		
		//스택의 뒤에서 부터 꺼내면서
	    //다음세대의 방향정보를 dir = (dragon[i] + 1)%4; 규칙에 따라 생성한다.
		for(int i = size-1; i>=0; i--) {
			int dir = (dragon.get(i) + 1)%4;
			
			//다음 세대의 방향정보를 바탕으로 다음 x,y를 찾고 이를 갱신한다.
			endx = endx + dx[dir];
			endy = endy + dy[dir];
			
			//만들어진 드래곤 커브를 지도에 놓아준다.
			map[endx][endy] = true;
			
			//다음세대를 위하 스택에 방향정보를 넣어준다.
			dragon.add(dir);
		}
		
	}
	
	
}