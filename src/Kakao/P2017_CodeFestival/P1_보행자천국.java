package Kakao.P2017_CodeFestival;


public class P1_보행자천국 {
	public static void main(String args[]) {
//		solution(3, 3, new int[][]{{0,0,0},{0,0,0},{0,0,0}});
		solution(3, 6, new int[][]{{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}});
	}
	static int MOD = 20170805;
	public static int solution(int m, int n, int[][] cityMap) {
	      int answer=0;
	      
	      int r[][] = new int[m+1][n+1];
	      int b[][] = new int[m+1][n+1];
	      r[1][1] = 1;
	      b[1][1] = 1;
	      
	      for(int i=1; i<=m; i++) {
	    	  for(int j=1; j<=n; j++) {
	    		  if(cityMap[i-1][j-1]==0) {
	    			  // 0인 경우 왼쪽이나 위쪽 오는 경우 다 더함
	    			  r[i][j] = (r[i][j]+r[i][j-1]+b[i-1][j])%MOD;
	    			  b[i][j] = (b[i][j]+r[i][j-1]+b[i-1][j])%MOD;
	    		  }
	    		  else if(cityMap[i-1][j-1]==1) {
	    			  r[i][j] = 0;
	    			  b[i][j] = 0;
	    		  }
	    		  else {
	    			  r[i][j] = r[i][j-1];
	    			  b[i][j] = b[i-1][j];
	    		  }
	    	  }
	      }
	      answer = (r[m][n-1]+b[m-1][n])%MOD;
	      System.out.println(answer);
	      return answer;
	      
	  }
}
	

