package infixTopostfix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * infix to postfix
 */
public class infix2postfix {
	public String input = null;		// 입력 문자열
	public stack stack = null;		// 스택
	public String output = null;	// 출력 문자열 (postfix)
	
	/**
	 * @param input
	 */
	public infix2postfix(String input) {
		this.input = input;
		this.stack = new stack();
		this.output = "";
	}
	
	/**
	 * 
	 */
	public infix2postfix() {
		System.out.print("infix 수식을 입력하시오 : ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			this.input = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ;
		}
		
		this.stack = new stack();
		this.output = "";
	}
	
	/**
	 * in2post()
	 */
	public void in2post() {
		for (int i = 0; i < this.input.length(); i++) {
			// 한글자씩 반복하기
			
			char c = input.charAt(i);	// 한글자씩 가져오기
			if (c >= '0' && c<= '9') {
				// 피연산자의 경우
				this.output += c;
			}
			else if (c == '+' || c == '-') {
				while (!this.stack.IsEmpty()) {
					// 기존 스택이 비어있지 않다면
					
					char prev_c = this.stack.pop();	// 스택 최상단의 연산자를 가져옴
					if (prev_c == '*' || prev_c == '/' || prev_c == '+' || prev_c == '-') {
						// 스택 최상단 연산자가 현재 연산자 보다 상위 연산자라면
						
						output += prev_c;                             
					}
					else {
						this.stack.push(prev_c);
						break;
					}
				}
				this.stack.push(c);
			}
			else if (c == '*' || c == '/') {
				while (!this.stack.IsEmpty()) {
					// 기존 스택이 비어있지 않다면
					
					char prev_c = this.stack.pop();  // 스택 최상단의 연산자를 가져옴
					if (prev_c == '*' || prev_c == '/')
                    {
                        // 스택 최상단 연산자가 현재 연산자 보다 상위 연산자라면
                        output += prev_c;
                    }
                    else
                    {
                    	this.stack.push(prev_c);
                        break;                            
                    }
				}
				this.stack.push(c);
			}
			else if (c == '(') {
                this.stack.push(c);
            }
            else if (c == ')') {
                while (true)
                {
                    char prev_oper = this.stack.pop();	// 기존 스택의 최상위 연산자를 꺼내온다. 
                    if (prev_oper == '(')
                        break;
                    output += prev_oper;	// 기존 스택의 최상위 연산자를 출력으로 빼낸다. 
                }
            }
		}
		
		// stack에 있는 모든 연산자를 순차적으로 꺼내서 output에 넣는다. 
        while (!this.stack.IsEmpty())
        {
            output += this.stack.pop();
        }
        
        // 결과 출력
        System.out.println(this.output);
	}
}









