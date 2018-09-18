package Kakao.P2018;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class P1_3_후보키2 {
	public static void main(String args[]) {
//		solution(5, new int""{2,1,2,6,2,4,3,3});
		solution(new String[][]{{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}});
	}
	
	static boolean isCheck[];
	static int n, m;
	static ArrayList<Integer> arr;
	public static int solution(String[][] relation) {
        n = relation.length;		// n개의 데이터
        m = relation[0].length;		// m개의 컬럼
        arr = new ArrayList<Integer>();
        
        isCheck = new boolean[m];
        for(int i=0; i<m; i++) {
        	isCheck[i] = true;
        	dfs(1, 0, relation);
        	isCheck[i] = false;
        			
        }
        
        return arr.size();
    }
	
	public static void dfs(int index, int depth, String[][] relation) {
		if(depth > relation[0].length) {
			return;
		}
		
		Set<String> s = new HashSet<String>();
		for(int i=0; i<relation.length; i++) {
			String str="";
			for(int j=0; j<relation[i].length; j++) { 
				if(isCheck[j]) {
					str+=relation[i][j];
				}
			}
			s.add(str);
		}
		// 후보키가 가능할 수 도 있는 것 (아직 최소성은 확인하지 않음)
		if(s.size() == relation.length) {
//////////////////////////////////////////////////////////////////중요함
//////////////////////////////////////////////////////////////////중요함
//////////////////////////////////////////////////////////////////중요함
//////////////////////////////////////////////////////////////////중요함
//////////////////////////////////////////////////////////////////중요함
			int val=0;
			for(int i=0; i<relation[i].length; i++) {
				if(isCheck[i]) val+=(1<<i);
			}
			boolean ch=true;
			for(int i=0; i<arr.size(); i++) {
				if((arr.get(i)&val) == arr.get(i)) {
					ch = false;
				}
				
			}
			if(ch) {
				System.out.println(s.toString());
				arr.add(val);
			}
//////////////////////////////////////////////////////////////////중요함
//////////////////////////////////////////////////////////////////중요함
//////////////////////////////////////////////////////////////////중요함
//////////////////////////////////////////////////////////////////중요함
//////////////////////////////////////////////////////////////////중요함
		}
		for(int i=index+1; i<relation[0].length; i++) {
			if(!isCheck[i]) {
				isCheck[i] = true;
				dfs(i, depth+1, relation);
				isCheck[i] = false;
			}
		}
	}
}



