package Kakao.P2017;

import java.util.ArrayList;

public class P3_3_���ϸ����� {
	public static void main (String args[] ) {
		solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"});
		solution(new String[]{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"});
	}
	
	
	public static String[] solution(String input[]) {
		ArrayList<File> list = new ArrayList<File>();
//		StringBuilder sb = new StringBuilder();
		String[] answer = new String[input.length];
		
		for(int i=0; i<input.length; i++) {
			int numStart=0;
			int numEnd=0;

			for(int j=0; j<input[i].length(); j++) {
				// ���ڰ� ������ ��ġ ã��
				
				if(numStart==0) {	// ���� �� �� �߰� �� �ڿ� �� ���ڳ����� ��� ����
					while(input[i].charAt(j)>='0' && input[i].charAt(j)<='9' && numEnd < 6) {
						if(numEnd==0) {
							numStart=j;
							numEnd = j;
						}
						numEnd++;
						j++;
					}
				}
			}
			
			list.add(new File(input[i].substring(0, numStart), input[i].substring(numStart, numEnd), input[i].substring(numEnd, input[i].length())));
		}
		int cnt=0;
		// list�� ���� �� ���� �� �� ����.
		for(int i=0; i<list.size();) {
			File temp = list.get(i);
			int min=-1;
			for(int j=i+1; j<list.size(); j++) {
				if(temp.compareTo(list.get(j)) <= 0) {	// j���� �� �۳�.
        			min = j;
        			temp = list.get(j);
        		}
			}
			if(min == -1) {
        		list.remove(i);
        	} else {
        		list.remove(min);
        	}
        	System.out.print("\""+ temp.toString()+ "\" ");
//			answer[cnt++] = temp.toString();
//        	sb.append("\""+temp.toString()+"\"");
		}
//		sb.append("\n");
		System.out.println();
		return answer;
	}
}
class File implements Comparable<File>{
	String name;
	String number;
	String tail;
	
	public File(String name, String number, String tail) {
		this.name = name;
		this.number = number;
		this.tail = tail;
	}
	
	@Override
	public String toString() {
		return String.format("%s%s%s", this.name, this.number, this.tail);
	}

	@Override
	public int compareTo(File o) {
		
		// �� �� ���̰� ���� ���ڿ��� ���̷� �����ش�.
		int x = this.name.length();
		int y = o.name.length();
		int min = x > y ? y : x;
		
		// �빮�ڼҹ��� �񱳾��� �ϱ� ���� UpperCase�� ��ȯ
		String temp = this.name.toUpperCase();
		String temp2 = o.name.toUpperCase();
		for(int i=0; i<min; i++) {
			if(temp.charAt(i) < temp2.charAt(i)) {	// this�� ���ڿ��� �� �տ���
				return 1;
			}
			if(temp.charAt(i) > temp2.charAt(i)) {	// o�� ���ڿ��� �� �տ���
				return -1;
			}
		}
		if(x!=y) {
			if( x > y ) {	// this�� ���ڿ��� �� ���.
				return -1;
			} else {	// 
				return 1;
			}
		}
		x = Integer.parseInt(this.number);
		y = Integer.parseInt(o.number);
		if(x < y) {	// this ���ڰ� �����Ƿ� �տ��´�.
			return 1;
		}
		if(x > y) {
			return -1;
		}
		
		
		
		// ���ڰ���. ���ڿ� ���� ��� tail�� ���ؾ���.
		// �� �� ���̰� ���� ���ڿ��� ���̷� �����ش�.
		x = this.tail.length();
		y = o.tail.length();
		min = x > y ? y : x;
		
		// �빮�ڼҹ��� �񱳾��� �ϱ� ���� UpperCase�� ��ȯ
		temp = this.tail.toUpperCase();
		temp2 = o.tail.toUpperCase();
		for(int i=0; i<min; i++) {
			if(temp.charAt(i) < temp2.charAt(i)) {	// this�� ���ڿ��� �� �տ���
				return 1;
			}
			if(temp.charAt(i) > temp2.charAt(i)) {	// o�� ���ڿ��� �� �տ���
				return -1;
			}
		}
		if(x!=y) {
			if( x > y ) {	// this�� ���ڿ��� �� ���.
				return -1;
			} else {	// 
				return 1;
			}
		}
	
 
		// ������ ���ڿ�~
		return 0;
	}
	
	
}
