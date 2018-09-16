package Kakao.P2018;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class P1_3_ÈÄº¸Å° {
	public static void main(String args[]) {
//		solution(5, new int""{2,1,2,6,2,4,3,3});
		solution(new String[][]{{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}});
	}
	
	public static int solution(String[][] relation) {
        int n = relation.length;
        int m = relation[0].length;
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        for(int i=1; i<(1<<m); i++) {
        	Set<String> s = new HashSet<String>();
        	for(int j=0; j<n; j++) {
        		String now = "";
        		for(int k=0; k<m; k++) {
        			if( (i&(1<<k)) > 0 ) {
        				now+=relation[j][k];
        			}
        		}
        		s.add(now);
        	}
        	if(s.size()==n&&possi(list,i)) list.add(i);
        }
        System.out.println(list.size());
        return list.size();
    }
	
	public static boolean possi(ArrayList<Integer> list, int now) {
		for(int i=0; i<list.size(); i++) {
			if((list.get(i)&now)==list.get(i)) {
				return false;
			}
		}
		return true;
	}
}



