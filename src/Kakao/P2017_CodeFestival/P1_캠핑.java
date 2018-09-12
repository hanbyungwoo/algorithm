package Kakao.P2017_CodeFestival;

import java.util.Arrays;

public class P1_캠핑 {
	public static void main(String args[]) {
		solution(4, new int[][]{{0, 0},{1, 1},{0, 2},{2, 0}});
	}
	
	public static int solution(int n, int[][] data) {
	      int answer = 0;
	      
	      // x값 기준으로 정렬이 되나..?
	      Arrays.sort(data);
	      
	      for(int i=0; i<n; i++) {
	    	  for(int j=i+1; j<n; j++) {
	    		  int x1 = data[i][0];
	    		  int y1 = data[j][1];
	    		  int x2 = data[j][0];
	    		  int y2 = data[i][1];
//	    		  if(data[i][0]==x1)
	    	  }
	      }
	      
	      return answer;
	  }
}
	

