package Kakao.P2017;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class P1_7_�߼�Ʈ���� {
	public static void main (String args[] ) {
//		solution(new String[]{"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"});
		// 1
		solution(new String[]{"2016-09-15 01:00:04.002 2.0s" ,"2016-09-15 01:00:07.000 2s"});
		// 2
	}
	
	public static int solution(String[] lines) {
		int answer = 0;
		
		ArrayList<Long> checkPoint = new ArrayList<Long>();
		ArrayList<Log> logs = new ArrayList<Log>();
		
		for(int i=0; i<lines.length; i++) {
			Log log = new Log(lines[i]);
			
			checkPoint.add(log.start);
			checkPoint.add(log.end);
			logs.add(log);
		}
		
		// �ð� �� ����
		Collections.sort(checkPoint);
		
		int max=0;
		for(int i=0; i<checkPoint.size(); i++) {
			int count=0;
			for(Log log : logs) {
				// ���� �ð��� ���� + 999�� ���ϸ� 1000 --> 1����
				if(log.isln(checkPoint.get(i), checkPoint.get(i)+999)) {
					count++;
				}
			}
			if(count > max) {
				max = count;
			}
		}

		
		answer = max;
		System.out.println(answer);
	    return answer;
	}
}

class Log {
	long start=0;
	long end=0;
	long during=0;
	
	public Log(String str) {
		String[] split = str.split(" ");
		String dateString = split[0] + " " + split[1];
		try {
			Date startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(dateString);
			this.end = startDate.getTime();
			
			String[] split2 = split[2].split("s");
			double parseDouble = Double.parseDouble(split2[0]);
			// �Ҽ��� 3�ڸ����� �ϱ� ������
			this.during = (long)(parseDouble*1000);
			
			this.start = this.end - this.during + 1;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean isln(long checkStart, long checkEnd) {
		// �ش� ������ ���ԵǴ��� Ȯ��
		if(this.end < checkStart || this.start > checkEnd) {
			return false;
		} else {
			return true;
		}
	}
}
