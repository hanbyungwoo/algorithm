package Kakao.P2017_CodeFestival;

import java.util.Arrays;
import java.util.Comparator;

public class P1_캠핑 {
	public static void main(String args[]) {
		solution(4, new int[][]{{0, 0},{1, 1},{0, 2},{2, 0}});
	}
	
	public static int solution(int n, int[][] data) {
	      int answer = 0;
	      
	      // x값 기준으로 정렬이 되나..?
	      // 좌표를 x값을 기준으로 오름차순 정렬
	      sortArray(data);
	      
	      for(int i=0; i<n; i++){
	          for(int j=i; j<n; j++){
	              if(data[i][0] != data[j][0] && data[i][1] != data[j][1]){ // 두 쌍의 쐐기가 대각선을 이루면
	                  for(int k=j; k>=0; k--){ // x축으로 두 쌍의 쐐기의 내부(경계선 포함)에 존재하는 쐐기를 대상으로 조건 검사
	                      if(data[k][0] < Math.max(data[i][0],data[j][0]) && // 내부에 존재하는지 검사
	                         data[k][0] > Math.min(data[i][0],data[j][0]) &&
	                         data[k][1] < Math.max(data[i][1],data[j][1]) &&
	                         data[k][1] > Math.min(data[i][1],data[j][1])) {
	                          answer--; // 내부에 존재하면 마이너스
	                          break;
	                      }
	                  }
	                  answer++; // 내부에 쐐기가 없으면 플러스
	              }
	          }
	      }
	      System.out.println(answer);
	      return answer;
	}
	// n차원 배열 정렬하는 방법...
	public static void sortArray(int[][] data) { 
		Arrays.sort(data, new Comparator<int[]>() {
			@Override
			public int compare(int[] arr1, int[] arr2) {
				if( ((Comparable<Integer>)arr1[0]).compareTo(arr2[0]) < 0 )
					return 1;
				else
					return -1;
			}
		});
	}
}
	

