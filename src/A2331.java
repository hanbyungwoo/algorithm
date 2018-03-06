import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//https://www.acmicpc.net/problem/2331

//문제
//다음과 같이 정의된 수열이 있다.
//
//D[1] = A
//D[n] = D[n-1]의 각 자리의 숫자를 P번 곱한 수들의 합
//예를 들어 A=57, P=2일 때, 수열 D는 {57, 74(=5^2+7^2=25+49), 65, 61, 37, 58, 89, 145, 42, 20, 4, 16, 37, …}이 된다.
//그 뒤에는 앞서 나온 수들(57부터가 아니라 58부터)이 반복된다.
//
//이와 같은 수열을 계속 구하다 보면 언젠가 이와 같은 반복수열이 된다. 이 때, 반복되는 부분을 제외했을 때, 수열에 남게 되는 수들의 개수를 구하는 프로그램을 작성하시오.
//위의 예에서는 {57, 74, 65, 61}의 네 개의 수가 남게 된다.
//
//입력
//첫째 줄에 A(1≤A≤9999), P(1≤P≤5)가 주어진다.
//
//출력
//첫째 줄에 반복되는 부분을 제외했을 때, 수열에 남게 되는 수들의 개수를 출력한다.

// 예제
// 57 2
// 출력
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
        /*HashMap에 (구한 D값, 몇번 째 들어온 수인지)로 입력
         * D를 구하고 만약 기존에 맵에 있던 값이면 그 값의 data를 출력 후 리턴
         */
        while(true){
            int D=0;
            while(tmp!=0){  //다음 D 구하기
                D+=Math.pow(tmp%10,P); // pow tmp%10의 P제곱근
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
