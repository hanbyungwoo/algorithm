package Kakao.P2017_CodeFestival;

import java.util.Arrays;
import java.util.Comparator;

public class P1_ķ�� {
	public static void main(String args[]) {
		solution(4, new int[][]{{0, 0},{1, 1},{0, 2},{2, 0}});
	}
	
	public static int solution(int n, int[][] data) {
	      int answer = 0;
	      
	      // x�� �������� ������ �ǳ�..?
	      // ��ǥ�� x���� �������� �������� ����
	      sortArray(data);
	      
	      for(int i=0; i<n; i++){
	          for(int j=i; j<n; j++){
	              if(data[i][0] != data[j][0] && data[i][1] != data[j][1]){ // �� ���� ���Ⱑ �밢���� �̷��
	                  for(int k=j; k>=0; k--){ // x������ �� ���� ������ ����(��輱 ����)�� �����ϴ� ���⸦ ������� ���� �˻�
	                      if(data[k][0] < Math.max(data[i][0],data[j][0]) && // ���ο� �����ϴ��� �˻�
	                         data[k][0] > Math.min(data[i][0],data[j][0]) &&
	                         data[k][1] < Math.max(data[i][1],data[j][1]) &&
	                         data[k][1] > Math.min(data[i][1],data[j][1])) {
	                          answer--; // ���ο� �����ϸ� ���̳ʽ�
	                          break;
	                      }
	                  }
	                  answer++; // ���ο� ���Ⱑ ������ �÷���
	              }
	          }
	      }
	      System.out.println(answer);
	      return answer;
	}
	// n���� �迭 �����ϴ� ���...
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
	

