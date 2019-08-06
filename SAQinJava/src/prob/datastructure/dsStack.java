package prob.datastructure;

import java.util.Stack;

/*
 	[����(Stack)]
 	- �� �� ���⿡���� �������� ���԰� ������ �̷������ �ڷᱸ���̴�.
 	- ��������(First In, Last Out:FIFO), ���Լ���(Last In, First Out:LIFO) ������ ������.
 	
 	* [java lib - ����(Stack) ���� �޼ҵ�]
 	- push(E item)
 		�ش� item�� Stack�� top �� ����
 		
 	- pop()
 		Stack�� top�� �ִ� item�� �����ϰ� �ش� item�� ��ȯ
 	
 	- peek()
 		Stack�� top�� �մ� item �� ���������ʰ� �ش� item�� ��ȯ
 		
 	- isEmpty()
 		Stack�� ��������� true�� ��ȯ�ϰ� �׷��� ������ false�� ��ȯ
 		
 	- search(Object o)
 		�ش� Object�� ��ġ�� ��ȯ
 		Stack�� top ��ġ�� 1, �ش� Object �� ������ -1�� ��ȯ
 */
public class dsStack {
	static Stack<Integer> stk;
	public static void main(String[] args) {
		stk = new Stack <Integer>();
		// stack �ʱ�ȭ
		stk.clear();
		// stack�� ������ 10, 20, 30 ����
		stk.add(10);
		stk.add(20);
		stk.add(30);
		// stack�� size ���
		System.out.println("stk.size : " + stk.size());
		// stack���� ������ Ȯ��
		System.out.println("data(peek) : " + stk.peek());
		// stack���� ������ Ȯ�� �� ����
		System.out.println("data(pop)  : " + stk.pop());
		System.out.println("data(pop)  : " + stk.pop());
		System.out.println("data(pop)  : " + stk.pop());
		// stack�� �ƹ��͵� ������ Ȯ��
		if(stk.isEmpty())
			System.out.println("stack is empty");
	}
	
}













