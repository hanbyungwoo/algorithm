package Kakao.P2017;

import java.util.ArrayList;
import java.util.HashMap;

public class P3_2_���� {
	static HashMap<String, Integer> dic;
	public static void main (String args[] ) {
		
		
		
		solution("TOBEORNOTTOBEORTOBEORNOT");
//		solution("KAKAO");
//		solution("ABABABABABABABAB");
	}
	
	
	public static int[] solution(String msg) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int answer[];
		int answer_cnt=0;
		dic = new HashMap<String, Integer>();
		
		char alpa = 'A';
		for(int i=1; i<=26; i++) {
			dic.put(alpa+"", i);
			alpa++;
		}
		
		int cnt = 27;
		char temp[] = msg.toCharArray();
		for(int i=0; i<temp.length; i++) {
			
			for(int j=i+1; j<=temp.length; j++) {
				String str = msg.substring(i, j);
				
				if(dic.containsKey(str)) {
					// �ش� ���ڿ� �̹� ����
					int x = j;
					String pre=str;
					if(x!=msg.length()) {
						pre= pre+msg.charAt(x);
					
						
						while(true) {
							x++;
							if(dic.containsKey(pre)) {
								if(x==msg.length()) {
									j=x;
									break;
								}
								pre = pre + msg.charAt(x);
							} else {
								StringBuffer br = new StringBuffer(pre);
								br.deleteCharAt(br.toString().length()-1);
								pre = br.toString();
								j = x-1;
								break;
							}
							
						}
					}
					//str+=temp[j];
					list.add(dic.get(pre));
					
//					System.out.println(dic.get(pre));
					// ���ڿ� �̹� �����ϱ� ����ϰ� 
					if(j==msg.length()) {
						i=j;
						break;
					}
					
				} else {
					// ������ �������� ���� ���
					//int value = dic.get(str.substring(0, str.length()-1)) + dic.get(str.charAt(str.length()-1)+"");
					dic.put(str, cnt++);
					i=j-2;
					break;
					
				}
			}
			
		}
		answer = new int[list.size()];
		for(int i=0; i<list.size(); i++) {
			answer[i] = list.get(i);
		}
		
		
		return answer;
	}
}
