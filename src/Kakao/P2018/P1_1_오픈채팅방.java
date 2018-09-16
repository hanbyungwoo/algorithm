//https://github.com/baactree/PS/tree/master/kakaoblind2019

package Kakao.P2018;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class P1_1_����ä�ù� {
	public static void main(String args[]) {
		solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"});
	}
	
	public static String[] solution(String[] record) {
		String[] answer;
		
		// ����ID �г���
		HashMap<String, String> info = new HashMap<String, String>();
		// ����ID ���⿩��
		Queue<Enter> q = new LinkedList<Enter>();
		for(int i=0; i<record.length; i++) {
			String[] msg = record[i].split(" ");
			switch(msg[0]) {
			case "Enter" :	
				info.put(msg[1], msg[2]);
				q.add(new Enter(msg[1], 0));
				break;
			case "Leave" :
				q.add(new Enter(msg[1], 1));
				break;
			case "Change" :
				info.put(msg[1], msg[2]);
				break;
			default : break;
			}
					
		}
		
		answer = new String[q.size()];
		int cnt=0;
		while(!q.isEmpty()) {
			String id = q.peek().id;
			int inout = q.peek().isIn;
			q.poll();
			switch(inout) {
			case 0 :
				answer[cnt] = info.get(id) + "���� ���Խ��ϴ�.";
				break;
			case 1 :
				answer[cnt] = info.get(id) + "���� �������ϴ�.";
				break;
			}
			System.out.println(answer[cnt]);
			cnt++;
		}

		
        return answer;
	}
		
}

class Enter {
	String id;
	int isIn;
	public Enter(String id, int isIn) {
		this.id = id;
		this.isIn = isIn;
	}
}
