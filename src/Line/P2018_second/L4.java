package Line.P2018_second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class L4 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		HashMap<String, String> map = new HashMap<String, String>();
		for(int i=0; i<n; i++) {
			String[] str = br.readLine().toString().split(" ");
			String[] req = str[1].split("/");
			if(str[0].equals("GET")) {
				if(req[1].equals("users")) {
					if(req.length < 4 || str.length > 2) {
						// ���� ���̵� �����ϴ� ��� �� �߸��� ���
						// data��û�ϴ� �ǵ�.. �߸��Ȱ�
						print(405);
						continue;
					}
					if(map.containsKey(req[2])) {
						// ���̵� �����ϴ� ���
						String temp = map.get(req[2]);
						if(temp == null) {
							// �޽��� �������
							print(404);
						} else {
							// �޽��� ����
							System.out.println("200 OK " + temp);
						}
					} else {
						// ���̵� ����
						print(403);
					}
				} else {
					print(404);
				}
			} else {	// POST�� ���
				if(req[1].equals("users")) {
					if(!map.containsKey(req[2]) && req.length < 4) {
						// ���̵� �������ϴ� ���
						map.put(req[2], null);
						print(201);
						continue;
					} else if(map.containsKey(req[2])&& req.length < 4) {
						// ���̵� �̹� �����ϴ� ���
						print(403);
					}
					if(req.length > 3 && req[3].equals("data")) {
						// data �߰��� ���� ���
						str[2] = str[2].replaceAll("value=", "");
						map.put(req[2], str[2]);
						print(200);
					} else {
						// GET��û�� ���.
						print(405);
					}
				} else {
					print(404);
				}
			}
			
			
			
		}
		
	}	
	
	public static void print(int number) {
		switch(number) {
		case 200 : System.out.println("200 OK"); break;
		case 201 : System.out.println("201 CREATED"); break;
		case 403 : System.out.println("403 FORBIDDEN"); break;
		case 404 : System.out.println("404 NOT_FOUND"); break;
		case 405 : System.out.println("405 METHOD_NOT_ALLOWED"); break;
		default : break;
		}
	}
}
