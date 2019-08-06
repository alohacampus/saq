package prob.datastructure;

import java.util.Stack;

/*
 	[스택(Stack)]
 	- 한 쪽 방향에서만 데이터의 삽입과 삭제가 이루어지는 자료구조이다.
 	- 선입후출(First In, Last Out:FIFO), 후입선출(Last In, First Out:LIFO) 구조를 가진다.
 	
 	* [java lib - 스택(Stack) 관련 메소드]
 	- push(E item)
 		해당 item을 Stack의 top 에 삽입
 		
 	- pop()
 		Stack의 top에 있는 item을 삭제하고 해당 item을 반환
 	
 	- peek()
 		Stack의 top에 잇는 item 을 삭제하지않고 해당 item을 반환
 		
 	- isEmpty()
 		Stack이 비어있으면 true를 반환하고 그렇지 않으면 false를 반환
 		
 	- search(Object o)
 		해당 Object의 위치를 반환
 		Stack의 top 위치는 1, 해당 Object 가 없으면 -1을 반환
 */
public class dsStack {
	static Stack<Integer> stk;
	public static void main(String[] args) {
		stk = new Stack <Integer>();
		// stack 초기화
		stk.clear();
		// stack에 데이터 10, 20, 30 삽입
		stk.add(10);
		stk.add(20);
		stk.add(30);
		// stack의 size 출력
		System.out.println("stk.size : " + stk.size());
		// stack에서 데이터 확인
		System.out.println("data(peek) : " + stk.peek());
		// stack에서 데이터 확인 및 제거
		System.out.println("data(pop)  : " + stk.pop());
		System.out.println("data(pop)  : " + stk.pop());
		System.out.println("data(pop)  : " + stk.pop());
		// stack에 아무것도 없는지 확인
		if(stk.isEmpty())
			System.out.println("stack is empty");
	}
	
}













