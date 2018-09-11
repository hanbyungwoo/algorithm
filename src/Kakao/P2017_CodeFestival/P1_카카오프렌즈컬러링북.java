package Kakao.P2017_CodeFestival;

public class P1_카카오프렌즈컬러링북 {
	public static void main(String args[]) {
		solution(6, 4, new int[][]{{1,1,1,0},{1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}});
	}
	
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, 1, -1};
	static int map[][];
	static boolean isVisit[][];
	static int max;
	static int row, col;
	public static int[] solution(int m, int n, int[][] picture) {
	      int numberOfArea = 0;
	      int maxSizeOfOneArea = 0;
	      row = m;
	      col = n;
	      isVisit = new boolean[m][n];
	      map = new int[m][n];
	      
	      for(int i=0; i<m; i++) {
	    	  for(int j=0; j<n; j++) {
	    		  map[i][j] = picture[i][j];
	    	  }
	      }
	      
	      
	      
	      for(int i=0; i<m; i++) {
	    	  for(int j=0; j<n; j++) {
	    		  max=0;
	    		  if(!isVisit[i][j] && map[i][j] != 0) {
	    			  dfs(i, j, map[i][j]);
	    			  numberOfArea++;
	    		  }
	    		  maxSizeOfOneArea = Math.max(maxSizeOfOneArea, max);
	    	  }
	    	  
	      }
	      
	      
	      int[] answer = new int[2];
	      answer[0] = numberOfArea;
	      answer[1] = maxSizeOfOneArea;
	      System.out.println(answer[0] + ":" + answer[1]);
	      return answer;
	  }
	
	public static void dfs(int x, int y, int pre) {
		max++;
		isVisit[x][y] = true;
		for(int i=0; i<4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			if(nx >= 0 && ny >= 0 && nx < row && ny < col) {
				if(!isVisit[nx][ny] && map[nx][ny] == pre & map[nx][ny] != 0) {
					dfs(nx, ny, map[nx][ny]);
				}
			}
		}
	}
		
}
