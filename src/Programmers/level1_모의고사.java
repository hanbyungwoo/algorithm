package Programmers;

import java.util.ArrayList;

public class level1_모의고사 {
	
	public static void main (String args[] ) {
		solution(new int[]{1,2,3,4,5});
		solution(new int[]{1,3,2,4,2});
		
	}

	public static int[] solution(int[] answers) {
		 int[] answer;
		 int stu1[] = {1,2,3,4,5};
		 int stu2[] = {2, 1, 2, 3, 2, 4, 2, 5};
		 int stu3[] = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		 int size1 = stu1.length;
		 int size2 = stu2.length;
		 int size3 = stu3.length;
		 int cnt1 = 0, cnt2 = 0, cnt3 = 0;
		 for(int i=0; i<answers.length; i++) {
			 if(answers[i] == stu1[i%size1]) {
				 cnt1++;
			 }
			 if(answers[i] == stu2[i%size2]) {
				 cnt2++;
			 }
			 if(answers[i] == stu3[i%size3]) {
				 cnt3++;
			 }
		 }
		 int max=0;
		 max = Math.max(cnt1, cnt2);
		 max = Math.max(max, cnt3);
		 int temp=0;
		 if(max == cnt1) {
			 temp++;
		 }
		 if(max == cnt2) {
			 temp++;
		 }
		 if(max == cnt3) {
			 temp++;
		 }
		 answer = new int[temp];
		 temp = 0;
		 if(max == cnt1) {
			 answer[temp++] = 1;
		 }
		 if(max == cnt2) {
			 answer[temp++] = 2;
		 }
		 if(max == cnt3) {
			 answer[temp++] = 3;
		 }
		 for(int i=0; i<temp; i++) {
			 System.out.print(answer[i]);			 
		 }
		 System.out.println();
		 
		 ArrayList<Integer> list = new ArrayList<>();
		 list.stream().mapToInt(i->i.intValue()).toArray();
		 
		 return answer;	
	}
	
}