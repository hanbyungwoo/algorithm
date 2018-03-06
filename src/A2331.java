import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//https://www.acmicpc.net/problem/2331

//����
//������ ���� ���ǵ� ������ �ִ�.
//
//D[1] = A
//D[n] = D[n-1]�� �� �ڸ��� ���ڸ� P�� ���� ������ ��
//���� ��� A=57, P=2�� ��, ���� D�� {57, 74(=5^2+7^2=25+49), 65, 61, 37, 58, 89, 145, 42, 20, 4, 16, 37, ��}�� �ȴ�.
//�� �ڿ��� �ռ� ���� ����(57���Ͱ� �ƴ϶� 58����)�� �ݺ��ȴ�.
//
//�̿� ���� ������ ��� ���ϴ� ���� ������ �̿� ���� �ݺ������� �ȴ�. �� ��, �ݺ��Ǵ� �κ��� �������� ��, ������ ���� �Ǵ� ������ ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
//���� �������� {57, 74, 65, 61}�� �� ���� ���� ���� �ȴ�.
//
//�Է�
//ù° �ٿ� A(1��A��9999), P(1��P��5)�� �־�����.
//
//���
//ù° �ٿ� �ݺ��Ǵ� �κ��� �������� ��, ������ ���� �Ǵ� ������ ������ ����Ѵ�.

// ����
// 57 2
// ���
// 4

public class A2331 {
	
			
			
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
         
        int A=sc.nextInt();
        int P=sc.nextInt();
         
        map.put(A, 0);
        int cnt=1;
        int tmp=A;
        /*HashMap�� (���� D��, ��� ° ���� ������)�� �Է�
         * D�� ���ϰ� ���� ������ �ʿ� �ִ� ���̸� �� ���� data�� ��� �� ����
         */
        while(true){
            int D=0;
            while(tmp!=0){  //���� D ���ϱ�
                D+=Math.pow(tmp%10,P); // pow tmp%10�� P������
                tmp/=10;
            }
//            System.out.println(D);
            if(map.containsKey(D)){
                System.out.println(map.get(D));
                return;
            }
            map.put(D, cnt++);
            tmp=D;
        }
    }

}
